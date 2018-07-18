import { NgModule } from '@angular/core';


import { TicketlistModule } from './ticketlist/ticketlist.module';
import { SubmitTicketModule } from './submitticket/submitTicket.module';


@NgModule({
  imports: [
    
    SubmitTicketModule,
    TicketlistModule
  ]
})
export class TicketModule { }
