import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TicketFormModuleComponent } from './ticket-form-module.component';
import { RouterModule, Routes } from '@angular/router';
import { FuseSharedModule } from '@fuse/shared.module';
import { CdkTableModule } from '@angular/cdk/table';
import { TicketAttachementsModule } from '../../attachment/ticket-attachements/ticket-attachements.module';
import { TicketCommentModule } from '../../ticket-comment/ticket-comment.module';
//import {MatDialogModule,MatDialogRef} from '@angular/material/dialog';

import {

  
  MatAutocompleteModule, MatBadgeModule, MatBottomSheetModule, MatButtonModule,

  MatButtonToggleModule, MatCardModule, MatCheckboxModule, MatChipsModule, MatDatepickerModule,

   MatDividerModule, MatExpansionModule, MatFormFieldModule, MatGridListModule, MatDialogRef,

  MatIconModule, MatInputModule, MatListModule, MatMenuModule, MatPaginatorModule, MAT_DIALOG_DATA,

  MatProgressBarModule, MatProgressSpinnerModule, MatRadioModule, MatRippleModule, MatSelectModule,

  MatSidenavModule, MatSliderModule, MatSlideToggleModule, MatSnackBarModule, MatSortModule, MatDialogModule,

  MatStepperModule, MatTableModule, MatTabsModule, MatToolbarModule, MatTooltipModule, MatTreeModule
  

} from '@angular/material';

import { FuseSidebarModule } from '@fuse/components';
import { FuseWidgetModule } from '@fuse/components/widget/widget.module';
import { HttpClientModule } from '@angular/common/http';


const routes: Routes = [
  {
    path: 'teaminbox/:ticketId',
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
    FuseWidgetModule,
    HttpClientModule,
  TicketAttachementsModule,TicketCommentModule
  ],
  declarations: [TicketFormModuleComponent],
  exports: [    MatAutocompleteModule, MatBadgeModule, MatBottomSheetModule, MatButtonModule,

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
  providers: [
    { provide: MAT_DIALOG_DATA, useValue: {} },
    { provide: MatDialogRef, useValue: {} }
  ]

})
export class TicketFormModuleModule { }
