import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { DataSource } from '@angular/cdk/collections';
import { BehaviorSubject, Observable } from 'rxjs';
import * as shape from 'd3-shape';

import { fuseAnimations } from '@fuse/animations';

import { FuseSidebarService } from '@fuse/components/sidebar/sidebar.service';
import { ProjectDashboardService } from '../../../welcome/project.service';
import { TicketService } from '../../../services/ticket.service';
import { Ticket } from '../../../model/ticket';
import { Workflow } from '../../../models/workflow';
import { Status } from '../../../models/status';
import { TicketCategory } from '../../../models/TicketCategory';
import { MainChart } from '../../../models/MainChart';


@Component({
    selector: 'app-hd-urs-dashboard',
    templateUrl: './hd-urs-dashboard.component.html',
    styleUrls: ['./hd-urs-dashboard.component.css'],
    encapsulation: ViewEncapsulation.None,
    animations: fuseAnimations
})
export class HDURSDashboardComponent implements OnInit {

    projects: any[];
    selectedProject: any;
    tickets: Ticket[];
    workflowList: Workflow[];

    categoryData: MainChart;
    selectedCategory: TicketCategory[] = [];

    widgets: any;
    widget5: any = {};
    widget6: any = {};
    widget7: any = {};
    widget8: any = {};
    widget9: any = {};
    widget11: any = {};
    dateNow = Date.now();
    chart: any = {};



    constructor(private _fuseSidebarService: FuseSidebarService,
        private _ticketService: TicketService,
        private _projectDashboardService: ProjectDashboardService) {

        this.chart = {
            currentRange: 'status',
            labels: true,
            doughnut: true,
            scheme: {
                domain: ['#f44336', '#9c27b0', '#03a9f4', '#e91e63']
            }
            /* ,
            onSelect     : (ev) => {
                console.log(ev);
            } */
        };


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


    doSomething(): void {
        /*    this._ticketService.getCategorizationList().subscribe(_result => {
               this.categoryData = _result.data;
             }); */

        if (this.categoryData.priority) {
            console.log('Priority is selected...!');
        } else if (this.categoryData.severity) {
            console.log('Severity is Selected...!');
        } else if (this.categoryData.status){
            console.log('Severity is Selected...!');
        }

    }
    /**
       * On init
       */
    ngOnInit(): void {

        this._ticketService.getWorkFlowList().subscribe(_result => {
            this.workflowList = _result.data;

        });

        this._ticketService.getCategorizationList().subscribe(_result => {
            this.categoryData = _result.data;

        });

        /* navigator.geolocation.getCurrentPosition(
            
            function(position) {  
                //console.log('in get position function...!');
                var latitude=position.coords.latitude.toFixed(2);
                var longitude= position.coords.longitude.toFixed(2);
                console.log(latitude);
                console.log(longitude);  
            }

        ); */

        this.projects = this._projectDashboardService.projects;
        this.selectedProject = this.projects[0];
        this.widgets = this._projectDashboardService.widgets;

        /*  this._ticketService.getTicketsByProjectID().subscribe(_result => {
             this.tickets = _result.data;
             //console.log('Tickets are : '+_result.data);
 
           });
  */
        /*  this._ticketService.getTicketsByProjectID().subscribe(_result => {
           this.tickets = _result.data;
           //console.log('Tickets are : '+_result.data);

         }); */



        /*      this._ticketService.getWorkflow().subscribe(_workflowlist => {
               this.workflowList = _workflowlist.data;
           }); */
        /**
         * Widget 11
         */
        this.widget11.onContactsChanged = new BehaviorSubject({});
        this.widget11.onContactsChanged.next(this.widgets.widget11.table.rows);
        this.widget11.dataSource = new FilesDataSource(this.widget11);
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
