import { Component, OnDestroy, OnInit, TemplateRef, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { DialogOverviewExampleDialog } from '../main/dialog-overview/dialog-overview-example.component';
import { FuseConfigService } from '@fuse/services/config.service';
import { fuseAnimations } from '@fuse/animations';

import { LoginService } from '../services/login.service';
import { User } from '../models/user.model';
import { Auth } from '../models/auth.model';
import { LoginParam } from '../models/login.model';
import { DataSource } from '@angular/cdk/collections';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource, MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { merge, Observable, of as observableOf } from 'rxjs';
import { catchError, map, startWith, switchMap } from 'rxjs/operators'
import { Ticket } from '../models/ticket';
import { TicketViewService } from './ticketview.service';
import { Location } from '@angular/common';
import { SharedDataService } from '../services/shared-data.service';
import { TicketService } from '../services/ticket.service';



@Component({
  selector: 'ticketview',
  templateUrl: './ticketview.component.html',
  styleUrls: ['./ticketview.component.scss'],
  animations: fuseAnimations
})


export class TicketViewComponent implements OnInit, AfterViewInit {

  noTickets:boolean = false;
  //child: DialogOverviewExampleDialog;
  deleteComment: string;
  deleteDialogName: string = "Delete";
  deleteDialogMessage: string = "Are you sure you want to delete this item ?";
  deleteDialogOkLabel: string = "Ok";
  deleteDialogCancelLabel: string = "Cancel";
  deleteConfirmed: boolean = false;




  @ViewChild('dialogContent')
  dialogContent: TemplateRef<any>;


  ngOnInit() {
    console.log('on init');
    this.ngAfterViewInit();

  }

  deleted: boolean;


  displayedColumns = ['creationdate', 'description', 'status', 'title', 'ticketnumber', 'item'];
  tickets = new MatTableDataSource();

  contacts: any;
  user: any;
  selectedContacts: any[];
  checkboxes: {};
  dialogRef: any


  resultsLength = 0;
  isLoadingResults = true;
  isRateLimitReached = false;


  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  projectName: string = this._shareData.selectedProject.name;
  userEmail: string = this._shareData.user.emailAddress;

  allTickets: TicketResponse = new TicketResponse();






  constructor(private http: HttpClient, private ticketViewService: TicketViewService, public dialog: MatDialog, private _shareData: SharedDataService, public _matDialog: MatDialog, private ticketService: TicketService
    ,private router: Router,private route: ActivatedRoute) {

  }

  ngAfterViewInit() {


    console.log('on after view init');




    this.ticketService.getTicketsByProjectName(this.projectName).subscribe(_TicketResponse => {
      this.allTickets = _TicketResponse;

      for (let index = 0; index < _TicketResponse.data.length; index++) {

        // this.allTickets.data.push( _TicketResponse.data[index]);
        this.allTickets.data[index].creationdate;
      }

      this.tickets.data = this.allTickets.data;
      //this.tickets.data[0].creationdate == "";
      this.isLoadingResults = false;
    }, _catchError =>{
      this.isLoadingResults = false;
      this.noTickets = true;
    });


  }
  updateTicket(ticket: TicketDetails):void{
    console.log("ticket : " + ticket);
    this.router.navigate(['/submitTicket/'+ticket.ticketId]);//submitTicket?id={{ row.ticketId }}
  }

  delete(ticket: TicketDetails): void {
    this.tickets.data = this.tickets.data.filter(h => h !== ticket);
    this.ticketViewService.deleteTicket(ticket).subscribe(success =>{
      alert('Ticket Deleted Successfully');
    },_error=>{
      alert('Unfortunately, Ticket was not Deleted');
    });
    location.reload;
  }



  openDialog(ticket: TicketDetails): void {
    let dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
      width: '250px',
      data: { dialogName: this.deleteDialogName, dialogMessage: this.deleteDialogMessage, dialogOkLabel: this.deleteDialogOkLabel, dialogCancelLabel: this.deleteDialogCancelLabel, confirmed: this.deleteConfirmed, confirmationComment: this.deleteComment }
    });


    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      if(result.confirmationComment != null && result.confirmationComment != ""){
      this.deleteConfirmed = result.confirmed;
      console.log(this.deleteConfirmed);
      if (this.deleteConfirmed){
        this.delete(ticket);
      }}
      else
      alert('You have to add a comment before delete a ticket');
    });

  }

}

//const ELEMENT_DATA: TicketDetails[] = [
//{ticketId: 1, creationdate: 'Hydrogen', description: 1.0079, status: 'H',title: 1.0079, ticketnumber: 'H'},
//]

export class TicketDetails {
  ticketId: number;
  creationdate: string;
  description: string;
  status: string;
  title: string;
  ticketnumber: string;
}

export class TicketResponse {
  status: object;
  data: TicketDetails[];
}

/* /** An example database that the data source uses to retrieve data for the table. 
export class ExampleHttpDao implements OnInit {



  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient, private _sharedService: SharedDataService) { }

  ngOnInit() { }


  getRepoIssues(sort: string, order: string, page: number): Observable<TicketResponse[]> {
    const href = 'http://localhost:8081/HelpDeskIntegrationAPI/api/ticket/ticketbyproidanduser';

    const requestUrl = `${href}?PROJECT_ID=` + this.projectId + `&USER_EMAIL=ahmed.farrag`;

    return this.http.get<TicketResponse[]>(requestUrl, { headers: this.headers });
  }



}*/