import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { TicketViewComponent } from './ticketview/ticketview.component';
import { GroupPermComponent } from './group-perm/group-perm.component';

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
    }
    // {
    //     path      : '**',
    //     redirectTo: 'apps/dashboards/analytics'
    // }
];

@NgModule({
    declarations: [],
    imports: [
        RouterModule.forRoot(appRoutes)
    ],
    exports: [
        RouterModule
    ],
    providers: []
})

export class AppRoutingModule { }