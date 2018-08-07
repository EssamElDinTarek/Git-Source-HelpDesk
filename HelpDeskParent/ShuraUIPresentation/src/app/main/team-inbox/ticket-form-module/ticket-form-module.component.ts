import { Component, Inject, ViewEncapsulation, OnDestroy, OnInit, ANALYZE_FOR_ENTRY_COMPONENTS } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialog } from '@angular/material';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { fuseAnimations } from '@fuse/animations';
import { TicketPriority } from '../../../models/ticket-priority';
import { TicketSeverity } from '../../../models/ticket-severity';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { TicketHistory } from '../../../models/TicketHistory';
import { reject } from '../../../../../node_modules/@types/q';
import { Contact } from '../contact.model';
import { TicketService } from '../../../services/ticket.service';
import { DialogOverviewExampleDialog } from '../../dialog-overview/dialog-overview-example.component';


export class State {
    constructor(public name: string, public population: string, public flag: string) { }
}




@Component({
    selector: 'app-ticket-form-module',
    templateUrl: './ticket-form-module.component.html',
    styleUrls: ['./ticket-form-module.component.scss'],
    encapsulation: ViewEncapsulation.None,
    animations: fuseAnimations
})




export class TicketFormModuleComponent {

    //step back dialoug
    stepBackComment: string;
    stepBackDialogName: string = "Send Previous";
    stepBackDialogMessage: string = "Please add a comment before send this ticket to the previous step ?";
    stepBackDialogOkLabel: string = "Ok";
    stepBackDialogCancelLabel: string = "Cancel";
    stepBackConfirmed: boolean = false;

    //step forward dialoug
    stepForwardComment: string;
    stepForwardDialogName: string = "Delete";
    stepForwardDialogMessage: string = "Please add a comment before send this ticket to the next step ?";
    stepForwardDialogOkLabel: string = "Ok";
    stepForwardDialogCancelLabel: string = "Cancel";
    stepForwardConfirmed: boolean = false;




    ticketHistory: TicketHistory[];



    verticalStepperStep1: FormGroup;
    verticalStepperStep2: FormGroup;
    verticalStepperStep3: FormGroup;
    verticalStepperStep1Errors: any;
    verticalStepperStep2Errors: any;
    verticalStepperStep3Errors: any;



    action: string;
    contact: Contact;
    contactForm: FormGroup;
    dialogTitle: string;
    // _ticketService : TicketService;
    ticketSeverityList: TicketSeverity[];
    ticketPeriorityList: TicketPriority[];
    ticketStatusList: String[] = ["open", "close", "pending"];

    formData: FormData = new FormData();
    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------


    name: string;
    is_edit: boolean = false;


    isDisabled(): boolean {
        return this.is_edit;
    }

    testMethod() {
        alert('Edit TicketID.....');
    }
    /**
     * Create ticket form
     *
     * @returns {FormGroup}
     */
    createContactForm(): FormGroup {
        return this._formBuilder.group({

            ticketId: [this.contact.ticketId],
            title: [this.contact.title],
            creationdate: [this.contact.creationdate],
            description: [this.contact.description],
            status: [this.contact.status],
            ticketnumber: [this.contact.ticketnumber],
            ticketSeverity: [this.contact.severityList]
        });

    }




    /**
     * Constructor
     *
     * @param {FormBuilder} _formBuilder
     */
    constructor(private httpService: HttpClient, private _ticketService: TicketService,
        public matDialogRef: MatDialogRef<TicketFormModuleComponent>,
        @Inject(MAT_DIALOG_DATA) private _data: any,
        private _formBuilder: FormBuilder, public dialog: MatDialog, ) {

        this.action = _data.action;

        if (this.action === 'edit') {
            this.dialogTitle = 'Edit Ticket';
            this.contact = _data.contact;
        }
        else {
            this.dialogTitle = 'New Ticket';
            this.contact = new Contact({});
        }

        this.contactForm = this.createContactForm();
        console.log('Before calling service...!');

        this.httpService.get('api/Ticket-History')
            .subscribe((response: any) => {

                this.ticketHistory = response;
            });
        console.log('After calling service...!');

    }
    // Reactive form errors

    stepTickBack(): void {
        this._ticketService.stepTicketBackward(this.contact.ticketId).subscribe();
    }

    stepTickForward(): void {
        this._ticketService.stepTicketForward(this.contact.ticketId).subscribe();
    }


    openStepBackDialog(): void {
        let dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
            width: '250px',
            data: { dialogName: this.stepBackDialogName, dialogMessage: this.stepBackDialogMessage, dialogOkLabel: this.stepBackDialogOkLabel, dialogCancelLabel: this.stepBackDialogCancelLabel, confirmed: this.stepBackConfirmed, confirmationComment: this.stepBackComment }
        });


        dialogRef.afterClosed().subscribe(result => {
            console.log('The dialog was closed');
            console.log(result);
            if (result.confirmationComment != null && result.confirmationComment != "") {
                this.stepBackConfirmed = result.confirmed;
                console.log(this.stepBackConfirmed);
                if (this.stepBackConfirmed) {
                    this.stepTickBack();
                }
            }
            else
                alert('You have to add a comment before send the ticket previous');
        });

    }

    openStepForwardDialog(): void {
        let dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
            width: '250px',
            data: { dialogName: this.stepForwardDialogName, dialogMessage: this.stepForwardDialogMessage, dialogOkLabel: this.stepForwardDialogOkLabel, dialogCancelLabel: this.stepForwardDialogCancelLabel, confirmed: this.stepForwardConfirmed, confirmationComment: this.stepForwardComment  }
        });


        dialogRef.afterClosed().subscribe(result => {
            console.log('The dialog was closed');
            console.log(result);
            if (result.confirmationComment != null && result.confirmationComment != "") {
                this.stepBackConfirmed = result.confirmed;
                console.log(this.stepBackConfirmed);
                if (this.stepBackConfirmed) {
                    this.stepTickBack();
                }
            }
            else
                alert('You have to add a comment before send the ticket previous');
        });

    }

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    OnInit() {

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

    }

    submitTicket(): void {
        debugger;
        this.formData.append('ticket', JSON.stringify(this.contact));
        console.log('Before calling submit ticket...!');
        this._ticketService.editTicket(this.formData).subscribe(_ticket => {
            alert('updated successfully');

        });

    }



}


