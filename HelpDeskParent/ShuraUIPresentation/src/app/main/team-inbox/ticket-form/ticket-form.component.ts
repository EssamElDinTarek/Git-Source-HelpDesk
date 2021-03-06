import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { DataSource } from '@angular/cdk/collections';
import { BehaviorSubject, Observable } from 'rxjs';
import * as shape from 'd3-shape';


import { FuseSidebarService } from '@fuse/components/sidebar/sidebar.service';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { TicketService } from '../../../services/ticket.service';
import { Ticket } from '../../../models/ticket';
import { TicketPriority } from '../../../models/ticket-priority';
import { TicketSeverity } from '../../../models/ticket-severity';
import { Workflow } from '../../../models/workflow';
import { Project } from '../../../models/Project';
import { FileManagerService } from "../../../services/file-manager.service";
import { fuseAnimations } from '@fuse/animations';
import { RequestOptions } from '@angular/http';
import { FileData } from '../../../model/fileData';
import { FileListService } from '../../file-list/file-list.service';
import { SharedDataService } from '../../../services/shared-data.service';
import { MatPaginator, MatSort, MatTableDataSource, MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';




@Component({
  selector: 'app-ticket-form',
  templateUrl: './ticket-form.component.html',
  styleUrls: ['./ticket-form.component.scss'],
  encapsulation: ViewEncapsulation.None,
  animations: fuseAnimations
})
export class TicketFormComponent implements OnInit {
    form: FormGroup;
    formErrors: any;
    private sub: any;
    ticket: Ticket = new Ticket({});
    ticketSeverityList: TicketSeverity[];
    ticketPeriorityList: TicketPriority[];
    workflowList: Workflow[];
    updatedTicketId: string;
    isUpdate: boolean = false;
    //defaultProject: Project= new Project(1,"");
    selected: any;
    pathArr: string[];
    formData: FormData = new FormData();
    filelist: FileList;
    filesData: FileData[] = [];
    dataSource = new MatTableDataSource();


    // Private
    private _unsubscribeAll: Subject<any>;

    /**
     * Constructor
     *
     * @param {FormBuilder} _formBuilder
     */
    constructor(private _fileManagerService: FileManagerService,private _formBuilder: FormBuilder,
         private _ticketService: TicketService, private route: ActivatedRoute,
         private router: Router ,private fileListService: FileListService,
         private sharedDataService : SharedDataService) {
        // Reactive form errors
        this.formErrors = {
            title: {},
            status: {},
            description: {},
            workflow: {},
            severity: {},
            priority: {}
        };

        this._unsubscribeAll = new Subject();
    }

  /**
   * On init
   */
  ngOnInit(): void
  {
   console.log('Call get tickets service');
    this._ticketService.getTicketsByProjectID(this.sharedDataService.selectedProject.projectId,this.sharedDataService.user.emailAddress).subscribe(data => this.dataSource.data = data.data);

        // --------------- query params for update page ------------------

        this.route.queryParams.subscribe((queryParams: Params) => {
            this.updatedTicketId = queryParams['id'];
            //console.log(updatedTicketId);
        });


        this._fileManagerService.onFileSelected
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(selected => {
                this.selected = selected;
                //console.log("selected : " + JSON.stringify(selected) );
                //this.pathArr = selected.location.split('>');
            });


        if (this.updatedTicketId != null && this.updatedTicketId.length > 0 && this.updatedTicketId != "undefined") {
            // update

            this.isUpdate = true;

            this._ticketService.getTicketById(this.updatedTicketId).subscribe(_ticket => {
                
                this.ticket = _ticket;
                
            });
        }
        console.log(this.updatedTicketId);
        // Reactive Form
        this.form = this._formBuilder.group({

            title: ['', Validators.required],
            status: ['', Validators.required],
            description: ['', Validators.required],
            workflow: ['', Validators.required],
            severity: ['', Validators.required],
            priority: ['', Validators.required]
        });

        this.form.valueChanges
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(() => {
                this.onFormValuesChanged();
            });


            this._ticketService.getTicketPriority().subscribe(_ticketPriority => {
                for (let index = 0; index < _ticketPriority.data.length; index++) {
                    this.ticketPeriorityList.push(_ticketPriority.data[index]);
                }
    
            });
            this._ticketService.getTicketSeverity().subscribe(_ticketSeverity => {
                for (let index = 0; index < _ticketSeverity.data.length; index++) {
                    this.ticketSeverityList.push(_ticketSeverity.data[index]);
                }
            });
            this._ticketService.getWorkflow().subscribe(_workflowlist => {
                for (let index = 0; index < _workflowlist.data.length; index++) {
                    this.workflowList.push(_workflowlist.data[index]);
                }
            });
  
  }


  ngOnDestroy(): void {
    // Unsubscribe from all subscriptions
    this._unsubscribeAll.next();
    this._unsubscribeAll.complete();
}


    /**
     * On form values changed
     */
    onFormValuesChanged(): void {
        for (const field in this.formErrors) {
            if (!this.formErrors.hasOwnProperty(field)) {
                continue;
            }

            // Clear previous errors
            this.formErrors[field] = {};

            // Get the control
            const control = this.form.get(field);

            if (control && control.dirty && !control.valid) {
                this.formErrors[field] = control.errors;
            }
        }
    }


    submitTicket(): void {
         
        if (this.isUpdate) {
            this.formData.append('ticket', JSON.stringify(this.ticket));
            if (this.filelist != null && this.filelist.length > 0) {
                for (let index = 0; index < this.filelist.length; index++) {
                    this.formData.append('files', this.filelist.item(index));
                }
                this.formData.append('files', this.filelist.item(0));
            }
            this._ticketService.editTicket(this.formData).subscribe(_ticket => {
                alert('updated successfully');
            
            });
        } else {
            this.ticket.project = this.sharedDataService.selectedProject;
            this.formData.append('ticket', JSON.stringify(this.ticket));
            if (this.filelist != null && this.filelist.length > 0) {
                for (let index = 0; index < this.filelist.length; index++) {
                    this.formData.append('files', this.filelist.item(index));

                }
                this.formData.append('files', this.filelist.item(0));
            }
            this._ticketService.addTicket(this.formData).subscribe(_ticket => {
                alert('added successfully');
                this.ticket = null;
             });
        }
        // forward to ticketView
        this.router.navigate(['/ticketview']);
    }

    fileChange(files:FileList) {
             
            //this.formData.append('files', event.target.files);
        this.filelist = files;
        console.log("files : "+files.length);
        for (let i = 0; i < files.length; i++) {
          /*  this.filesData[i].name = files.item(i).name;
           this.filesData[i].size = files.item(i).size;
           this.filesData[i].ModifiedDate = files.item(i).lastModifiedDate;
           this.filesData[i].type = files.item(i).type; */
           let file : FileData = new FileData();
           file.name = files.item(i).name;
           file.size = files.item(i).size;
           file.ModifiedDate = files.item(i).lastModifiedDate;
           file.type = files.item(i).type;
           this.filesData.push(file);
           this.addFilesData();
        }
                
    }

    addFilesData(): void {
         
            this.fileListService.viewFilesData(this.filesData);
        }

}
