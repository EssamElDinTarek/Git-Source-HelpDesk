import { Component, OnDestroy, OnInit, TemplateRef, ViewChild, ViewEncapsulation } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { MatDialog, MatDialogRef, MatTableDataSource } from '@angular/material';
import { DataSource } from '@angular/cdk/collections';
import { Observable, Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { fuseAnimations } from '@fuse/animations';
import { FuseConfirmDialogComponent } from '@fuse/components/confirm-dialog/confirm-dialog.component';
import { TicketFormModuleComponent } from '../ticket-form-module/ticket-form-module.component';
import { TicketService } from '../../../services/ticket.service';
import { Ticket } from '../../../models/ticket';
import { TicketPriority } from '../../../models/ticket-priority';
import { SharedDataService } from '../../../services/shared-data.service';



@Component({
    selector: 'app-ticket-list',
    templateUrl: './ticket-list.component.html',
    styleUrls: ['./ticket-list.component.scss'],
    encapsulation: ViewEncapsulation.None,
    animations: fuseAnimations
})
export class TicketListComponent implements OnInit {
    @ViewChild('dialogContent')
    dialogContent: TemplateRef<any>;

    tickets :Ticket [];
    user: any;
    dataSource: FilesDataSource | null;
    displayedColumns = [ 'title', 'status', 'description', 'ticketnumber', 'creationdate'];
    selectedTickets: any[];
    checkboxes: {};
    dialogRef: any
    confirmDialogRef: MatDialogRef<FuseConfirmDialogComponent>;
    ticketPeriorityList: TicketPriority[] = [];

    // Private
    private _unsubscribeAll: Subject<any>;

    /**
     * Constructor
     *
     * @param {MatDialog} _matDialog
     */
    constructor(
        private _ticketService: TicketService,
        public _matDialog: MatDialog,public sharedService : SharedDataService
    ) {
        // Set the private defaults
     //   this._ticketService.getTicketsByProjectID;
        this._unsubscribeAll = new Subject();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Lifecycle hooks
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    ngOnInit(): void {

        // console.log('Start OnInit method...!')
        //  this._ticketService.getTicketsByProjectID;
        /* this._ticketService.getTicketsByProjectID().subscribe(_tickets =>{
            this.tickets = _tickets.data;
            console.log(_tickets.data);
         
        }); */
        this._ticketService.getTicketsByProjectID(this.sharedService.selectedProject.projectId,this.sharedService.user.emailAddress).subscribe(_result => {
            this.tickets = _result.data;
           this.dataSource=_result.data;
      
          });

         
        this._ticketService.getTicketPriority().subscribe(_ticketPriority => {
            for (let index = 0; index < _ticketPriority.data.length; index++) {
                this.ticketPeriorityList.push(_ticketPriority.data[index]);
            }
        });
        console.log('Test....!');
       // this.dataSource = new FilesDataSource(this._ticketService)
        console.log('after datasource...!');

        this._ticketService.onTicketsChanged
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(tickets => {
                this.tickets = tickets;

                this.checkboxes = {};
                tickets.map(ticket => {
                    this.checkboxes[ticket.id] = false;
                });
            });

        this._ticketService.onSelectedTicketsChanged
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(selectedContacts => {
                for (const id in this.checkboxes) {
                    if (!this.checkboxes.hasOwnProperty(id)) {
                        continue;
                    }

                    this.checkboxes[id] = selectedContacts.includes(id);
                }
                this.selectedTickets = selectedContacts;
            });

        this._ticketService.onUserDataChanged
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(user => {
                this.user = user;
            });

        this._ticketService.onFilterChanged
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(() => {
                this._ticketService.deselectTickets();
            });

    }


    ngAfterViewInit()
    {
        this._ticketService.getTickets;
    }
    /**
     * On destroy
     */
    ngOnDestroy(): void {
        // Unsubscribe from all subscriptions
        this._unsubscribeAll.next();
        this._unsubscribeAll.complete();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * Edit contact
     *
     * @param ticket
     */
    editTicket(ticket): void {
        this.dialogRef = this._matDialog.open(TicketFormModuleComponent, {
            panelClass: 'ticket-form-dialog',
            data: {
                contact: ticket,
                action: 'edit'
            }
        });

        this.dialogRef.afterClosed()
            .subscribe(response => {
                if (!response) {
                    return;
                }

            });
    }



    /**
     * On selected change
     *
     * @param ticketId
     */
    onSelectedChange(ticketId): void {
        this._ticketService.toggleSelectedTicket(ticketId);
    }


}

export class FilesDataSource extends DataSource<any>
{
    /**
     * Constructor
     *
     * @param {TicketService} _ticketService
     */
    constructor(
        private _ticketService: TicketService
    ) {
        super();
    }

    /**
     * Connect function called by the table to retrieve one stream containing the data to render.
     * @returns {Observable<any[]>}
     */
    connect(): Observable<any[]> {
        return this._ticketService.onTicketsChanged;
    }

    /**
     * Disconnect
     */
    disconnect(): void {
    }
}