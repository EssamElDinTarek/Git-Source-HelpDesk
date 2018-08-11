import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { DataSource } from '@angular/cdk/collections';
import { BehaviorSubject, Observable } from 'rxjs';
import * as shape from 'd3-shape';

import { fuseAnimations } from '@fuse/animations';

import { FuseSidebarService } from '@fuse/components/sidebar/sidebar.service';
import { ProjectDashboardService } from '../../../welcome/project.service';
import { DashBoardService } from '../dashboard.services';
import { Project } from '../../../models/project';
import { SharedDataService } from '../../../services/shared-data.service';
import { MatTableDataSource } from '../../../../../node_modules/@angular/material';


@Component({
    selector: 'app-hd-mgr-dashboard',
    templateUrl: './hd-mgr-dashboard.component.html',
    styleUrls: ['./hd-mgr-dashboard.component.css'],
    encapsulation: ViewEncapsulation.None,
    animations: fuseAnimations
})
export class HDMGRDashboardComponent implements OnInit {
    projects: any[];
   // selectedProject: any;

   projectId: number = this._shareData.selectedProject.projectId;

    widgets: any;
    widget5: any = {};
    widget6: any = {};
    widget7: any = {};
    widget8: any = {};
    widget9: any = {};
    widget11: any = {};

    usersPerProject:any=[];
    dataSourceArray1 =  new MatTableDataSource();


    projectList: Project[];
    projectDetailstList: any[];

    projectChart:any;

    teamPerProject:any;

    projectData:Project;
    selectedProject:any;

    dateNow = Date.now();
    constructor(private _fuseSidebarService: FuseSidebarService,
        private _mgrDashBoard: DashBoardService,
        private _shareData:SharedDataService,
        private _projectDashboardService: ProjectDashboardService) {

        /**
           * Widget 5
           */
        this.widget5 = {
            currentRange: 'TW',
            xAxis: true,
            yAxis: true,
            gradient: false,
            legend: false,
            showXAxisLabel: false,
            xAxisLabel: 'Days',
            showYAxisLabel: false,
            yAxisLabel: 'Isues',
            scheme: {
                domain: ['#42BFF7', '#C6ECFD', '#C7B42C', '#AAAAAA']
            },
            onSelect: (ev) => {
                console.log(ev);
            },
            supporting: {
                currentRange: '',
                xAxis: false,
                yAxis: false,
                gradient: false,
                legend: false,
                showXAxisLabel: false,
                xAxisLabel: 'Days',
                showYAxisLabel: false,
                yAxisLabel: 'Isues',
                scheme: {
                    domain: ['#42BFF7', '#C6ECFD', '#C7B42C', '#AAAAAA']
                },
                curve: shape.curveBasis
            }
        };

        /**
         * Widget 6
         */
        this.widget6 = {
            currentRange: 'TW',
            legend: false,
            explodeSlices: false,
            labels: true,
            doughnut: true,
            gradient: false,
            scheme: {
                domain: ['#f44336', '#9c27b0', '#03a9f4', '#e91e63']
            },
            onSelect: (ev) => {
                console.log(ev);
            }
        };

        /**
         * Widget 7
         */
        this.widget7 = {
            currentRange: 'T'
        };

        /**
         * Widget 8
         */
        this.widget8 = {
            legend: false,
            explodeSlices: false,
            labels: true,
            doughnut: false,
            gradient: false,
            scheme: {
                domain: ['#f44336', '#9c27b0', '#03a9f4', '#e91e63', '#ffc107']
            },
            onSelect: (ev) => {
                console.log(ev);
            }
        };

        /**
         * Widget 9
         */
        this.widget9 = {
            currentRange: 'TW',
            xAxis: false,
            yAxis: false,
            gradient: false,
            legend: false,
            showXAxisLabel: false,
            xAxisLabel: 'Days',
            showYAxisLabel: false,
            yAxisLabel: 'Isues',
            scheme: {
                domain: ['#42BFF7', '#C6ECFD', '#C7B42C', '#AAAAAA']
            },
            curve: shape.curveBasis
        };

        setInterval(() => {
            this.dateNow = Date.now();
        }, 1000);

    }
    /**
         * On init
         */
    ngOnInit(): void {
        this.projects = this._projectDashboardService.mgrProjects;
        this.selectedProject = this.projects[0];
        this.widgets = this._projectDashboardService.mgrWidget;

        this._mgrDashBoard.getTeamsPerProject(this.projectId).subscribe(_response=>{
            console.log('Project is : '+this.projectId);
            this.teamPerProject=_response.data;
        })
 
        this.widget11.onContactsChanged = new BehaviorSubject({});
        this.widget11.onContactsChanged.next(this.widgets.widget11.table.rows);
        this.widget11.dataSource = new FilesDataSource(this.usersPerProject);

        this._mgrDashBoard.getTeamsPerProject(this.projectId).subscribe(_response=>{
            console.log('Project is : '+this.projectId);
            this.dataSourceArray1=_response.data;
        })

        this._mgrDashBoard.getProjectChart().subscribe(_response => {
            this.projectChart = _response.data;
            console.log(this.projectChart);
        });

        this._mgrDashBoard.getProjectDetailsByPortofolioID(0).subscribe(_response => {
            this.projectDetailstList = _response.data;
            console.log(this.projectDetailstList);
        });

        this._mgrDashBoard.getProjectsByPortofolioID(0).subscribe(_response=>{
            this.projectList=_response.data;
            console.log(this.projectList);

        })

    }


    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * Toggle the sidebar
     *
     * @param name
     */
    toggleSidebar(name): void {
        this._fuseSidebarService.getSidebar(name).toggleOpen();
    }

}
export class FilesDataSource extends DataSource<any>
{
    /**
     * Constructor
     *
     * @param _widget11
     */
    constructor(private _widget11) {
        super();
    }

    /**
     * Connect function called by the table to retrieve one stream containing the data to render.
     *
     * @returns {Observable<any[]>}
     */
    connect(): Observable<any[]> {
        return this._widget11.onContactsChanged;
    }

    /**
     * Disconnect
     */
    disconnect(): void {
    }
}

