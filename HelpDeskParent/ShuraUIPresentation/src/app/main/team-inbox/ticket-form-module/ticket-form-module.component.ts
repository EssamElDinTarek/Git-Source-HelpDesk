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
import { TicketCommentService } from '../../../services/ticket-comment.service';
import { TicketComment } from '../../../model/TicketComment';
import { SharedDataService } from '../../../services/shared-data.service';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Ticket } from '../../../models/ticket';



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




export class TicketFormModuleComponent implements OnInit{



    //step back dialoug
    stepBackComment: string;
    stepBackDialogName: string = "Send Previous";
    stepBackDialogMessage: string = "Please add a comment before send this ticket to the previous step !!";
    stepBackDialogOkLabel: string = "Ok";
    stepBackDialogCancelLabel: string = "Cancel";
    stepBackConfirmed: boolean = false;

    //step forward dialoug
    stepForwardComment: string;
    stepForwardDialogName: string = "Next";
    stepForwardDialogMessage: string = "Please add a comment before send this ticket to the next step !!";
    stepForwardDialogOkLabel: string = "Ok";
    stepForwardDialogCancelLabel: string = "Cancel";
    stepForwardConfirmed: boolean = false;

    updatedTicketId: string;
    ticket: Ticket = new Ticket(this.ticket);

    ngOnInit(): void {

        // --------------- query params for update page ------------------

        this.route.queryParams.subscribe((queryParams: Params) => {
            this.updatedTicketId = queryParams['id'];
            //console.log(updatedTicketId);
        });

        if (this.updatedTicketId != null && this.updatedTicketId.length > 0 && this.updatedTicketId != undefined) {
            // update
        
            this._ticketService.getTicketToUpdate(this.updatedTicketId).subscribe(_ticket => {
    
                this.ticket = _ticket.data;
    
            });
        }

    }




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

    addedStepBackComment: TicketComment;
    addedStepForwardComment: TicketComment;

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
        private _formBuilder: FormBuilder, public dialog: MatDialog, public ticketCommentService: TicketCommentService, public sharedService: SharedDataService,private router: Router,private route: ActivatedRoute) {

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
        this.router.navigate(['/teaminbox']);
    }

    stepTickForward(): void {
        this._ticketService.stepTicketForward(this.contact.ticketId).subscribe();
        this.router.navigate(['/teaminbox']);
    }


    openStepBackDialog(): void {
        let dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
            width: '250px',
            data: { dialogName: this.stepBackDialogName, dialogMessage: this.stepBackDialogMessage, dialogOkLabel: this.stepBackDialogOkLabel, dialogCancelLabel: this.stepBackDialogCancelLabel, confirmed: this.stepBackConfirmed, confirmationComment: this.stepBackComment }
        });


        dialogRef.afterClosed().subscribe(result => {
            console.log('The dialog was closed');
            console.log(result);
            this.stepBackConfirmed = result.confirmed;
            if (result.confirmationComment != null && result.confirmationComment != "") {

                console.log(this.stepBackConfirmed);
                if (this.stepBackConfirmed) {

                    this.addedStepBackComment = new TicketComment();
                    this.addedStepBackComment.commentValue = this.sharedService.user.firstName+" returned the ticket to previous step with comment :- \n"+result.confirmationComment;
                    this.addedStepBackComment.hduser = this.sharedService.user;
                    this.addedStepBackComment.ticketId = +this.contact.ticketId;
                    this.ticketCommentService.addTicketComment(this.addedStepBackComment);
                    this.stepTickBack();

                }
            }
            else if (this.stepBackConfirmed)
                alert('You have to add a comment before you return the ticket to previous');
        });

    }

    openStepForwardDialog(): void {
        let dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
            width: '250px',
            data: { dialogName: this.stepForwardDialogName, dialogMessage: this.stepForwardDialogMessage, dialogOkLabel: this.stepForwardDialogOkLabel, dialogCancelLabel: this.stepForwardDialogCancelLabel, confirmed: this.stepForwardConfirmed, confirmationComment: this.stepForwardComment }
        });


        dialogRef.afterClosed().subscribe(result => {
            console.log('The dialog was closed');
            console.log(result);
            this.stepForwardConfirmed = result.confirmed;
            if (result.confirmationComment != null && result.confirmationComment != "") {

                console.log(this.stepForwardConfirmed);
                if (this.stepForwardConfirmed) {

                    this.addedStepForwardComment = new TicketComment();
                    this.addedStepForwardComment.commentValue = this.sharedService.user.firstName+" has sent the ticket to next step with comment :- \n"+result.confirmationComment;result.confirmationComment;
                    this.addedStepForwardComment.hduser = this.sharedService.user;
                    this.contact.ticketId = 5053;
                    this.addedStepForwardComment.ticketId = this.contact.ticketId;
                    this.ticketCommentService.addTicketComment(this.addedStepForwardComment);
                    this.stepTickForward();

                }
            }
            else if (this.stepForwardConfirmed)
                alert('You have to add a comment before send the ticket to next');
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


