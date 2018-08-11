import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions  } from '@angular/http';
import { Observable } from 'rxjs';
import { URLSearchParams } from '@angular/http';
//import {Base64} from 'angular-base64/angular-base64'; 
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';

import { User } from '../models/user.model';
import { Auth } from '../models/auth.model';
import { LoginParam } from '../models/login.model';
import { toBase64String } from '@angular/compiler/src/output/source_map';

@Injectable()
export class LoginService {

    constructor(private http: Http) { }

    private baseUrl = 'http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/user/';
    private authUrl = 'http://192.168.3.164:8082/HelpDeskIntegrationAPI/oauth/token';
    private loginURL = 'http://192.168.3.164:8082/HelpDeskIntegrationAPI/api/user/login';


    authorize(param: Auth): Observable<any> {
       /*   let authData = btoa('spring-security-oauth2-read-write-client' + ':' + 'spring-security-oauth2-read-write-client-password1234');
        let headers = new Headers({
            'Content-Type': 'application/x-www-form-urlencoded',
			'Access-Control':'Allow-Origin',
            'Authorization': 'Basic '+authData
        });
        
        let options = new RequestOptions({ headers: headers });
        let params = new URLSearchParams();
        params.set('username', param.username);
        params.set('password', param.password);
        params.set('grant_type', param.grant_type);
        params.set('client_id', param.client_id);
        return this.http.post(this.authUrl, params, options)
            .map(this.extractData)
            .catch(this.handleErrorObservable); */

         let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post(this.loginURL , {
            "email":"admin@gmail.com",
            "password":"123456"
           }, options)
            .map(this.extractData)
            .catch(this.handleErrorObservable);

    }

    login(param: LoginParam): Observable<User> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post(this.baseUrl + 'login', param, options)
            .map(this.extractData)
            .catch(this.handleErrorObservable);
    }

    register(param: User): Observable<User> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post(this.baseUrl + 'register', param, options)
            .map(this.extractData)
            .catch(this.handleErrorObservable);
    }

    private extractData(res: Response) {
        let body = res.json();
        return body || {};
    }
    private handleErrorObservable(error: Response | any) {
        console.error(error.message || error);
        return Observable.throw(error.message || error);
    }

}
