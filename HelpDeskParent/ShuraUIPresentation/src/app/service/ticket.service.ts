import { Injectable } from '@angular/core';
import { TicketPriority } from '../model/ticket-priority';
import { TicketSeverity } from '../model/ticket-severity';
import { Ticket } from '../model/ticket';
import { Workflow } from '../model/workflow';
import { TicketSeverityList } from '../constdata/ticket-severity';
import { TicketPriorityList } from '../constdata/ticket-priority';
import {  Observable, of } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { HttpClient,  HttpHeaders } from '@angular/common/http';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Headers, Http, RequestOptions } from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  private headers = new HttpHeaders( { 'Content-Type': 'application/json' } );

  
  
  constructor(private _http: HttpClient) { }


  getTicketSeverity(): Observable<TicketSeverity[]>
    {

      return this._http.get<TicketSeverity[]>('http://localhost:8082/HelpDeskIntegrationAPI/ticketseverity', {
        headers: this.headers
      })
        .pipe(
          //catchError(/*this.handleError('addHero', ticket)*/)
        );
    }

    getWorkflow(): Observable<Workflow[]>
    {

      return this._http.get<Workflow[]>('http://localhost:8082/HelpDeskIntegrationAPI/workflow', {
        headers: this.headers
      })
        .pipe(
          //catchError(/*this.handleError('addHero', ticket)*/)
        );
      
    }


    getTicketPriority(): Observable<TicketPriority[]>
    {

      return this._http.get<TicketPriority[]>('http://localhost:8082/HelpDeskIntegrationAPI/ticketpriority', {
        headers: this.headers
      })
        .pipe(
          //catchError(/*this.handleError('addHero', ticket)*/)
        );
    } 
    addTicket (ticket: Ticket): Observable<Ticket> {
      return this._http.post<Ticket>('http://localhost:8082/HelpDeskIntegrationAPI/ticket', ticket, {
        headers: this.headers
      })
        .pipe(
         // catchError(alert('Kindly, fill mandatory data and retry'))
        );
    }
}
