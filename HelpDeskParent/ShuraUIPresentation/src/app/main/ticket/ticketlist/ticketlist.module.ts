import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FuseSharedModule } from '@fuse/shared.module';
import { TicketlistComponent } from './ticketlist.component';


const routes: Routes = [
  {
      path     : 'ticketlist',
      component: TicketlistComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes),
    FuseSharedModule
    
  ],
  declarations: [TicketlistComponent]
 
})
export class TicketlistModule { }
