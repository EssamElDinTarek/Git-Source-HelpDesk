import { Injectable } from '@angular/core';
import { TicketPriority } from '../models/ticket-priority';
import { TicketSeverity } from '../models/ticket-severity';
import { Ticket } from '../models/ticket';
import { Workflow } from '../models/workflow';
import { TicketSeverityList } from '../constdata/ticket-severity';
import { TicketPriorityList } from '../constdata/ticket-priority';
import { catchError, retry } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Headers, Http, RequestOptions } from '@angular/http';
import { User } from '../models/user';
import { SharedDataService } from './shared-data.service';
import { BehaviorSubject, of, Observable, Subject } from 'rxjs';


import { FuseUtils } from '@fuse/utils';
import { TicketResponse, TicketDetails } from '../ticketview/ticketview.component';
import { PriorityResponse, WorkFlowResponse, SeverityResponse, UpdatedTicketResponse } from '../main/ticket/submitticket/submitTicket.component';
import { WeatherModel } from '../models/WeatherModel';



@Injectable({
    providedIn: 'root'
})
export class TicketService //implements Resolve<any>
{
    onTicketsChanged: BehaviorSubject<any>;
    onSelectedTicketsChanged: BehaviorSubject<any>;
    onUserDataChanged: BehaviorSubject<any>;
    onSearchTextChanged: Subject<any>;
    onFilterChanged: Subject<any>;

    private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    apiEndPoint: string;



    tickets: Ticket[];
    user: any;
    selectedTickets: number[] = [];

    searchText: string;
    filterBy: string;
    url:any;

