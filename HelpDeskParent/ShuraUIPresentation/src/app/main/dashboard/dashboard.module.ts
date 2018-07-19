import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HDURSDashboardModule} from './hd-urs-dashboard/hd-urs-dashboard.module';
import { HDADMDashboardModule} from './hd-adm-dashboard/hd-adm-dashboard.module';
import { HDMGRDashboardModule } from './hd-mgr-dashboard/hd-mgr-dashboard.module';


@NgModule({
  imports: [
    CommonModule,
    HDADMDashboardModule,
    HDURSDashboardModule,
    HDMGRDashboardModule
  ],
  declarations: [
    HDADMDashboardModule,
    HDURSDashboardModule,
    HDMGRDashboardModule    
  ]
})
export class DashboardModule { }
