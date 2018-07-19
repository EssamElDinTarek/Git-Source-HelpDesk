import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';


import { CdkTableModule } from '@angular/cdk/table';
import { MatButtonModule, MatDividerModule, MatFormFieldModule, MatIconModule, MatMenuModule, MatSelectModule, MatTableModule, MatTabsModule } from '@angular/material';
import { NgxChartsModule } from '@swimlane/ngx-charts';

import { FuseSharedModule } from '@fuse/shared.module';
import { FuseSidebarModule } from '@fuse/components';
import { FuseWidgetModule } from '@fuse/components/widget/widget.module';
import { ProjectDashboardService } from '../../../welcome/project.service';

import { HDMGRDashboardComponent } from './hd-mgr-dashboard.component';
import { ManagerDashboardDb } from '../../../fake-db/dashboard-mgr';

const routes: Routes = [
  {
      path     : 'manager',
      component: HDMGRDashboardComponent,
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
  declarations: [HDMGRDashboardComponent],
  providers   : [ManagerDashboardDb]
})
export class HDMGRDashboardModule { }
