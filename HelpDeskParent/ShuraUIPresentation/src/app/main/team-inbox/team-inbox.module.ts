import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TeamInboxComponent } from './team-inbox.component';
import { CdkTableModule } from '@angular/cdk/table';

import { FuseSharedModule } from '@fuse/shared.module';
import { FuseConfirmDialogModule, FuseSidebarModule } from '@fuse/components';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {DataSource} from '@angular/cdk/table';

import {
    MatAutocompleteModule, MatBadgeModule, MatBottomSheetModule, MatButtonModule,
    MatButtonToggleModule, MatCardModule, MatCheckboxModule, MatChipsModule, MatDatepickerModule,
    MatDialogModule, MatDividerModule, MatExpansionModule, MatFormFieldModule, MatGridListModule,
    MatIconModule, MatInputModule, MatListModule, MatMenuModule, MatPaginatorModule,
    MatProgressBarModule, MatProgressSpinnerModule, MatRadioModule, MatRippleModule, MatSelectModule,
    MatSidenavModule, MatSliderModule, MatSlideToggleModule, MatSnackBarModule, MatSortModule,
    MatStepperModule, MatTableModule, MatTabsModule, MatToolbarModule, MatTooltipModule, MatTreeModule
} from '@angular/material';
import { TicketListComponent } from './ticket-list/ticket-list.component';
import { ContactsService } from './contacts.service';

import { TicketFormModuleComponent } from './ticket-form-module/ticket-form-module.component';
import { TicketAttachementsModule } from '../attachment/ticket-attachements/ticket-attachements.module';
import { TicketCommentModule } from '../ticket-comment/ticket-comment.module';


const materialModules = [
   MatAutocompleteModule, MatBadgeModule, MatBottomSheetModule, MatButtonModule,
    MatButtonToggleModule, MatCardModule, MatCheckboxModule, MatChipsModule, MatDatepickerModule,
    MatDialogModule, MatDividerModule, MatExpansionModule, MatFormFieldModule, MatGridListModule,
    MatIconModule, MatInputModule, MatListModule, MatMenuModule, MatPaginatorModule,
    MatProgressBarModule, MatProgressSpinnerModule, MatRadioModule, MatRippleModule, MatSelectModule,
    MatSidenavModule, MatSliderModule, MatSlideToggleModule, MatSnackBarModule, MatSortModule,
    MatStepperModule, MatTableModule, MatTabsModule, MatToolbarModule, MatTooltipModule, MatTreeModule,
    TicketAttachementsModule,TicketCommentModule

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
    TicketFormModuleComponent
    ],
imports     : [
    RouterModule.forChild(routes),
    CdkTableModule,
    materialModules,
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
    MatStepperModule,
    FuseSharedModule,
    FuseConfirmDialogModule,
    FuseSidebarModule,
     FormsModule,
    BrowserAnimationsModule
],
entryComponents: [
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
