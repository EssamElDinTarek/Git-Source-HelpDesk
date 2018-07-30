import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TicketAttachementsComponent } from './ticket-attachements.component';


const routes = [
  {
      path     : 'attachment',
      component   : TicketAttachementsComponent
  }
];

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    TicketAttachementsComponent
  ]
})
export class TicketAttachementsModule { }
