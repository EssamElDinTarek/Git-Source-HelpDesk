import { Injectable } from '@angular/core';

import {  Observable, of } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { HttpClient,  HttpHeaders } from '@angular/common/http';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Headers, Http, RequestOptions } from '@angular/http';
import { FileData } from '../../model/fileData';

@Injectable({
  providedIn: 'root'
})
export class FileListService {

  private headers = new HttpHeaders( { 'Content-Type': 'application/json' } );

  
  
  constructor(private _http: HttpClient) { }


   
    viewFilesData (filesData: FileData[]) : FileData[]{
     return filesData;
    }

  
}
