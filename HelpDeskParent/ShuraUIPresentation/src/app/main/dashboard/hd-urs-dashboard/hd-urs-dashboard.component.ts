import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { DataSource } from '@angular/cdk/collections';
import { BehaviorSubject, Observable } from 'rxjs';
import * as shape from 'd3-shape';
//import { keys } from 'ts-transformer-keys';
import { fuseAnimations } from '@fuse/animations';

import { FuseSidebarService } from '@fuse/components/sidebar/sidebar.service';
import { ProjectDashboardService } from '../../../welcome/project.service';
import { Ticket } from '../../../model/ticket';
import { Workflow } from '../../../models/workflow';
import { MainChart } from '../../../models/MainChart';
import { WeatherModel } from '../../../models/WeatherModel';
import { User } from '../../../models/user.model';
import { DashBoardService } from '../dashboard.services';
import { TicketCategory } from '../../../models/TicketCategory';
import { SharedDataService } from '../../../services/shared-data.service';
import { disableDebugTools } from '../../../../../node_modules/@angular/platform-browser';
import { MatTableDataSource } from '../../../../../node_modules/@angular/material';


@Component({
    selector: 'app-hd-urs-dashboard',
    templateUrl: './hd-urs-dashboard.component.html',
    styleUrls: ['hd-urs-dashboard.component.scss'],
    encapsulation: ViewEncapsulation.None,
    animations: fuseAnimations
})
export class HDURSDashboardComponent implements OnInit {

    projects: any[];
    selectedProject: any;
    tickets: Ticket[];
    usersPerProjects:User[];
    projectId: number ;//=1;
    userEmail: string ;//= 'ahmed.farrag';

    dataSourceArray1:any =  new MatTableDataSource();

    categoryData: MainChart;
    selectedCategory: any;

    workflowList: Workflow[];
    selectedWorkflow:Workflow;
    ticketsOfWorkflowList: Ticket[];
    
    workflowID:Number;
    ticketsOfWorkflow: any[];
    weeklyTasks:any;
    weekelytaskDate:any;
    weekelyTaskFullDate:any[];
    countOfTickets:any[];

    widgets: any;
    widget5: any = {};
    widget6: any = {};
    widget7: any = {};
    widget8: any = {};
    widget9: any = {};
    widget11: any = {};
    dateNow = Date.now();
    chart: any = {};

    openTD:number = 0;
    openYD:number= 0;
    closedTD:number= 0;
    closedYD:number= 0;
    closed:number= 0;
    open:number= 0;
    

   
    
    weekCount:any= {
        'title'     : 'Weekely Tasks',
        'ranges'    : {
             'TW': 'Last Week',
             '2W': '2 Weeks Ago'
        },
        'mainChart' : {
            'TW': [
                {
                    'name'  : '12-07-2018',
                    'series': [
                        {
                            'name' : 'Tickets',
                            'value': 37
                        },
                        {
                            'name' : 'closed tickets',
                            'value': 9
                        }
                    ]
                },
                {
                    'name'  : '13-07-2018',
                    'series': [
                        {
                            'name' : 'Tickets',
                            'value': 32
                        },
                        {
                            'name' : 'closed tickets',
                            'value': 12
                        }
                    ]
                }      
            ]
    }
}


