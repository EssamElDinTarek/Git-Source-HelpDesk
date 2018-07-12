import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FuseSharedModule } from '@fuse/shared.module';
import { CreateticketComponent } from './createticket.component';

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
      path     : 'createticket',
      component: CreateticketComponent
  }
];
@NgModule({
  declarations: [
    CreateticketComponent
],
  imports: [
    RouterModule.forChild(routes),
    FuseSharedModule,
    MatAutocompleteModule, MatBadgeModule, MatBottomSheetModule, MatButtonModule,

  MatButtonToggleModule, MatCardModule, MatCheckboxModule, MatChipsModule, MatDatepickerModule,

  MatDialogModule, MatDividerModule, MatExpansionModule, MatFormFieldModule, MatGridListModule,

  MatIconModule, MatInputModule, MatListModule, MatMenuModule, MatPaginatorModule,

  MatProgressBarModule, MatProgressSpinnerModule, MatRadioModule, MatRippleModule, MatSelectModule,

  MatSidenavModule, MatSliderModule, MatSlideToggleModule, MatSnackBarModule, MatSortModule,

  MatStepperModule, MatTableModule, MatTabsModule, MatToolbarModule, MatTooltipModule, MatTreeModule
  ],
 
})
export class CreateticketModule { }
