import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Headers, Http, RequestOptions , ResponseContentType} from '@angular/http';
import { Attachment } from '../../model/attachment';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class AttachmentService {

  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  private attachmentsUrl = 'http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/attachment';  // URL to web api


  apiEndPoint:string;



  constructor(private _http: HttpClient) { }

  getAttachmentByTickId(ticketID: number): Observable<AttachmentResponse> {
    const href = 'http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/attachment/ticid/'+ticketID;
    let identifier = "TICKET_ID";
    //let value = "1953";
    const requestUrl = `${href}`;//?identifier=` + identifier + `&value=` + ticketID;

    return this._http.get<AttachmentResponse>(requestUrl, {
      headers: this.headers
    })
      .pipe(
        //catchError(/*this.handleError('addHero', ticket)*/)
      );

  }

  addAttachment(formData: FormData) {
    const href = 'http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/attachment';

    return this._http.post(href, formData,{
      //headers: this.headers
    })
      .pipe(
      );

  }

  deleteAttachment (attachment: Attachment | number): Observable<Attachment> {

    const id = typeof attachment === 'number' ? attachment : attachment.attachmentId;
    const url = `${this.attachmentsUrl}/${id}`;

    return this._http.delete<Attachment>(url, httpOptions).pipe(
      tap(_ => this.log(`Deleted Attachment id=${id}`)),
      catchError(this.handleError<Attachment>('deleteAttachment'))
    );
  }
  downloadAttachment (attachment: Attachment): Observable<any> {

    const query = 'attachment_id'+attachment.attachmentId;
    const url = `${this.attachmentsUrl}?${query}`;
    const options = new RequestOptions({responseType: ResponseContentType.Blob });
    /* return this._http.get(url, options).pipe(
      tap(_ => this.log(`download Attachment id=${attachment.attachmentId}`)),
      catchError(this.handleError<Attachment>('downloadAttachment'))
    ); */
    /* let headers = this.setHeaders({
      'Content-Type': 'application/zip', 'Accept': 'application/zip'
    }); */
    return this._http.get(url, httpOptions).pipe(
      tap(_ => this.log(`download Attachment id=${attachment.attachmentId}`)),
      catchError(this.handleError<Attachment>('downloadAttachment'))
    );
  }

  private handleError<T> (operation = 'operation', result?: T) {
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
export class AttachmentResponse{
  status: string;
  data: Attachment[];
}
