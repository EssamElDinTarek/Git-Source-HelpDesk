import { Component, OnDestroy, OnInit, AfterViewInit, Input } from '@angular/core';
import { DataSource } from '@angular/cdk/collections';
import { Observable, Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { fuseAnimations } from '@fuse/animations';
import { FuseSidebarService } from '@fuse/components/sidebar/sidebar.service';
import { FileManagerService } from '../../services/file-manager.service';
import { SubmitTicketComponent } from '../ticket/submitticket/submitTicket.component';
import { MatTableDataSource } from '../../../../node_modules/@angular/material';
import { FileData } from '../../model/fileData';

@Component({
    selector   : 'file-list',
    templateUrl: './file-list.component.html',
    styleUrls  : ['./file-list.component.scss'],
    animations : fuseAnimations
})

export class FileManagerFileListComponent implements OnInit, OnDestroy ,AfterViewInit
{
    @Input() childfilesData : FileData[];
    submit :SubmitTicketComponent;
    files: any;
    
    //exampleDatabase: ExampleHttpDao | null;
    dataSource = new MatTableDataSource();
    
    //dataSource: FilesDataSource | null;
    displayedColumns = [ 'name', 'type', 'size', 'modified'];
    selected: any;

    // Private
    private _unsubscribeAll: Subject<any>;

    /**
     * Constructor
     *
     * @param {FileManagerService} _fileManagerService
     * @param {FuseSidebarService} _fuseSidebarService
     */
    constructor(
        private _fileManagerService: FileManagerService,
        private _fuseSidebarService: FuseSidebarService
    )
    {
        // Set the private defaults
        this._unsubscribeAll = new Subject();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Lifecycle hooks
    // -----------------------------------------------------------------------------------------------------

    ngAfterViewInit(){
        this.dataSource.data = this.childfilesData;
    }

    /**
     * On init
     */
    ngOnInit(): void
    {
        //this.dataSource = new FilesDataSource(this._fileManagerService);

        this._fileManagerService.onFilesChanged
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(files => {
                this.files = files;
            });

        this._fileManagerService.onFileSelected
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(selected => {
                this.selected = selected;
            });
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

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * On select
     *
     * @param selected
     */
    onSelect(selected): void
    {
        this._fileManagerService.onFileSelected.next(selected);
    }

    /**
     * Toggle the sidebar
     *
     * @param name
     */
    toggleSidebar(name): void
    {
        this._fuseSidebarService.getSidebar(name).toggleOpen();
    }
}

export class FilesDataSource extends DataSource<any>
{
    /**
     * Constructor
     *
     * @param {FileManagerService} _fileManagerService
     */
    constructor(
        private _fileManagerService: FileManagerService
    )
    {
        super();
    }

    /**
     * Connect function called by the table to retrieve one stream containing the data to render.
     *
     * @returns {Observable<any[]>}
     */
    connect(): Observable<any[]>
    {
        return this._fileManagerService.onFilesChanged;
    }

    /**
     * Disconnect
     */
    disconnect(): void
    {
    }
}
