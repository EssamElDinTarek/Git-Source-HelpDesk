import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TicketFormModuleComponent } from './ticket-form-module.component';
import { RouterModule, Routes } from '@angular/router';
import { FuseSharedModule } from '@fuse/shared.module';
import { FileManagerFileListComponent } from "../../file-list/file-list.component";
import { CdkTableModule } from '@angular/cdk/table';
import { FileManagerService } from "../../../services/file-manager.service"
import {

  MatAutocompleteModule, MatBadgeModule, MatBottomSheetModule, MatButtonModule,

  MatButtonToggleModule, MatCardModule, MatCheckboxModule, MatChipsModule, MatDatepickerModule,

  MatDialogModule, MatDividerModule, MatExpansionModule, MatFormFieldModule, MatGridListModule,

  MatIconModule, MatInputModule, MatListModule, MatMenuModule, MatPaginatorModule,

  MatProgressBarModule, MatProgressSpinnerModule, MatRadioModule, MatRippleModule, MatSelectModule,

  MatSidenavModule, MatSliderModule, MatSlideToggleModule, MatSnackBarModule, MatSortModule,

  MatStepperModule, MatTableModule, MatTabsModule, MatToolbarModule, MatTooltipModule, MatTreeModule

} from '@angular/material';

import { FuseSidebarModule } from '@fuse/components';
import { FuseWidgetModule } from '@fuse/components/widget/widget.module';
import { TicketAttachmentComponent } from '../ticket-attachment/ticket-attachment.component';
import { TicketCommentComponent } from '../ticket-comment/ticket-comment.component';

const routes: Routes = [
  {
    path: 'editTicket',
    component: TicketFormModuleComponent
  }
];



@NgModule({
  imports: [
    CommonModule, RouterModule.forChild(routes),
    FuseSharedModule,
    CdkTableModule,
    MatAutocompleteModule, MatBadgeModule, MatBottomSheetModule, MatButtonModule,

    MatButtonToggleModule, MatCardModule, MatCheckboxModule, MatChipsModule, MatDatepickerModule,

    MatDialogModule, MatDividerModule, MatExpansionModule, MatFormFieldModule, MatGridListModule,

    MatIconModule, MatInputModule, MatListModule, MatMenuModule, MatPaginatorModule,

    MatProgressBarModule, MatProgressSpinnerModule, MatRadioModule, MatRippleModule, MatSelectModule,

    MatSidenavModule, MatSliderModule, MatSlideToggleModule, MatSnackBarModule, MatSortModule,

    MatStepperModule, MatTableModule, MatTabsModule, MatToolbarModule, MatTooltipModule, MatTreeModule,
    FuseSharedModule,
    FuseSidebarModule,
    FuseWidgetModule
  ],
  declarations: [TicketFormModuleComponent,
    TicketAttachmentComponent,
    TicketCommentComponent],
  exports: [
    TicketAttachmentComponent,
    TicketCommentComponent
  ]

})
export class TicketFormModuleModule { }
