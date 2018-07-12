import { NgModule } from '@angular/core';

import { CreateticketModule } from './createticket/createticket.module';
import { TicketlistModule } from './ticketlist/ticketlist.module';

@NgModule({
  imports: [
    
    CreateticketModule,
    TicketlistModule
  ]
})
export class TicketModule { }
