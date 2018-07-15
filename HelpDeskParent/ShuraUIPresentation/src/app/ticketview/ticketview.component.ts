import { Component, OnDestroy, OnInit , Inject} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import {DialogOverviewExample, DialogOverviewExampleDialog} from '../main/dialog-overview/dialog-overview-example.component';
import { FuseConfigService } from '@fuse/services/config.service';
import { fuseAnimations } from '@fuse/animations';

import { LoginService } from '../services/login.service';
import { User } from '../models/user.model';
import { Auth } from '../models/auth.model';
import { LoginParam } from '../models/login.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AfterViewInit, ViewChild} from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource, MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { merge, Observable, of as observableOf} from 'rxjs';
import { catchError, map, startWith, switchMap} from 'rxjs/operators'
import { Ticket } from '../models/ticket';
import { TicketService } from './ticketview.service';
import { Location } from '../../../node_modules/@angular/common';



@Component({
    selector: 'ticketview',
    templateUrl: './ticketview.component.html',
    styleUrls: ['./ticketview.component.scss'],
    animations: fuseAnimations
})


    export class TicketViewComponent implements OnInit , AfterViewInit{
       
      deleteComment: string;
    ngOnInit(){
      this.ngAfterViewInit();
     }

    tickets: TicketDetails[];

       
  displayedColumns = ['ticketId', 'creationdate', 'description', 'status', 'title', 'ticketnumber','item'];
  exampleDatabase: ExampleHttpDao | null;
  dataSource = new MatTableDataSource();

  resultsLength = 0;
  isLoadingResults = true;
  isRateLimitReached = false;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(DialogOverviewExampleDialog) child;

  constructor(private http: HttpClient,private ticketService: TicketService,public dialog: MatDialog) {}

  ngAfterViewInit() {
    this.exampleDatabase = new ExampleHttpDao(this.http);

    // If the user changes the sort order, reset back to the first page.
    this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);

    merge(this.sort.sortChange, this.paginator.page)
      .pipe(
        startWith({}),
        switchMap(() => {
          this.isLoadingResults = true;
          return this.exampleDatabase!.getRepoIssues(
            this.sort.active, this.sort.direction, this.paginator.pageIndex);
        }),
        map(data => {
          // Flip flag to show that loading has finished.
          this.isLoadingResults = false;
          this.isRateLimitReached = false;
          //this.resultsLength = data.total_count;
          return data;
        }),
        catchError(() => {
          this.isLoadingResults = false;
          // Catch if the GitHub API has reached its rate limit. Return empty data.
          this.isRateLimitReached = true;
          return observableOf([]);
        })
      ).subscribe(data => this.dataSource.data = data);
  }
  delete(ticket: TicketDetails): void {
    this.dataSource.data = this.dataSource.data.filter(h => h !== ticket);
    this.ticketService.deleteTicket(ticket).subscribe();
    location.reload;
  }
  openDialog(ticket: TicketDetails): void {
    let dialogRef = this.dialog.open(DialogOverviewExample, {
      width: '250px',
      data: { name: this.deleteComment }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
    });
  }

}

//const ELEMENT_DATA: TicketDetails[] = [
  //{ticketId: 1, creationdate: 'Hydrogen', description: 1.0079, status: 'H',title: 1.0079, ticketnumber: 'H'},
//]

export interface TicketDetails{
  ticketId: number;
  creationdate: string;
  description: string;
  status: string;
  title: string;
  ticketnumber: string;
}

/** An example database that the data source uses to retrieve data for the table. */
export class ExampleHttpDao implements OnInit{
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) {}
    
   ngOnInit(){}

  getRepoIssues(sort: string, order: string, page: number): Observable<TicketDetails[]> {
    const href = 'http://192.168.3.164:8082/HelpDeskIntegrationAPI/tickets';
    let identifier = "PROJECT_NAME";
    let value = "sbmhelpdesk";
    const requestUrl =`${href}?identifier=`+identifier+`&value=`+value;

    return this.http.get<TicketDetails[]>(requestUrl,{headers:this.headers});
  }



}
