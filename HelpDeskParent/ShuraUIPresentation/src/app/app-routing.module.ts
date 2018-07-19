import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { TicketViewComponent } from './ticketview/ticketview.component';
import { GroupPermComponent } from './group-perm/group-perm.component';
import { CreateticketModule } from 'app/main/ticket/createticket/createticket.module';
import { HDURSDashboardModule } from './main/dashboard/hd-urs-dashboard/hd-urs-dashboard.module';
import { HDADMDashboardModule } from './main/dashboard/hd-adm-dashboard/hd-adm-dashboard.module';
import { HDMGRDashboardModule } from './main/dashboard/hd-mgr-dashboard/hd-mgr-dashboard.module';


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
    },
  
    {
        path      : 'user',
        redirectTo: 'user'
    },
    {
        path:'admin',
        redirectTo:'admin'
    },
    {
        path:'manager',
        redirectTo:'manager'
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
        CreateticketModule,
        HDURSDashboardModule,
        HDADMDashboardModule,
        HDMGRDashboardModule
    ],
    exports: [
        RouterModule
    ],
    providers: []
})

export class AppRoutingModule { }