    /**
     * Constructor
     *
     * @param {HttpClient} _httpClient
     */
    constructor(private _httpClient: HttpClient) {
        // Set the defaults

        this.onTicketsChanged = new BehaviorSubject([]);
        this.onSelectedTicketsChanged = new BehaviorSubject([]);
        this.onUserDataChanged = new BehaviorSubject([]);
        this.onSearchTextChanged = new Subject();
        this.onFilterChanged = new Subject();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * Resolver
     *
     * @param {ActivatedRouteSnapshot} route
     * @param {RouterStateSnapshot} state
     * @returns {Observable<any> | Promise<any> | any}
     */
    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> | Promise<any> | any {
        return new Promise((resolve, reject) => {

            Promise.all([
                this.getTickets(),
              //  this.getTicketsByProjectID()
            ]).then(
                ([files]) => {

                    resolve();

                },
                reject
            );
        });
    }

    /**
     * Get tickets
     *
     * @returns {Promise<any>}
     */

    getTickets(){
        console.log('from ticket service..!');
         this.getTicketsByProjectID;

        return new Promise((resolve, reject) => {

            /*   this._httpClient.get('getTicketsByProjectID()').subscribe(response=>{
                  debugger;
                  this.tickets=response;
                  console.log("tickets : "+this.tickets);

              });

   */

          /*   this.getTicketsByProjectID().subscribe(_tickets => {
                this.tickets = _tickets.data;
                console.log(_tickets.data);

            }); */

           /*  this._httpClient.get('api/contacts-contacts')
                    .subscribe((response: any) => {

                        this.tickets = response;

                    if (this.filterBy === 'starred') {
                            this.tickets = this.tickets.filter(_ticket => {
                            return this.user.starred.includes(_ticket.ticketId);
                            });
                        }

                    if (this.filterBy === 'frequent') {
                        this.tickets = this.tickets.filter(_tickets => {
                            return this.user.frequentContacts.includes(_tickets.ticketId);
                            });
                        }

                    if (this.searchText && this.searchText !== '') {
                            this.tickets = FuseUtils.filterArrayByString(this.tickets, this.searchText);
                        }

                        this.tickets = this.tickets.map(ticket => {
                        return new Ticket();
                        });

                        this.onTicketsChanged.next(this.tickets);
                        resolve(this.tickets);
                }, reject); */
            }
        );
    }

    /**
     * Get user data
     *
     * @returns {Promise<any>}
     */
    getUserData(): Promise<any> {
        return new Promise((resolve, reject) => {
            this._httpClient.get('api/tickets-user/5725a6802d10e277a0f35724')
                .subscribe((response: any) => {
                    this.user = response;
                    this.onUserDataChanged.next(this.user);
                    resolve(this.user);
                }, reject);
        }
        );
    }

    /**
     * Toggle selected ticket by id
     *
     * @param id
     */
    toggleSelectedTicket(id): void {
        // First, check if we already have that ticket as selected...
        if (this.selectedTickets.length > 0) {
            const index = this.selectedTickets.indexOf(id);

            if (index !== -1) {
                this.selectedTickets.splice(index, 1);

                // Trigger the next event
                this.onSelectedTicketsChanged.next(this.selectedTickets);

                // Return
                return;
            }
        }

        // If we don't have it, push as selected
        this.selectedTickets.push(id);

        // Trigger the next event
        this.onSelectedTicketsChanged.next(this.selectedTickets);
    }

    /**
     * Toggle select all
     */
    toggleSelectAll(): void {
        if (this.selectedTickets.length > 0) {
            this.deselectTickets();
        }
        else {
            // this.selectTickets();
        }
    }

    /**
     * Select tickets
     *
     * @param filterParameter
     * @param filterValue
     */

    selectTickets(filterParameter?, filterValue?): void {
        this.selectedTickets = [];

        // If there is no filter, select all tickets
        if (filterParameter === undefined || filterValue === undefined) {
            this.selectedTickets = [];
            this.tickets.map(ticket => {
                this.selectedTickets.push(ticket.ticketId);
            });
        }

        // Trigger the next event
        this.onSelectedTicketsChanged.next(this.selectedTickets);
    }




    /**
     * Deselect tickets
     */
    deselectTickets(): void {
        this.selectedTickets = [];

        // Trigger the next event
        this.onSelectedTicketsChanged.next(this.selectedTickets);
    }

    /**
     * Delete ticket
     *
     * @param ticket
     */
    deleteTicket(ticket): void {
        const ticketIndex = this.tickets.indexOf(ticket);
        this.tickets.splice(ticketIndex, 1);
        this.onTicketsChanged.next(this.tickets);
    }

    /**
     * Delete selected tickets
     */


    deleteSelectedTickets(): void {
        for (const ticketId of this.selectedTickets) {
           const ticket = this.tickets.find(ticket => {
                return ticket.ticketId === ticketId;
           });
           const ticketIndex = this.tickets.indexOf(ticket);
           this.tickets.splice(ticketIndex, 1);
       }
       this.onTicketsChanged.next(this.tickets);
       this.deselectTickets();
    }




    getTicketSeverity(): Observable<SeverityResponse> {
        return this._httpClient.get<SeverityResponse>('http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/ticketseverity', {
            headers: this.headers
        })
            .pipe(
                //catchError(/*this.handleError('addHero', ticket)*/)
            );
    }

    stepTicketForward(ticketID: number): Observable<Ticket> {

        return this._httpClient.get<Ticket>('http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/ticket/stepTicketForward?TICKET_ID=' + ticketID, {
            headers: this.headers
        })
            .pipe(
                //catchError(/*this.handleError('addHero', ticket)*/)
            );
    }

    stepTicketBackward(ticketID: number): Observable<Ticket> {

        return this._httpClient.get<Ticket>('http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/ticket/stepTicketBackward?TICKET_ID=' + ticketID, {
            headers: this.headers
        })
            .pipe(
                //catchError(/*this.handleError('addHero', ticket)*/)
            );
    }


    getUserDetails(): Observable<User> {

        return this._httpClient.get<User>('http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/getUserByEmail?value=ahmed.farrag', {
            headers: this.headers
        })
            .pipe(
                //catchError(/*this.handleError('addHero', ticket)*/)
            );
    }

    getWorkflow(): Observable<WorkFlowResponse> {


        return this._httpClient.get<WorkFlowResponse>('http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/workflow', {
            headers: this.headers
        })
            .pipe(
                //catchError(/*this.handleError('addHero', ticket)*/)
            );

    }

    getTicketById(value: string): Observable<Ticket> {

        const href = 'http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/ticket';
        let identifier = "TICKET_ID";
        //let value = "1953";
        const requestUrl = `${href}?identifier=` + identifier + `&value=` + value;

        return this._httpClient.get<Ticket>(requestUrl, {
            headers: this.headers
        })
            .pipe(
                //catchError(/*this.handleError('addHero', ticket)*/)
            );

    }

    getTicketToUpdate(ticketId: string): Observable<UpdatedTicketResponse> {

        const href = 'http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/ticket';
        let identifier = "TICKET_ID";
        //let value = "1953";
        const requestUrl = `${href}?identifier=` + identifier + `&value=` + ticketId;

        return this._httpClient.get<UpdatedTicketResponse>(requestUrl, {
            headers: this.headers
        })
            .pipe(
                //catchError(/*this.handleError('addHero', ticket)*/)
            );

    }



    getTicketPriority(): Observable<PriorityResponse> {


        return this._httpClient.get<PriorityResponse>('http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/ticketpriority', {
            headers: this.headers
        })
            .pipe(
                //catchError(/*this.handleError('addHero', ticket)*/)
            );
    }

    addTicket(formData: FormData): Observable<Ticket> {

        return this._httpClient.post<Ticket>('http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/ticket', formData, {

        })
            .pipe(
                // catchError(alert('Kindly, fill mandatory data and retry'))
            );
    }


    editTicket(formData: FormData): Observable<Ticket> {

        return this._httpClient.post<Ticket>('http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/ticket/update', formData, {
        })

    }



    getTicketsByProjectID(projectId:number,userEmail:string): Observable<any> {
        const href = 'http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/ticket/ticketbyproidanduser';
        //const requestUrl = `${href}?PROJECT_ID=1&USER_EMAIL=ahmed.farrag`;
        const requestUrl = `${href}?PROJECT_ID=` + projectId + `&USER_EMAIL=`+userEmail
        console.log('inside getTicketsByProjectID');

        return this._httpClient.get<any>(requestUrl, { headers: this.headers })
            .pipe(
                catchError(this.handleError('getTicketsByProjectID'))
            );
    }

    getTicketsByWorkFlowID(): Observable<any> {
        console.log('Start Calling getTicketsByWorkFlowID service...!');
        const href = 'http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/ticket/ticketbywfidanduser';
        const requestUrl = `${href}?WORKFLOW_ID=2&USER_EMAIL=ahmed.farrag`;
        console.log('inside getTicketsByWorkFlowID');

        return this._httpClient.get<any>(requestUrl, { headers: this.headers })
            .pipe(
                catchError(this.handleError('getTicketsByWorkFlowID'))
            );
    }

    getWorkFlowList(): Observable<any> {
        console.log('Start Calling getWorkFlowList service...!');
        const href = 'http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/workflow';
        //const requestUrl = `${href}?WORKFLOW_ID=2&USER_EMAIL=ahmed.farrag`;
        console.log('inside getWorkFlowList');

        return this._httpClient.get<any>(href, { headers: this.headers })
            .pipe(
                catchError(this.handleError('getWorkFlowList'))
            );
    }

    getCategorizationList(): Observable<any> {
        console.log('Start Calling getCategorizationList service...!');
        const href = 'http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/ticket/severityprioritystatusbyuser';
        const requestUrl = `${href}?USER_EMAIL=ahmed.farrag`;
        console.log('inside getCategorizationList');

        return this._httpClient.get<any>(requestUrl, { headers: this.headers })
            .pipe(
                catchError(this.handleError('getCategorizationList'))
            );
    }


   /*  getCurrentWeatherRequestURL(): any {
        navigator.geolocation.getCurrentPosition(
            function (position) { 
                var lat,lon;
 debugger;
                lat=position.coords.latitude;
                lon= position.coords.longitude;
                console.log('Latitude is : '+lat);
                console.log('Longitude is : '+lon); 
                const requestUrl =
                return requestUrl;
            });

    } */

    getCurrentWeather(lat:Number,lon:Number):Observable<any> {
        
        var requestURL = 'https://api.openweathermap.org/data/2.5/weather?lat='+lat+'&lon='+lon+'&APPID=6253586246a34d3f7a5273ff34231df3';
            console.log('Start getCurrentWeather method : ' + requestURL);
            return this._httpClient.get<any>(requestURL)
            .pipe(
                catchError(this.handleError('getCurrentWeather'))
            );
        }


        getUsersByProjectID(projectID:Number):Observable<any>{
            console.log('Start Calling getCategorizationList service...!');
            const href = 'http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/user/allbyprojectid';
            const requestUrl = `${href}?PROJECT_ID=`+projectID;
            console.log('End Calling getCategorizationList');
    
            return this._httpClient.get<any>(requestUrl, { headers: this.headers })
                .pipe(
                    catchError(this.handleError('getCategorizationList'))
                );
                
        }
    /**
     * Handle Http operation that failed.
     * Let the app continue.
     * @param operation - name of the operation that failed
     * @param result - optional value to return as the observable result
     */
    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {

            // TODO: send the error to remote logging infrastructure
            console.error(error); // log to console instead

            // TODO: better job of transforming error for user consumption
            this.log(`${operation} failed: ${error.message}`);

            // Let the app keep running by returning an empty result.
            return of(result as T);
        };
    }

    /** Log a HeroService message with the MessageService */
    private log(message: string) {
        // this.messageService.add(`HeroService: ${message}`);
    }



}