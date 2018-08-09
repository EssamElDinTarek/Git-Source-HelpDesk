import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { TicketViewComponent } from './ticketview/ticketview.component';
import { GroupPermComponent } from './group-perm/group-perm.component';
import { SubmitTicketModule } from './main/ticket/submitticket/submitTicket.module';



import { HDURSDashboardModule } from './main/dashboard/hd-urs-dashboard/hd-urs-dashboard.module';
import { HDADMDashboardModule } from './main/dashboard/hd-adm-dashboard/hd-adm-dashboard.module';
import { HDMGRDashboardModule } from './main/dashboard/hd-mgr-dashboard/hd-mgr-dashboard.module';
//import { AttachmentModule } from './main/attachment/attachment.module';
import { TicketAttachementsModule } from './main/attachment/ticket-attachements/ticket-attachements.module';
import { TicketCommentModule } from './main/ticket-comment/ticket-comment.module';
import { TeamInboxModule } from './main/team-inbox/team-inbox.module';
import { MatFormFieldModule } from '../../node_modules/@angular/material';
import { TicketFormModuleModule } from './main/team-inbox/ticket-form-module/ticket-form-module.module';
import { LookupManagementModule } from './main/lookup-management/lookup-management.module';
//import { TicketFormModuleComponent } from './main/team-inbox/ticket-form-module/ticket-form-module.component';




const appRoutes: Routes = [
	{
		path        : 'welcome',
		component   : WelcomeComponent
	},{
		path        : 'ticketview',
		component   : TicketViewComponent
	},{
		path        : 'perm',
		component   : GroupPermComponent
	},{
		path        : '**',
		component   : LoginComponent
	},{
		path      : 'submitTicket',
		redirectTo: 'submitTicket'
	} ,{
		path      : 'submitTicket/:id',
		redirectTo: 'submitTicket'
	},{
		path      : 'user',
		redirectTo: 'user'
	},{
		path:'admin',
		redirectTo:'admin'
	},{
		path : 'manager',
		redirectTo : 'manager'
	},
	{
		path:'teaminbox',
		redirectTo:'teaminbox'
	},
	{
		path:'teaminbox/:ticketId',
		redirectTo: 'teaminbox'
	},
	{
		path:'attachment',
		redirectTo:'attachment'
	},
	{
		path:'comment',
		redirectTo:'comment'
	},
	{
		path:'formModule',
		redirectTo:'formModule'
	},
	{
		path:'lookups',
		redirectTo:'lookups'
	}
	
	// {
	//     path      : '**',
	//     redirectTo: 'apps/dashboards/analytics'
	// }
];


@NgModule({
	declarations: [
	],
	imports: [
		RouterModule.forRoot(appRoutes),
		SubmitTicketModule,
		HDURSDashboardModule,
		HDADMDashboardModule,
		HDMGRDashboardModule,
		TicketAttachementsModule,
		TicketCommentModule,
		TeamInboxModule,
		RouterModule,
		TicketFormModuleModule,
		LookupManagementModule
	],
	exports: [
		RouterModule
	],
	providers: []
})

export class AppRoutingModule { }