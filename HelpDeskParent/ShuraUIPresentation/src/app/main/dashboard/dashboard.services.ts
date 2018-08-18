import { Injectable } from '@angular/core';
import { catchError, retry } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Headers, Http, RequestOptions } from '@angular/http';
import { BehaviorSubject, of, Observable, Subject } from 'rxjs';
import { FuseUtils } from '@fuse/utils';



@Injectable({
    providedIn: 'root'
})
export class DashBoardService //implements Resolve<any>
{
    onTicketsChanged: BehaviorSubject<any>;
    onSelectedTicketsChanged: BehaviorSubject<any>;
    onUserDataChanged: BehaviorSubject<any>;
    onSearchTextChanged: Subject<any>;
    onFilterChanged: Subject<any>;

    private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    apiEndPoint: string;




    user: any;
    selectedTickets: string[] = [];

    searchText: string;
    filterBy: string;
    url: any;

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

    getTickets() {
        console.log('from ticket service..!');
        this.getTicketsByProjectID;

        return new Promise((resolve, reject) => {


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





    getTicketsByProjectID(projectId: number, userEmail: string): Observable<any> {
        const href = 'http://192.168.3.125:8082/HelpDeskIntegrationAPI/api/ticket/ticketbyproidanduser';
        const requestUrl = `${href}?PROJECT_ID=` + projectId + `&USER_EMAIL=` + userEmail
        console.log('inside getTicketsByProjectID');

        return this._httpClient.get<any>(requestUrl, { headers: this.headers })
            .pipe(
                catchError(this.handleError('getTicketsByProjectID'))
            );
    }

    getTicketsByWorkFlowID(workFlowID:Number,userEmail:string): Observable<any> {
        console.log('Start Calling getTicketsByWorkFlowID service...!');
        const href = 'http://192.168.3.125:8082/HelpDeskIntegrationAPI/api/ticket/ticketbywfidanduser';
        const requestUrl = `${href}?WORKFLOW_ID=` + workFlowID + `&USER_EMAIL=` + userEmail
        //const requestUrl = `${href}?WORKFLOW_ID=2&USER_EMAIL=ahmed.farrag`;
        console.log('inside getTicketsByWorkFlowID');

        return this._httpClient.get<any>(requestUrl, { headers: this.headers })
            .pipe(
                catchError(this.handleError('getTicketsByWorkFlowID'))
            );
    }

    getWorkFlowList(): Observable<any> {
        console.log('Start Calling getWorkFlowList service...!');
        const href = 'http://192.168.3.125:8082/HelpDeskIntegrationAPI/api/workflow';  
        console.log('inside getWorkFlowList');

        return this._httpClient.get<any>(href, { headers: this.headers })
            .pipe(
                catchError(this.handleError('getWorkFlowList'))
            );
    }

    getCategorizationList(userEmail:string): Observable<any> {
        console.log('Start Calling getCategorizationList service...!');
        const href = 'http://192.168.3.125:8082/HelpDeskIntegrationAPI/api/ticket/severityprioritystatusbyuser';
        const requestUrl = `${href}?USER_EMAIL=`+userEmail;
        console.log('inside getCategorizationList');

        return this._httpClient.get<any>(requestUrl, { headers: this.headers })
            .pipe(
                catchError(this.handleError('getCategorizationList'))
            );
    }


    getCurrentWeather(lat: Number, lon: Number): Observable<any> {

        var requestURL = 'https://api.openweathermap.org/data/2.5/weather?lat=' + lat + '&lon=' + lon + '&APPID=6253586246a34d3f7a5273ff34231df3';
        console.log('Start getCurrentWeather method : ' + requestURL);
        return this._httpClient.get<any>(requestURL)
            .pipe(
                catchError(this.handleError('getCurrentWeather'))
            );
    }


    getUsersByProjectID(projectID:number): Observable<any> {
        console.log('Start Calling getCategorizationList service...!');
        const href = 'http://192.168.3.125:8082/HelpDeskIntegrationAPI/api/user/allbyprojectid';
        const requestUrl = `${href}?PROJECT_ID=`+projectID;
        console.log('End Calling getCategorizationList');

        return this._httpClient.get<any>(requestUrl, { headers: this.headers })
            .pipe(
                catchError(this.handleError('getCategorizationList'))
            );

    }

    getTicketsCounts(projectID:number,userEmail:string): Observable<any> {
        console.log('Start Calling getTicketsCounts');
        const href = 'http://192.168.3.125:8082/HelpDeskIntegrationAPI/api/ticket/dashboardcountountprojectidandusername';
        const requestUrl = `${href}?PROJECT_ID=` + projectID + `&USER_EMAIL=` + userEmail
        console.log('End Calling getTicketsCounts');

        return this._httpClient.get<any>(requestUrl, { headers: this.headers })
            .pipe(
                catchError(this.handleError('getTicketsByProjectID'))
            );
    }


    getWeeklyTickets(projectId:Number): Observable<any> {
        console.log('Start Calling getWeeklyTickets service...!');
        const href = 'http://192.168.3.125:8082/HelpDeskIntegrationAPI/api/ticket/dashboardweekchartstatusescount';
        const requestUrl = `${href}?PROJECT_ID=`+projectId;
        console.log('End Calling getWeeklyTickets  service...!');

        return this._httpClient.get<any>(requestUrl, { headers: this.headers })
            .pipe(
                catchError(this.handleError('getWeeklyTickets'))
            );
    }

    getProjectChart(): Observable<any> {
        console.log('Start Calling getPortofolioChart');
        const requestUrl = 'http://192.168.3.125:8082/HelpDeskIntegrationAPI/api/portfolio/dashboardweekchartprojectscount';
        console.log('End Calling getPortofolioChart');
        return this._httpClient.get<any>(requestUrl, { headers: this.headers })
            .pipe(catchError(this.handleError('getPortofolioChart')));

    }

    getTeamsPerProject(projectID): Observable<any> {
        console.log('Start Calling getTeamsPerProject service...!');
        const href = 'http://192.168.3.125:8082/HelpDeskIntegrationAPI/api/team/projectmemberandcount';
        const requestUrl = `${href}?PROJECT_ID=`+projectID;
        console.log('End Calling getTeamsPerProject  service...!');

        return this._httpClient.get<any>(requestUrl, { headers: this.headers })
            .pipe(
                catchError(this.handleError('getTeamsPerProject'))
            );
    }

    getProjectsByPortofolioID(portofloioId:Number): Observable<any> {
        console.log('Start Calling getProjectsByPortofolioID service...!');
        const href = ' http://192.168.3.125:8082/HelpDeskIntegrationAPI/api/project/getByPortfolioId';
        const requestUrl = `${href}?PORTFOLIO_ID=`+portofloioId;
        console.log('End Calling getProjectsByPortofolioID  service...!');

        return this._httpClient.get<any>(requestUrl, { headers: this.headers })
            .pipe(
                catchError(this.handleError('getProjectsByPortofolioID'))
            );
    }

    getProjectDetailsByPortofolioID(portofolioId:Number): Observable<any> {
        console.log('Start Calling getProjectDetailsByPortofolioID service...!');
        const href = 'http://192.168.3.125:8082/HelpDeskIntegrationAPI/api/project/projectdbdetails';
        const requestUrl = `${href}?PORTFOLIO_ID=`+portofolioId;
        console.log('End Calling getProjectDetailsByPortofolioID  service...!');

        return this._httpClient.get<any>(requestUrl, { headers: this.headers })
            .pipe(
                catchError(this.handleError('getProjectDetailsByPortofolioID'))
            );
    }

        getPortofolioDetails(): Observable<any> {
        console.log('Start Calling getPortofolioDetails');
        const requestUrl = 'http://192.168.3.125:8082/HelpDeskIntegrationAPI/api/portfolio/portfoliodbdetails';
        console.log('End Calling getPortofolioDetails');

        return this._httpClient.get<any>(requestUrl, { headers: this.headers })
            .pipe(catchError(this.handleError('getPortofolioDetails')));
    }

    getPortofolioChart(): Observable<any> {
        console.log('Start Calling getPortofolioChart');
        const requestUrl = 'http://192.168.3.125:8082/HelpDeskIntegrationAPI/api/portfolio/dashboardweekchartprojectscount';
        console.log('End Calling getPortofolioChart');
        return this._httpClient.get<any>(requestUrl, { headers: this.headers })
            .pipe(catchError(this.handleError('getPortofolioChart')));

    }
    getAllPortofolios(): Observable<any> {
        console.log('Start Calling getAllPortofolios');
        const requestUrl = 'http://192.168.3.125:8082/HelpDeskIntegrationAPI/api/portfolio';
        console.log('End Calling getAllPortofolios');
        return this._httpClient.get<any>(requestUrl, { headers: this.headers })
            .pipe(catchError(this.handleError('getAllPortofolios')));

    }

    getUsersByPortofolioID(portofloioId:Number): Observable<any> {
        console.log('Start Calling getUsersByPortofolioID');
        const href = 'http://192.168.3.125:8082/HelpDeskIntegrationAPI/api/user/allbyportfolioid';
        const requestUrl = `${href}?PORTFOLIO_ID=`+portofloioId;
        console.log('End Calling getUsersByPortofolioID');
        return this._httpClient.get<any>(requestUrl, { headers: this.headers })
            .pipe(catchError(this.handleError('getUsersByPortofolioID')));

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

    }



}