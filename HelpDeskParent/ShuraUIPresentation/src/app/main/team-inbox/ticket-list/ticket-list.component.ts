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


@Component({
  selector: 'app-ticket-list',
  templateUrl: './ticket-list.component.html',
  styleUrls: ['./ticket-list.component.scss'],
  encapsulation: ViewEncapsulation.None,
    animations   : fuseAnimations
})
export class TicketListComponent implements OnInit  {
    @ViewChild('dialogContent')
    dialogContent: TemplateRef<any>;

    tickets: any;
    user: any;
    dataSource: FilesDataSource | null;
    //displayedColumns = ['ticketId', 'title', 'status', 'description', 'ticketnumber', 'creationdate'];
    displayedColumns = ['ticketId', 'description','creationdate'];
    selectedTickets: any[];
    checkboxes: {};
    dialogRef: any
    confirmDialogRef: MatDialogRef<FuseConfirmDialogComponent>;

    // Private
    private _unsubscribeAll: Subject<any>;

    /**
     * Constructor
     *
     * @param {MatDialog} _matDialog
     */
    constructor(
        private _ticketService:TicketService,
        public _matDialog: MatDialog
    )
    {
        // Set the private defaults
        this._ticketService.getTicketsByProjectID;
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
        this.dataSource = new FilesDataSource(this._ticketService);

       // console.log('Start OnInit method...!')
      //  this._ticketService.getTicketsByProjectID;
        this._ticketService.getTicketsByProjectID().subscribe(_tickets =>{
            this.tickets = _tickets.data;
            console.log(_tickets.data);
         
        });
        

        this._contactsService.onContactsChanged
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(contacts => {
                this.contacts = contacts;

                this.checkboxes = {};
                contacts.map(contact => {
                    this.checkboxes[contact.id] = false;
                });
            });
/*
        this._contactsService.onSelectedContactsChanged
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(selectedContacts => {
                for ( const id in this.checkboxes )
                {
                    if ( !this.checkboxes.hasOwnProperty(id) )
                    {
                        continue;
                    }

                    this.checkboxes[id] = selectedContacts.includes(id);
                }
                this.selectedContacts = selectedContacts;
            });

        this._contactsService.onUserDataChanged
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(user => {
                this.user = user;
            });

        this._contactsService.onFilterChanged
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(() => {
                this._contactsService.deselectContacts();
            });
    */
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
     * Edit contact
     *
     * @param ticket
     */
    editTicket(ticket): void
    {
        this.dialogRef = this._matDialog.open(TicketFormModuleComponent, {
            panelClass: 'ticket-form-dialog',
            data      : {
                contact: ticket,
                action : 'edit'
            }
        });

        this.dialogRef.afterClosed()
            .subscribe(response => {
                if ( !response )
                {
                    return;
                }
                
            });
    }

   

    /**
     * On selected change
     *
     * @param ticketId
     */
    onSelectedChange(ticketId): void
    {
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
    )
    {
        super();
    }

    /**
     * Connect function called by the table to retrieve one stream containing the data to render.
     * @returns {Observable<any[]>}
     */
    connect(): Observable<any[]>
    {
        return this._ticketService.onTicketsChanged;
    }

    /**
     * Disconnect
     */
    disconnect(): void
    {
    }
}