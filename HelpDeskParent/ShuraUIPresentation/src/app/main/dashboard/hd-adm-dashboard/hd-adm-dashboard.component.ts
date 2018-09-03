import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { DataSource } from '@angular/cdk/collections';
import { BehaviorSubject, Observable } from 'rxjs';
import * as shape from 'd3-shape';

import { fuseAnimations } from '@fuse/animations';

import { FuseSidebarService } from '@fuse/components/sidebar/sidebar.service';
import { ProjectDashboardService } from '../../../welcome/project.service';
import { DashBoardService } from '../dashboard.services';
import { Portfolio } from '../../../models/portfolio';
import { Project } from '../../../models/project';
import { MatTableDataSource } from '../../../../../node_modules/@angular/material';
import { SharedDataService } from '../../../services/shared-data.service';
import { User } from '../../../models/user.model';


@Component({
    selector: 'app-hd-adm-dashboard',
    templateUrl: './hd-adm-dashboard.component.html',
    styleUrls: ['./hd-adm-dashboard.component.css'],
    encapsulation: ViewEncapsulation.None,
    animations: fuseAnimations
})
export class HDADMDashboardComponent implements OnInit {

    portofolioID: Number = this._shareData.portfolio.portfolioId;
    userEmail: string = this._shareData.user.emailAddress;
    projectID: number = this._shareData.selectedProject.projectId;

    portoflioList:any;
    selectedPortfolio:Portfolio;
    projectOfPortoflioList:Project[];


    projects: any[];
    selectedProject: any;
    portofolioList: Portfolio[];
    portofolioDetails: any;
    portofolio: any;
    portofolioChartData: any;
    totalNoOfProjects: number[];
    projectsOfPortfolio: Project[];
    numberOfRows:number;

    totalProjects:number;
    portofolios: Portfolio[];
    dataSourceArray1:any = new MatTableDataSource();
    userList: any;

    usersByPortofolio :User[];

    widgets: any;
    widget5: any = {};
    widget6: any = {};
    widget7: any = {};
    widget8: any = {};
    widget9: any = {};
    widget11: any = {};

    dateNow = Date.now();
    constructor(private _fuseSidebarService: FuseSidebarService,
        private _dashboardService: DashBoardService,
        private _shareData: SharedDataService,
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
    portfolioChanged(): void {
         
       this.portofolioID=this.selectedPortfolio.portfolioId;
        this._dashboardService.getProjectsByPortofolioID(this.portofolioID).subscribe(_response => {
            this.projectOfPortoflioList = _response.data;
        });

        /* this._dashboardService.getProjectsByPortofolioID(this.portofolioID).subscribe(_response => {
            this.projectsOfPortfolio = _response.data;
            for (let index = 0; index < this.projectsOfPortfolio.length; index++) {
                console.log('Project Name is : ' + this.projectsOfPortfolio[index].name);

            }
        }); */
    }

    /**
         * On init
         */
    ngOnInit(): void {
        this._dashboardService.getPortofolioDetails().subscribe(_response => {
            this.portofolioDetails = _response.data;
            //this.totalNoOfProjects=this.portofolioDetails.closedProject+this.portofolioDetails.openProject;
            for (let index = 0; index < this.portofolioDetails.length; index++) {
                this.totalNoOfProjects[index]= this.portofolioDetails[index].closedProject + this.portofolioDetails[index].openProject;
                 
                console.log('Total Number of projects = ' + this.totalNoOfProjects[index]);
            }
        });

        this._dashboardService.getPortofolioChart().subscribe(_response => {
            this.portofolioChartData = _response.data;

        });


        this._dashboardService.getUsersByPortofolioID(this.portofolioID).subscribe(_response => {
            this.usersByPortofolio=_response.data;
            console.log('List size = '+this.usersByPortofolio.length);
            
            this.numberOfRows=this.usersByPortofolio.length;
            console.log('No : '+this.numberOfRows);
            this.dataSourceArray1 = this.usersByPortofolio;            


        });


        this._dashboardService.getAllPortofolios().subscribe(_response => {
            this.portofolioList = _response.data;
            this.portofolio = this.portofolioList;
            for (let index = 0; index < this.portofolio.length; index++) {
                console.log(this.portofolio[index].name);

            }

        });


        this.projects = this._projectDashboardService.adminProjects;
        this.selectedProject = this.projects[0];
        this.widgets = this._projectDashboardService.adminWidget;

        this.widget11.onContactsChanged = new BehaviorSubject({});
        this.widget11.onContactsChanged.next(this.widgets.widget11.table.rows);


        this.widget11.dataSource = new FilesDataSource(this.usersByPortofolio);

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


