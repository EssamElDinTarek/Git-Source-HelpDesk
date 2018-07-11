import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { FuseConfigService } from '@fuse/services/config.service';
import { fuseAnimations } from '@fuse/animations';

import { LoginService } from '../services/login.service';
import { User } from '../models/user.model';
import { Auth } from '../models/auth.model';
import { LoginParam } from '../models/login.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {AfterViewInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {merge, Observable, of as observableOf} from 'rxjs';
import {catchError, map, startWith, switchMap} from 'rxjs/operators'

@Component({
    selector: 'ticketview',
    templateUrl: './ticketview.component.html',
    styleUrls: ['./ticketview.component.scss'],
    animations: fuseAnimations
})


    export class TicketViewComponent implements OnInit,  AfterViewInit {
       
  
    ngOnInit(){}
       
  displayedColumns = ['ticketId', 'creationdate', 'description', 'status', 'title', 'ticketnumber'];
  exampleDatabase: ExampleHttpDao | null;
  dataSource = new MatTableDataSource();

  resultsLength = 0;
  isLoadingResults = true;
  isRateLimitReached = false;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private http: HttpClient) {}

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
}

export interface TicketDetails {
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
    const href = 'http://localhost:8081/HelpDeskIntegrationAPI/ticket';
    const requestUrl =
        `${href}?projectname=project1`;

    return this.http.get<TicketDetails[]>(requestUrl,{headers:this.headers});
  }
}