    teamWidget: any = {
        'title': 'Team Members',
        'table': {
            'columns': [ 'username',  'email', ],
            'rows'   : [
                /* {
                    avatar  : 'assets/images/avatars/james.jpg',
                    name    : 'Jack Gilbert',
                    position: 'Design Manager',
                    office  : 'Johor Bahru',
                    email   : 'jgilbert48@mail.com',
                    phone   : '+16 298 032 7774'
                },
                {
                    avatar  : 'assets/images/avatars/katherine.jpg',
                    name    : 'Kathy Anderson',
                    position: 'Recruiting Manager',
                    office  : 'Soltanabad',
                    email   : 'kanderson49@mail.com.br',
                    phone   : '+23 572 311 1136'
                },
                {
                    avatar  : 'assets/images/avatars/andrew.jpg',
                    name    : 'Mark Turner',
                    position: 'Recruiting Manager',
                    office  : 'Neftegorsk',
                    email   : 'mturner4a@mail.com',
                    phone   : '+01 139 803 9263'
                },
                {
                    avatar  : 'assets/images/avatars/jane.jpg',
                    name    : 'Kathryn Martinez',
                    position: 'Director of Sales',
                    office  : 'Palekastro',
                    email   : 'kmartinez4b@mail.com',
                    phone   : '+25 467 022 5393'
                },
                {
                    avatar  : 'assets/images/avatars/alice.jpg',
                    name    : 'Annie Gonzales',
                    position: 'Actuary',
                    office  : 'Candon',
                    email   : 'agonzales4c@mail.edu',
                    phone   : '+99 891 619 7138'
                },
                {
                    avatar  : 'assets/images/avatars/vincent.jpg',
                    name    : 'Howard King',
                    position: 'Human Resources',
                    office  : 'Bergen op Zoom',
                    email   : 'hking4d@mail.gov',
                    phone   : '+46 984 348 1409'
                },
                {
                    avatar  : 'assets/images/avatars/joyce.jpg',
                    name    : 'Elizabeth Dixon',
                    position: 'Electrical Engineer',
                    office  : 'P�secn�',
                    email   : 'edixon4e@mail.gov',
                    phone   : '+33 332 067 9063'
                },
                {
                    avatar  : 'assets/images/avatars/danielle.jpg',
                    name    : 'Dorothy Morris',
                    position: 'Office Assistant',
                    office  : 'Magsaysay',
                    email   : 'dmorris4f@mail.com',
                    phone   : '+05 490 958 6120'
                },
                {
                    avatar  : 'assets/images/avatars/carl.jpg',
                    name    : 'Mark Gonzales',
                    position: 'Quality Control',
                    office  : 'Matsue-shi',
                    email   : 'mgonzales4g@mail.com',
                    phone   : '+03 168 394 9935'
                },
                {
                    avatar  : 'assets/images/avatars/profile.jpg',
                    name    : 'Catherine Rogers',
                    position: 'Programmer Analyst',
                    office  : 'Kangar',
                    email   : 'crogers4h@mail.com',
                    phone   : '+86 235 407 5373'
                },
                {
                    avatar  : 'assets/images/avatars/garry.jpg',
                    name    : 'Ruth Grant',
                    position: 'Community Outreach',
                    office  : 'Beaune',
                    email   : 'rgrant4i@mail.pl',
                    phone   : '+36 288 083 8460'
                },
                {
                    avatar  : 'assets/images/avatars/james.jpg',
                    name    : 'Phyllis Gutierrez',
                    position: 'Administrative Assistant',
                    office  : 'Shlissel�burg',
                    email   : 'pgutierrez4j@mail.net',
                    phone   : '+52 749 861 9304'
                }, {
                    avatar  : 'assets/images/avatars/alice.jpg',
                    name    : 'Lillian Morris',
                    position: 'Media Planner',
                    office  : 'Berlin',
                    email   : 'lmorris4k@mail.de',
                    phone   : '+59 695 110 3856'
                }, {
                    avatar  : 'assets/images/avatars/vincent.jpg',
                    name    : 'Jeremy Anderson',
                    position: 'Systems Engineer',
                    office  : 'Lung H?',
                    email   : 'janderson4l@mail.uk',
                    phone   : '+40 384 115 1448'
                },
                {
                    avatar  : 'assets/images/avatars/carl.jpg',
                    name    : 'Arthur Lawrence',
                    position: 'Nurse Practicioner',
                    office  : 'Sarkanjut',
                    email   : 'alawrence4m@mail.com',
                    phone   : '+36 631 599 7867'
                }, {
                    avatar  : 'assets/images/avatars/andrew.jpg',
                    name    : 'David Simmons',
                    position: 'Social Worker',
                    office  : 'Ushumun',
                    email   : 'dsimmons4n@mail.com',
                    phone   : '+01 189 681 4417'
                }, {
                    avatar  : 'assets/images/avatars/danielle.jpg',
                    name    : 'Daniel Johnston',
                    position: 'Help Desk',
                    office  : 'S�o Carlos',
                    email   : 'djohnston4o@mail.gov',
                    phone   : '+60 028 943 7919'
                },

                {
                    avatar  : 'assets/images/avatars/joyce.jpg',
                    name    : 'Ann King',
                    position: 'Internal Auditor',
                    office  : 'Liren',
                    email   : 'aking4p@mail.com',
                    phone   : '+91 103 932 6545'
                },
                {
                    avatar  : 'assets/images/avatars/james.jpg',
                    name    : 'Phillip Franklin',
                    position: 'VP Accounting',
                    office  : 'Soba',
                    email   : 'pfranklin4q@mail.com',
                    phone   : '+25 820 986 7626'
                },
                {
                    avatar  : 'assets/images/avatars/garry.jpg',
                    name    : 'Gary Gonzalez',
                    position: 'Speech Pathologist',
                    office  : 'Gangkou',
                    email   : 'ggonzalez4r@mail.cc',
                    phone   : '+10 862 046 7916'
                } */
            ]
        }
    };
    weatherResponse:any={};
    weatherResponseMain:any={};
    weatherResponseSystem:any={};
    weatherResponseWind:any={};
    weatherResponseWeather:any={};

