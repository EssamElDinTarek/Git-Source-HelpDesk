import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { FuseSidebarModule } from '@fuse/components';
import { FuseSharedModule } from '@fuse/shared.module';

import { ContentModule } from 'app/layout/components/content/content.module';
import { FooterModule } from 'app/layout/components/footer/footer.module';
import { NavbarModule } from 'app/layout/components/navbar/navbar.module';
import { QuickPanelModule } from 'app/layout/components/quick-panel/quick-panel.module';
import { ToolbarModule } from 'app/layout/components/toolbar/toolbar.module';

import { VerticalLayout1Component } from 'app/layout/vertical/layout-1/layout-1.component';

import {
    MatAutocompleteModule, MatBadgeModule, MatBottomSheetModule, MatButtonModule,
    MatButtonToggleModule, MatCardModule, MatCheckboxModule, MatChipsModule, MatDatepickerModule,
    MatDialogModule, MatDividerModule, MatExpansionModule, MatFormFieldModule, MatGridListModule,
    MatIconModule, MatInputModule, MatListModule, MatMenuModule, MatPaginatorModule,
    MatProgressBarModule, MatProgressSpinnerModule, MatRadioModule, MatRippleModule, MatSelectModule,
    MatSidenavModule, MatSliderModule, MatSlideToggleModule, MatSnackBarModule, MatSortModule,
    MatStepperModule, MatTableModule, MatTabsModule, MatToolbarModule, MatTooltipModule, MatTreeModule
} from '@angular/material';

@NgModule({
    declarations: [
        VerticalLayout1Component
    ],
    imports: [
        RouterModule,

        FuseSharedModule,
        FuseSidebarModule,

        ContentModule,
        FooterModule,
        NavbarModule,
        QuickPanelModule,
        ToolbarModule,
        MatAutocompleteModule, MatBadgeModule, MatBottomSheetModule, MatButtonModule,
        MatButtonToggleModule, MatCardModule, MatCheckboxModule, MatChipsModule, MatDatepickerModule,
        MatDialogModule, MatDividerModule, MatExpansionModule, MatFormFieldModule, MatGridListModule,
        MatIconModule, MatInputModule, MatListModule, MatMenuModule, MatPaginatorModule,
        MatProgressBarModule, MatProgressSpinnerModule, MatRadioModule, MatRippleModule, MatSelectModule,
        MatSidenavModule, MatSliderModule, MatSlideToggleModule, MatSnackBarModule, MatSortModule,
        MatStepperModule, MatTableModule, MatTabsModule, MatToolbarModule, MatTooltipModule, MatTreeModule
    ],
    exports: [
        VerticalLayout1Component
    ]
})
export class VerticalLayout1Module {
}
