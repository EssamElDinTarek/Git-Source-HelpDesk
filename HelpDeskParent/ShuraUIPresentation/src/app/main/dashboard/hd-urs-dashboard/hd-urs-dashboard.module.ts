import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HDURSDashboardComponent } from './hd-urs-dashboard.component';
import { RouterModule, Routes } from '@angular/router';


import { CdkTableModule } from '@angular/cdk/table';
import { MatButtonModule, MatDividerModule, MatFormFieldModule, MatIconModule, MatMenuModule, MatSelectModule, MatTableModule, MatTabsModule } from '@angular/material';
import { NgxChartsModule } from '@swimlane/ngx-charts';

import { FuseSharedModule } from '@fuse/shared.module';
import { FuseSidebarModule } from '@fuse/components';
import { FuseWidgetModule } from '@fuse/components/widget/widget.module';
import { ProjectDashboardService } from '../../../welcome/project.service';


const routes: Routes = [
  {
      path     : 'user',
      component: HDURSDashboardComponent,
      resolve  : {
        data: ProjectDashboardService
    }
  }
];


@NgModule({
  imports: [
    RouterModule.forChild(routes), CommonModule,
    CdkTableModule,
        MatButtonModule,
        MatDividerModule,
        MatFormFieldModule,
        MatIconModule,
        MatMenuModule,
        MatSelectModule,
        MatTableModule,
        MatTabsModule,
        NgxChartsModule,
        FuseSharedModule,
        FuseSidebarModule,
        FuseWidgetModule
  ],
  declarations: [HDURSDashboardComponent],
  providers   : [
      ProjectDashboardService
  ]
})
export class HDURSDashboardModule { }
