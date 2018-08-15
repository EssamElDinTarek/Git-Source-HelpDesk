import { Injectable } from '@angular/core';
import { Observable ,of} from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TicketComment } from '../model/TicketComment';
import { tap, catchError } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class TicketCommentService {

  private commentUrl = 'http://localhost:8081/HelpDeskIntegrationAPI/api/ticketcomment';  // URL to web api


  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private _http: HttpClient) { }

  getCommentByTickId(ticketID: number): Observable<CommentResponse> {
    const href = 'http://localhost:8081/HelpDeskIntegrationAPI/api/ticketcomment/tickid/' + ticketID;
    return this._http.get<CommentResponse>(href, {
      headers: this.headers
    })
      .pipe(
      );
  }

  addTicketComment(comment: TicketComment) {/*

    return this._http.post<TicketComment>(this.commentUrl, comment, httpOptions).pipe(
      tap((comment: TicketComment) => this.log(`added hero w/ id=${comment.ticketcommentId}`)),
      catchError(this.handleError<TicketComment>('addComment'))
    );*/
    //----------------------------------------
    
    return this._http.post('http://localhost:8081/HelpDeskIntegrationAPI/api/ticketcomment', comment, {

    })
      .pipe(
      );
      
  }
  deleteComment(comment: TicketComment | number): Observable<TicketComment> {

    const id = typeof comment === 'number' ? comment : comment.ticketcommentId;
    const url = `${this.commentUrl}/${id}`;

    return this._http.delete<TicketComment>(url, httpOptions).pipe(
      tap(_ => this.log(`Deleted Comment id=${id}`)),
      catchError(this.handleError<TicketComment>('deleteAttachment'))
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

  private log(message: string) {
    // this.messageService.add(`HeroService: ${message}`);
   }
}
export class CommentResponse {
  status: object;
  data: TicketComment[];
}
