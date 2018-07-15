import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { TicketViewComponent } from './ticketview/ticketview.component';
import { GroupPermComponent } from './group-perm/group-perm.component';
import { CreateticketModule } from './main/ticket/createticket/createticket.module';
const appRoutes: Routes = [
    {
        path        : 'welcome',
        component   : WelcomeComponent
    },
{
        path        : 'ticketview',
        component   : TicketViewComponent
    },
    {
        path        : 'perm',
        component   : GroupPermComponent
    },
    {
        path        : '**',
        component   : LoginComponent
    },
    {
        path      : 'createticket',
        redirectTo: 'createticket'
    }
	
    // {
    //     path      : '**',
    //     redirectTo: 'apps/dashboards/analytics'
    // }
];

@NgModule({
    declarations: [],
    imports: [
        RouterModule.forRoot(appRoutes),
		CreateticketModule
    ],
    exports: [
        RouterModule
    ],
    providers: []
})

export class AppRoutingModule { }