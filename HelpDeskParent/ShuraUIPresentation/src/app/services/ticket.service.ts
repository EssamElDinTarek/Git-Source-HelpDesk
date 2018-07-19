import { Injectable } from '@angular/core';
import { TicketPriority } from '../models/ticket-priority';
import { TicketSeverity } from '../models/ticket-severity';
import { Ticket } from '../models/ticket';
import { Workflow } from '../models/workflow';
import { TicketSeverityList } from '../constdata/ticket-severity';
import { TicketPriorityList } from '../constdata/ticket-priority';
import { Observable, of } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Headers, Http, RequestOptions } from '@angular/http';
import { User } from '../models/user';
import { SharedDataService } from './shared-data.service';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  apiEndPoint:string;



  constructor(private _http: HttpClient, private _shredData: SharedDataService) { }


  getTicketSeverity(): Observable<TicketSeverity[]> {

    return this._http.get<TicketSeverity[]>('http://192.168.3.164:8082/HelpDeskIntegrationAPI/ticketseverity', {
      headers: this.headers
    })
      .pipe(
        //catchError(/*this.handleError('addHero', ticket)*/)
      );
  }
  getUserDetails(): Observable<User> {

    return this._http.get<User>('http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/getUserByEmail?value=ahmed.farrag', {
      headers: this.headers
    })
      .pipe(
        //catchError(/*this.handleError('addHero', ticket)*/)
      );
  }
  getWorkflow(): Observable<Workflow[]> {

    return this._http.get<Workflow[]>('http://192.168.3.164:8082/HelpDeskIntegrationAPI/workflow', {
      headers: this.headers
    })
      .pipe(
        //catchError(/*this.handleError('addHero', ticket)*/)
      );

  }

  getTicketById(value: string): Observable<Ticket> {
    const href = 'http://192.168.3.164:8082/HelpDeskIntegrationAPI/ticket';
    let identifier = "TICKET_ID";
    //let value = "1953";
    const requestUrl = `${href}?identifier=` + identifier + `&value=` + value;

    return this._http.get<Ticket>(requestUrl, {
      headers: this.headers
    })
      .pipe(
        //catchError(/*this.handleError('addHero', ticket)*/)
      );

  }


  getTicketPriority(): Observable<TicketPriority[]> {

    return this._http.get<TicketPriority[]>('http://192.168.3.164:8082/HelpDeskIntegrationAPI/ticketpriority', {
      headers: this.headers
    })
      .pipe(
        //catchError(/*this.handleError('addHero', ticket)*/)
      );
  }
  addTicket(formData: FormData): Observable<Ticket> {
    return this._http.post<Ticket>('http://192.168.3.164:8082/HelpDeskIntegrationAPI/ticket', formData, {
     
    })
      .pipe(
        // catchError(alert('Kindly, fill mandatory data and retry'))
      );
  }

  
  editTicket(ticket: Ticket): Observable<Ticket> {
    return this._http.put<Ticket>('http://192.168.3.164:8082/HelpDeskIntegrationAPI/ticket', ticket, {
      headers: this.headers
    })
      .pipe(
        // catchError(alert('Kindly, fill mandatory data and retry'))
      );
  }

  /* addAttachment(formData: FormData): Observable<FormData> {
    headers.append('Content-Type', 'undefined');
            headers.append('Accept', 'application/json');
    this.apiEndPoint = 'http://192.168.3.164:8082/HelpDeskIntegrationAPI/ticket';
    return this._http.post<FormData>(`${this.apiEndPoint}`, formData, {
      headers: this.headers
    })
      .pipe(
        // catchError(alert('Kindly, fill mandatory data and retry'))
      );
  } */
}
