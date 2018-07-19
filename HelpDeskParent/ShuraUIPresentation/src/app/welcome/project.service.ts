import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable()
export class ProjectDashboardService implements Resolve<any>
{

    projects: any[];
    widgets: any[];
    adminWidget:any[];
    adminProjects:any[];
    mgrWidget:any[];
    mgrProjects:any[];

    /**
     * Constructor
     *
     * @param {HttpClient} _httpClient
     */
    constructor(
        private _httpClient: HttpClient
    )
    {
    }

    /**
     * Resolver
     *
     * @param {ActivatedRouteSnapshot} route
     * @param {RouterStateSnapshot} state
     * @returns {Observable<any> | Promise<any> | any}
     */
    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> | Promise<any> | any
    {

        return new Promise((resolve, reject) => {

            Promise.all([
                this.getProjects(),
                this.getWidgets(),
                this.getAdminProjects(),
                this.getAdminWidgets(),
                this.getMgrWidgets(),
                this.getMgrProjects()
            
            ]).then(
                () => {
                    resolve();
                },
                reject
            );
        });
    }

    /**
     * Get projects
     *
     * @returns {Promise<any>}
     */
    getProjects(): Promise<any>
    {
        return new Promise((resolve, reject) => {
            this._httpClient.get('api/project-dashboard-projects')
                .subscribe((response: any) => {
                    this.projects = response;
                    resolve(response);
                }, reject);
        });
    }

    /**
     * Get widgets
     *
     * @returns {Promise<any>}
     */
    getWidgets(): Promise<any>
    {
        return new Promise((resolve, reject) => {
            this._httpClient.get('api/project-dashboard-widgets')
                .subscribe((response: any) => {
                    this.widgets = response;
                    resolve(response);
                }, reject);
        });
    }


    /**
     * Get Admin projects
     *
     * @returns {Promise<any>}
     */
    getAdminProjects(): Promise<any>
    {
        return new Promise((resolve, reject) => {
            this._httpClient.get('api/admin-dashboard-projects')
                .subscribe((response: any) => {
                    this.adminProjects = response;
                    resolve(response);
                }, reject);
        });
    }

    /**
     * GetAdmin widgets
     *
     * @returns {Promise<any>}
     */
    getAdminWidgets(): Promise<any>
    {
        return new Promise((resolve, reject) => {
            this._httpClient.get('api/admin-dashboard-widgets')
                .subscribe((response: any) => {
                    this.adminWidget = response;
                    resolve(response);
                }, reject);
        });
    }

 /**
     * Get widgets
     *
     * @returns {Promise<any>}
     */
    getMgrWidgets(): Promise<any>
    {
        return new Promise((resolve, reject) => {
            this._httpClient.get('api/mgr-dashboard-widgets')
                .subscribe((response: any) => {
                    this.mgrWidget= response;
                    resolve(response);
                }, reject);
        });
    }
     
    /**
     * Get Admin projects
     *
     * @returns {Promise<any>}
     */
    getMgrProjects(): Promise<any>
    {
        return new Promise((resolve, reject) => {
            this._httpClient.get('api/mgr-dashboard-projects')
                .subscribe((response: any) => {
                    this.mgrProjects = response;
                    resolve(response);
                }, reject);
        });
    }

}
