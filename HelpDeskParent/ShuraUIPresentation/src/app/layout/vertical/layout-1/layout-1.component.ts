import { Component, OnDestroy, OnInit, ViewEncapsulation } from '@angular/core';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { Project } from '../../../models/Project';
import { FuseConfigService } from '@fuse/services/config.service';
import { navigation } from '../../../navigation/navigation';
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
    // Private
    private _unsubscribeAll: Subject<any>;

    /**
     * Constructor
     *
     * @param {FuseConfigService} _fuseConfigService
     */
    constructor(
        // private _sharedService: SharedDataService,
        private _fuseConfigService: FuseConfigService
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
