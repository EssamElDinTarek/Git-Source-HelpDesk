import { Component, OnInit, HostBinding } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

import { LoginService } from '../../services/login.service';
import { User } from '../../models/user.model';
import { LoginParam } from '../../models/login.model';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html'
//    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    constructor(private router: Router, private loginService: LoginService) { }
    user: User[];
    errorMessage: string;
    logParam = new LoginParam();
    param = new User();
    userId: string;
    ngOnInit() {
    }

    login(): void {
        this.loginService.login(this.logParam)
            .subscribe(user => {
                if (user.userId == "-1") {
                    alert("Email or password incorrect ");
                } else {
                    this.router.navigate(['home']);
                }
            },
            error => this.errorMessage = <any>error);
    }
    
    register(): void {
        this.loginService.register(this.param)
            .subscribe(user => {
                if (user.userId == "-1") {
                    alert("There is an error in server ");
                } else {
                    this.router.navigate(['home']);
                }
            },
            error => this.errorMessage = <any>error);
    }

}
