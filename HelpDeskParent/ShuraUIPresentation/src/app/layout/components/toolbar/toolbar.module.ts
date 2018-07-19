import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MatButtonModule, MatIconModule, MatMenuModule, MatProgressBarModule, MatToolbarModule } from '@angular/material';
import {

    MatAutocompleteModule, MatBadgeModule, MatBottomSheetModule, 
  
    MatButtonToggleModule, MatCardModule, MatCheckboxModule, MatChipsModule, MatDatepickerModule,
  
    MatDialogModule, MatDividerModule, MatExpansionModule, MatFormFieldModule, MatGridListModule,
  
 MatInputModule, MatListModule, MatPaginatorModule,
  
     MatProgressSpinnerModule, MatRadioModule, MatRippleModule, MatSelectModule,
  
    MatSidenavModule, MatSliderModule, MatSlideToggleModule, MatSnackBarModule, MatSortModule,
  
    MatStepperModule, MatTableModule, MatTabsModule,  MatTooltipModule, MatTreeModule
  
  } from '@angular/material';
import { FuseSearchBarModule, FuseShortcutsModule } from '@fuse/components';
import { FuseSharedModule } from '@fuse/shared.module';

import { ToolbarComponent } from './toolbar.component';

@NgModule({
    declarations: [
        ToolbarComponent
    ],
    imports     : [
        RouterModule,
        MatButtonModule,
        MatIconModule,
        MatMenuModule,
        MatProgressBarModule,
        MatToolbarModule,

		 MatAutocompleteModule, MatBadgeModule, MatBottomSheetModule, 
  
    MatButtonToggleModule, MatCardModule, MatCheckboxModule, MatChipsModule, MatDatepickerModule,
  
    MatDialogModule, MatDividerModule, MatExpansionModule, MatFormFieldModule, MatGridListModule,
  
 MatInputModule, MatListModule, MatPaginatorModule,
  
     MatProgressSpinnerModule, MatRadioModule, MatRippleModule, MatSelectModule,
  
    MatSidenavModule, MatSliderModule, MatSlideToggleModule, MatSnackBarModule, MatSortModule,
  
    MatStepperModule, MatTableModule, MatTabsModule,  MatTooltipModule, MatTreeModule,
        FuseSharedModule,
        FuseSearchBarModule,
        FuseShortcutsModule
    ],
    exports     : [
        ToolbarComponent
    ]
})
export class ToolbarModule
{
}
