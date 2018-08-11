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
import { and } from '@angular/router/src/utils/collection';
import { navigation } from '../navigation/navigation';
import { SharedDataService } from '../services/shared-data.service';
import { TicketService } from '../services/ticket.service';


@Component({
    selector   : 'login',
    templateUrl: './login.component.html',
    styleUrls  : ['./login.component.scss'],
    animations : fuseAnimations
})
export class LoginComponent implements OnInit, OnDestroy
{
    loginForm: FormGroup;
    loginFormErrors: any;

    // Private
    private _unsubscribeAll: Subject<any>;

    /**
     * Constructor
     *
     * @param {FuseConfigService} _fuseConfigService
     * @param {FormBuilder} _formBuilder
     */
	    user: User[];
        authList: Auth[];
        errorMessage: string;
        logParam = new LoginParam();
        param = new User();
        authParam = new Auth();
        userId: string;
    constructor(
	    private router: Router,
		private loginService: LoginService,
        private _fuseConfigService: FuseConfigService,
        private _formBuilder: FormBuilder,
        private _sharedData: SharedDataService,
        private _ticketservice:TicketService
    )
    {
        // Configure the layout
        this._fuseConfigService.config = {
            layout: {
                navbar : {
                    hidden: true
                },
                toolbar: {
                    hidden: true
                },
                footer : {
                    hidden: true
                }
            }
        };

        // Set the defaults
        this.loginFormErrors = {
            email   : {},
            password: {}
        };

        // Set the private defaults
        this._unsubscribeAll = new Subject();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Lifecycle hooks
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    ngOnInit(): void
    {
        this.loginForm = this._formBuilder.group({
            email   : ['', [Validators.required, Validators.email]],
            password: ['', Validators.required]
        });

        this.loginForm.valueChanges
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(() => {
                this.onLoginFormValuesChanged();
            });
    }

    /**
     * On destroy
     */
    ngOnDestroy(): void
    {
        // Unsubscribe from all subscriptions
        this._unsubscribeAll.next();
        this._unsubscribeAll.complete();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * On form values changed
     */
    onLoginFormValuesChanged(): void
    {
        for ( const field in this.loginFormErrors )
        {
            if ( !this.loginFormErrors.hasOwnProperty(field) )
            {
                continue;
            }

            // Clear previous errors
            this.loginFormErrors[field] = {};

            // Get the control
            const control = this.loginForm.get(field);

            if ( control && control.dirty && !control.valid )
            {
                this.loginFormErrors[field] = control.errors;
            }
        }
    }
	
	auth(): void {
        //this._sharedData.user.emailAddress =  this.logParam.email;
        this.authParam.username = this.logParam.email;
        this.authParam.password = this.logParam.password;
        this.authParam.client_id = 'spring-security-oauth2-read-write-client';
        this.authParam.grant_type = 'password';
        this.loginService.authorize(this.authParam)
            .subscribe(authList => {
                debugger;
              // this.login();
            },
            error => this.errorMessage = <any>error);
            this._ticketservice.getUserDetails(this.logParam.email).subscribe(_user =>{
                this._sharedData.user = _user;
                this._sharedData.user.emailAddress = _user.email;
                this._sharedData.projects = _user.projects;
                
                if(this._sharedData.projects != null && this._sharedData.projects.length > 0){
                    this._sharedData.selectedProject =  this._sharedData.projects[0];
                    this._sharedData.portfolio = _user.projects[0].portfolio
                   // this._sharedService.selectedProject = this.projects[0];
               
                }
                this.router.navigate(['user']);
                
            });
    }

	 login(): void {
        console.log('Try to log in...! ');
        console.log(this.logParam.email);
        console.log(this.logParam.password);
      debugger;
        this.loginService.login(this.logParam)
            .subscribe(user => {
               
                if (user.id == "-1") {
                    alert("Email or password incorrect ");
                  } else {
						console.log(this.logParam.email);

						        if (this.logParam.email == "admin@gmail.com" && this.logParam.password=="admin")
						        {
						            this.router.navigate(['admin']);
						        } 
						        else if (this.logParam.email == "manager@gmail.com" && this.logParam.password=="123456")
						        {
						            this.router.navigate(['manager']);
						        }
						        else if(this.logParam.email == "user@gmail.com" && this.logParam.password=="1234")
						        {
						            this.router.navigate(['user']);
						        }else
						        {
						            this.router.navigate(['welcome']);
						        }
                 //this.router.navigate(['welcome']);  
                }       
                
                
            },
            error => this.errorMessage = <any>error);
    } 

}
