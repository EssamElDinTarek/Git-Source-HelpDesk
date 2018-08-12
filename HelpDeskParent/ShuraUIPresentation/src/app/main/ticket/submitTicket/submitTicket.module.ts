import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FuseSharedModule } from '@fuse/shared.module';
import { SubmitTicketComponent } from './submitTicket.component';
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

const routes: Routes = [
  {
      path     : 'submitTicket',
      component: SubmitTicketComponent
  }  , {
    path     : 'submitTicket/:id',
    component: SubmitTicketComponent
}  
];
@NgModule({
  declarations: [
    SubmitTicketComponent,
    FileManagerFileListComponent
],
  imports: [
    RouterModule.forChild(routes),
    FuseSharedModule,
    CdkTableModule,
    MatAutocompleteModule, MatBadgeModule, MatBottomSheetModule, MatButtonModule,

  MatButtonToggleModule, MatCardModule, MatCheckboxModule, MatChipsModule, MatDatepickerModule,

  MatDialogModule, MatDividerModule, MatExpansionModule, MatFormFieldModule, MatGridListModule,

  MatIconModule, MatInputModule, MatListModule, MatMenuModule, MatPaginatorModule,

  MatProgressBarModule, MatProgressSpinnerModule, MatRadioModule, MatRippleModule, MatSelectModule,

  MatSidenavModule, MatSliderModule, MatSlideToggleModule, MatSnackBarModule, MatSortModule,

  MatStepperModule, MatTableModule, MatTabsModule, MatToolbarModule, MatTooltipModule, MatTreeModule
  ],
  providers   : [
      FileManagerService
  ] 
 
})
export class SubmitTicketModule { }
