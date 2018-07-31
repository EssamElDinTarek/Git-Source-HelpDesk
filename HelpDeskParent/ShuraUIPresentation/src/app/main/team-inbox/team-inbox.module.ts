import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TeamInboxComponent } from './team-inbox.component';
import { CdkTableModule } from '@angular/cdk/table';

import { FuseSharedModule } from '@fuse/shared.module';
import { FuseConfirmDialogModule, FuseSidebarModule } from '@fuse/components';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {
    MatAutocompleteModule, MatBadgeModule, MatBottomSheetModule, MatButtonModule,
    MatButtonToggleModule, MatCardModule, MatCheckboxModule, MatChipsModule, MatDatepickerModule,
    MatDialogModule, MatDividerModule, MatExpansionModule, MatFormFieldModule, MatGridListModule,
    MatIconModule, MatInputModule, MatListModule, MatMenuModule, MatPaginatorModule,
    MatProgressBarModule, MatProgressSpinnerModule, MatRadioModule, MatRippleModule, MatSelectModule,
    MatSidenavModule, MatSliderModule, MatSlideToggleModule, MatSnackBarModule, MatSortModule,
    MatStepperModule, MatTableModule, MatTabsModule, MatToolbarModule, MatTooltipModule, MatTreeModule
} from '@angular/material';
import { TicketFormModule } from './ticket-form/ticket-form.module';
import { TicketListComponent } from './ticket-list/ticket-list.component';
import { ContactsService } from './contacts.service';
import { TicketCommentComponent } from './ticket-comment/ticket-comment.component';
import { TicketAttachmentComponent } from './ticket-attachment/ticket-attachment.component';
import { TicketFormModuleComponent } from './ticket-form-module/ticket-form-module.component';


const materialModules = [
   MatAutocompleteModule, MatBadgeModule, MatBottomSheetModule, MatButtonModule,
    MatButtonToggleModule, MatCardModule, MatCheckboxModule, MatChipsModule, MatDatepickerModule,
    MatDialogModule, MatDividerModule, MatExpansionModule, MatFormFieldModule, MatGridListModule,
    MatIconModule, MatInputModule, MatListModule, MatMenuModule, MatPaginatorModule,
    MatProgressBarModule, MatProgressSpinnerModule, MatRadioModule, MatRippleModule, MatSelectModule,
    MatSidenavModule, MatSliderModule, MatSlideToggleModule, MatSnackBarModule, MatSortModule,
    MatStepperModule, MatTableModule, MatTabsModule, MatToolbarModule, MatTooltipModule, MatTreeModule

];

const routes = [
  {
      path     : 'teaminbox',
      component: TeamInboxComponent,
      resolve  : {
        contacts: ContactsService
    }
  }
];

@NgModule({
  declarations: [
    TeamInboxComponent,
    TicketListComponent,
    TicketCommentComponent,
    TicketAttachmentComponent,
    TicketFormModuleComponent
    ],
imports     : [
    RouterModule.forChild(routes),
    CdkTableModule,

    MatButtonModule,
    MatCheckboxModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatMenuModule,
    MatRippleModule,
    MatTableModule,
    MatToolbarModule,
MatTabsModule,
    FuseSharedModule,
    FuseConfirmDialogModule,
    FuseSidebarModule,
     FormsModule,
    BrowserAnimationsModule,
    TicketFormModule
],
entryComponents: [
    TicketCommentComponent,
    TicketAttachmentComponent,
    TicketFormModuleComponent
],
 exports: [
FormsModule,
ReactiveFormsModule,
materialModules,
TeamInboxComponent
]
})
export class TeamInboxModule { }
