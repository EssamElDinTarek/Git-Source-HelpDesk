import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { CdkTableModule } from '@angular/cdk/table';
import { MatButtonModule, MatDividerModule, MatFormFieldModule, MatIconModule, MatMenuModule, MatSelectModule, MatTableModule, MatTabsModule } from '@angular/material';
import { NgxChartsModule } from '@swimlane/ngx-charts';

import { FuseSharedModule } from '@fuse/shared.module';
import { FuseSidebarModule } from '@fuse/components';
import { FuseWidgetModule } from '@fuse/components/widget/widget.module';
import { HDADMDashboardComponent } from './hd-adm-dashboard.component';
import { AdminDashboardDb } from '../../../fake-db/dashboard-admin';
import { ProjectDashboardService } from '../../../welcome/project.service';

const routes: Routes = [
  {
      path     : 'admin',
      component: HDADMDashboardComponent,
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
  declarations: [HDADMDashboardComponent],
  providers:[AdminDashboardDb]
})
export class HDADMDashboardModule { }
