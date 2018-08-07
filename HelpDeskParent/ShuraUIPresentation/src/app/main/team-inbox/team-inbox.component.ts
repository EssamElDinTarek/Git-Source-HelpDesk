import { FormControl } from '@angular/forms';
import { debounceTime, distinctUntilChanged, takeUntil } from 'rxjs/operators';

import { FuseSidebarService } from '@fuse/components/sidebar/sidebar.service';

import { Component, OnDestroy, OnInit , TemplateRef,Inject} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { FuseConfigService } from '@fuse/services/config.service';
import { fuseAnimations } from '@fuse/animations';

import { DialogOverviewExampleDialog} from '../dialog-overview/dialog-overview-example.component';
import { SharedDataService } from '../../services/shared-data.service';
import { CdkTableModule} from '@angular/cdk/table';

import { FuseConfirmDialogComponent } from '@fuse/components/confirm-dialog/confirm-dialog.component';

import { BrowserAnimationsModule, NoopAnimationsModule } from '@angular/platform-browser/animations';

 
import { DataSource } from '@angular/cdk/collections';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AfterViewInit, ViewChild} from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource, MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { merge, Observable, of as observableOf} from 'rxjs';
import { catchError, map, startWith, switchMap} from 'rxjs/operators'
import { Location } from '@angular/common';
import { Ticket } from '../../model/ticket';
import { TicketService } from '../../services/ticket.service';
import { TicketFormComponent } from './ticket-form/ticket-form.component';

@Component({
  selector: 'app-team-inbox',
  templateUrl: './team-inbox.component.html',
  styleUrls: ['./team-inbox.component.scss']
})

export class TeamInboxComponent implements OnInit {


  

  @ViewChild('dialogContent')
  dialogContent: TemplateRef<any>;

  Edit: string;
  ticketDialogName: string = "Edit Ticket";
  ticketDialogMessage: string = "Are you sure you want to edit this ticket ?";
  ticketDialogOkLabel:string = "Ok";
  ticketDialogCancelLabel:string = "Cancel";
  ticketConfirmed:boolean = false;


ngOnInit(){
  console.log('on init');  
 // this.ngAfterViewInit();
 
 
  //this._ticketService.getTicketsByProjectID().subscribe(data => this.dataSource.data = data.data);
 //this.dataSource = new FilesDataSource(this._ticketService);
 //console.log(this.dataSource.data);
 }

tickets: TicketFormComponent[];
deleted: boolean;

   
displayedColumns = ['ticketId', 'creationdate', 'description', 'status', 'title', 'ticketnumber','updateTicketNumber'];
dataSource = new MatTableDataSource();


ticket: any;
user: any;
selectedTicket: any[];
dialogRef: any


resultsLength = 0;
isLoadingResults = true;
isRateLimitReached = false;

@ViewChild(MatPaginator) paginator: MatPaginator;
@ViewChild(MatSort) sort: MatSort;



constructor(private http: HttpClient,public dialog: MatDialog,private _shareData: SharedDataService
  , public _ticketService :TicketService, public _matDialog: MatDialog)
   {

}


ngAfterViewInit() {
  //console.log('on after view init');

}



 /**
     * 
     * Edit Ticket     */
    editTicket(ticketId): void
    {

        this._ticketService.getTicketsByProjectID().subscribe(data => this.dataSource.data = data.data);
      //  console.log('Ticket desc is : '+item.description);
        this.dialogRef = this._matDialog.open(TicketFormComponent, {
            panelClass: 'ticket-form-dialog',
            data: { 
                   // ticket:item.ticketIds,
                    dialogName: "this.deleteDialogName",
                    dialogMessage: "this.deleteDialogMessage",
                    dialogOkLabel: "this.deleteDialogOkLabel", 
                    dialogCancelLabel: "this.deleteDialogCancelLabel",
                    confirmed:" this.deleteConfirmed",
                    confirmationComment:"this.deleteComment"
                      }
        });

      
    }


}




/* export interface TicketForm{
  ticketId: number;
  creationdate: string;
  description: string;
  status: string;
  title: string;
  ticketnumber: string;
} */
export class FilesDataSource extends DataSource<any>
{
    /**
     * Constructor
     *
     * @param {TicketService} _ticketService
     */
    constructor(
        private _ticketService: TicketService,
        public dialog: MatDialog,
    )
    {
        super();
    }

    connect(): Observable<any[]>
    {
        return this._ticketService.getTicketsByProjectID();
    }
    /**
     * Disconnect
     */
    disconnect(): void
    {
    }
   
}