    temp:number;
    sunrise:Date;
    place:string;
    country:string;
    humidity:number;
    windSpeed:number;
    windDegree:number;
    maxTemp:number;
    minTemp:number;

    weatherData: WeatherModel = new WeatherModel;

    completedList:any=[];
    noCompletedTickets:number;
    createdList:any=[];
    inprogressList:any=[];

    constructor(private _fuseSidebarService: FuseSidebarService,
        private _dashBoardService: DashBoardService,
        private _shareData: SharedDataService,
        private _projectDashboardService: ProjectDashboardService) {
     
        this.chart = {
            currentRange: 'status',
            labels: true,
            doughnut: true,
            scheme: {
                domain: ['#f44336', '#9c27b0', '#03a9f4', '#e91e63']
            }
        };


        /**
           * Widget 5
           */
        this.widget5 = {
            currentRange: 'lW',
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
            currentRange: '2W',
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


    workFlowChanged(): void {
        //
        this.workflowID=this.selectedWorkflow.flowId;
        this._dashBoardService.getTicketsByWorkFlowID(this.workflowID,this.userEmail).subscribe(_result => {
            //
            this.ticketsOfWorkflowList = _result.data;
        });
    }

         numberOfRows:number ;

    /**
       * On init
       */
    ngOnInit(): void {


        if(navigator.geolocation){
            navigator.geolocation.getCurrentPosition( _pos =>{
                this._dashBoardService.getCurrentWeather(_pos.coords.latitude,_pos.coords.longitude).subscribe(_result => {
                   
                    this.weatherResponse=_result;
                    this.weatherResponseSystem=_result.sys;
                    this.weatherResponseMain=_result.main;
                    this.weatherResponseWind=_result.wind;



                     this.maxTemp=this.weatherResponseMain.temp_max;
                     this.minTemp=this.weatherResponseMain.temp_min;

                    console.log('Date is :'+this.weatherResponse.dt);
                     console.log('Humidity is: '+this.weatherResponseMain.humidity);
                     console.log('Temp_Max is: '+this.weatherResponseMain.temp_max);
                     console.log('Temp_Min is: '+this.weatherResponseMain.temp_min);

                     this.windSpeed=this.weatherResponseWind.speed;
                     this.windDegree=this.weatherResponseWind.deg;

                     console.log('Wind Speed is: '+this.weatherResponseWind.speed);
                     console.log('Wind degree is: '+this.weatherResponseWind.deg);
                   
                     console.log('Sunset at: '+this.weatherResponseSystem.sunset);
                     console.log('Sunrise at: '+this.weatherResponseSystem.sunrise);

                     console.log( this.country=this.weatherResponseSystem.country);
                     console.log( this.place=this.weatherResponse.name);

                     this.temp=this.weatherResponseMain.temp;
                     this.humidity=this.weatherResponseMain.humidity;
                });
                console.log(_pos);
               
            });
        }
    

    // 
    
    this.projectId = this._shareData.selectedProject.projectId;
    this.userEmail = this._shareData.user.emailAddress;

       this._dashBoardService.getWeeklyTickets(this.projectId).subscribe(_result=>{
             this.weeklyTasks=_result.data;
              for (let index = 0; index < this.weeklyTasks.length; index++) {   
                 if(this.weeklyTasks[index].name=='created') {
                    this.createdList.push(this.weeklyTasks[index]);
                    console.log('Created Tickets : '+this.weeklyTasks[index].value);
                 }else if(this.weeklyTasks[index].name=='completed'){
                     
                     this.completedList.push(this.weeklyTasks[index]);
                     this.noCompletedTickets=this.weeklyTasks[index].value
                     console.log('Completed Tickets : '+this.weeklyTasks[index].value);
                 }else{
                     
                    this.inprogressList.push(this.weeklyTasks[index]);
                     console.log('All other are inprogress status...!');
                 }
            }  
            
            console.log('Weekely Tasks : '+this.weeklyTasks);
            console.log('Weekely Tasks list size = '+this.weeklyTasks.length);
            
      });
 
          
         this._dashBoardService.getTicketsCounts(this.projectId,this.userEmail).subscribe(_result=>{
             console.log('Project is  : '+this.projectId);
             this.countOfTickets=_result.data;

             for (let index = 0; index < this.countOfTickets.length; index++) {
                 
                if(this.countOfTickets[index].name=="openTD"){
                    this.openTD=this.countOfTickets[index].value;
                }else if(this.countOfTickets[index].name=="openYD"){
                  this.openYD =this.countOfTickets[index].value;
                }else if(this.countOfTickets[index].name=="closedTD"){
                    this.closedTD=this.countOfTickets[index].value;
                } else if(this.countOfTickets[index].name=="closedYD"){
                    this.closedYD=this.countOfTickets[index].value;
                }else if(this.countOfTickets[index].name=="closed"){
                   this.closed= this.countOfTickets[index].value;
                }else if(this.countOfTickets[index].name=="open"){
                    this.open=this.countOfTickets[index].value;
                }
            }
             console.log(this.countOfTickets);
         })
        
          this._dashBoardService.getWorkFlowList().subscribe(_result => {
              this.workflowList = _result.data;
                this.workflowID = this.workflowList[0].flowId;
          });


          this._dashBoardService.getCategorizationList(this.userEmail).subscribe(_result => {
              this.categoryData = _result.data;
              this.selectedCategory = { key: "status", value: this.categoryData.status };
              console.log(this.selectedCategory);
          });
  

          //users per project service...
           this._dashBoardService.getUsersByProjectID(1).subscribe(_result => {
            
            this.usersPerProjects = _result.data;
            this.dataSourceArray1=this.usersPerProjects;
            
            this.numberOfRows=this.usersPerProjects.length;
            
           });

            /*
            var rows = [];
            for (let index = 0; index < this.usersPerProjects.length; index++) {
                //const element = this.usersPerProjects[index];
               // this.teamWidget.table.rows[index].avatar='assets/images/avatars/joyce.jpg';
               // this.teamWidget.table.rows[index] ={}; 
               rows[index]={}; 
               rows[index].name= this.usersPerProjects[index].firstName;//'Ann King';
                rows[index].position= this.usersPerProjects[index].lastName;//'Internal Auditor';
                rows[index].email= this.usersPerProjects[index].email;//'aking4p@mail.com';
                rows[index].phone= this.usersPerProjects[index].username;//'+91 103 932 6545';
                this.teamWidget.table.rows[index] = rows[index];
            }
            

        }); */
        


        this.projects = this._projectDashboardService.projects;
        this.selectedProject = this.projects[0];
        this.widgets = this._projectDashboardService.widgets;
    



        /**
         * Widget 11
         */
        console.log('Team Widget is '+JSON.stringify(this.teamWidget));
        this.teamWidget.onContactsChanged = new BehaviorSubject({});
        this.teamWidget.onContactsChanged.next(this.teamWidget.table.rows);
        this.teamWidget.dataSource = new FilesDataSource(this.usersPerProjects);
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
