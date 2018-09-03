import { Component, OnDestroy, OnInit, ViewEncapsulation } from '@angular/core';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { Project } from '../../../models/Project';
import { FuseConfigService } from '@fuse/services/config.service';
import { navigation } from '../../../navigation/navigation';
import { SharedDataService } from '../../../services/shared-data.service';
// import { SharedDataService } from '../../../services/shared-data.service';
// import { UserData } from '../../../constdata/user';

@Component({
    selector     : 'vertical-layout-1',
    templateUrl  : './layout-1.component.html',
    styleUrls    : ['./layout-1.component.scss'],
    encapsulation: ViewEncapsulation.None
})
export class VerticalLayout1Component implements OnInit, OnDestroy
{
    fuseConfig: any;
    navigation: any;

    projects: Project[] = []
    selectedProject: Project;
    currentPortofolio:any={};
    tempPortofolios : any=[];
    // Private
    private _unsubscribeAll: Subject<any>;

    /**
     * Constructor
     *
     * @param {FuseConfigService} _fuseConfigService
     */
    constructor(
        // private _sharedService: SharedDataService,
        private _fuseConfigService: FuseConfigService,
        private _sharedService: SharedDataService

    )
    {
        // Set the defaults
        this.navigation = navigation;

        // Set the private defaults
        this._unsubscribeAll = new Subject();
    }
    

    // -----------------------------------------------------------------------------------------------------
    // @ Lifecycle hooks
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    ngOnInit(): void
    {
        // Subscribe to config changes
        this._fuseConfigService.config
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe((config) => {
                this.fuseConfig = config;
            });
            console.log(JSON.stringify(this._sharedService.projects));
            if(this._sharedService.projects != null || this._sharedService.projects.length > 0){
                console.log("Empty array");
                this._sharedService.projects = [
                {projectId:1,name:"sbmhelpdesk",portfolio:{portfolioId:2,name:"CTC",managerLogjn:""}},
                {projectId:2,name:"sbmshura",portfolio:{portfolioId:1,name:"SBM",managerLogjn:""}}
            ];
            
            var portfolioName = this._sharedService.projects[0].portfolio.name;
            this.tempPortofolios[0]={};
            this.tempPortofolios[0].projects=[];
            this.tempPortofolios[0].portofolioName=this._sharedService.projects[0].portfolio.name;
            this.tempPortofolios[0].id=this._sharedService.projects[0].portfolio.portfolioId;

            for (let index = 0; index < this._sharedService.projects.length; index++) {
                const element = this._sharedService.projects[index];
                if(portfolioName != this._sharedService.projects[index].portfolio.name){ // new portofolio
                    var length = this.tempPortofolios.length;
                    this.tempPortofolios[length]={};
                    this.tempPortofolios[length].projects=[];
                    this.tempPortofolios[length].portofolioName=element.portfolio.name;
                    this.tempPortofolios[length].id=element.portfolio.portfolioId;
                    this.tempPortofolios[length].projects.push(element);
                }else{ // old portofolio
                    //console.log(this.tempPortofolios[this.tempPortofolios.length-1].projects);
                    this.tempPortofolios[this.tempPortofolios.length-1].projects.push(element);
                }
                portfolioName = this._sharedService.projects[index].portfolio.name;
            }
        }
            /* this.tempPortofolios = [
                {
                    "portofolioName":"portofolio1",
                    "projects":[{"projectName":"project1",
                    "id":"project1id"
                },
                {
                    "projectName":"project2",
                    "id":"project2id"
                }]
                },
                {
                    "portofolioName":"portofolio2",
                    "projects":[{"projectName":"project2","id":"project1id"}]
                },
                {
                    "portofolioName":"portofolio3",
                    "projects":[{"projectName":"project3","id":"project1id"}]
                }]; */

        // this.selectedProject =  this._sharedService.selectedProject;

        // if(this._sharedService.user ==null){
        //     this._sharedService.user = UserData;
        //     this.projects = this._sharedService.user.projects;
        //     if(this.projects != null && this.projects.length > 0){
        //         this._sharedService.selectedProject = this.projects[0];
        //         this.selectedProject =  this._sharedService.selectedProject;
        //     }
        // }


    }

    /**
     * On destroy
     */
    ngOnDestroy(): void
    {
        // Unsubscribe from all subscriptions
        this._unsubscribeAll.next();
        this._unsubscribeAll.complete();
    }

    // onChange(): void
    // {
    //    this._sharedService.selectedProject =  this.selectedProject ;
    // }
    
    // objectKeys = Object.keys;
    // project={
    //     PortfolioName : "Project 1",
    //     projects: {
    //         projectName: ["Project 1","Project 2"]
    //     }
    // }
}
