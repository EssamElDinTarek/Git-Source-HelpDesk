import { Component, Inject, ViewEncapsulation, OnDestroy, OnInit, ANALYZE_FOR_ENTRY_COMPONENTS } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
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

   

   
    ticketHistory:TicketHistory[];
   

   
    verticalStepperStep1: FormGroup;
    verticalStepperStep2: FormGroup;
    verticalStepperStep3: FormGroup;
    verticalStepperStep1Errors: any;
    verticalStepperStep2Errors: any;
    verticalStepperStep3Errors: any;



    action: string;
    contact: Contact ;
    contactForm: FormGroup;
    dialogTitle: string;
   // _ticketService : TicketService;
    ticketSeverityList: TicketSeverity[];
    ticketPeriorityList: TicketPriority[];
    ticketStatusList: String[]=["open","close","pending"];

    formData: FormData = new FormData();
    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------


    name:string;
    is_edit : boolean = false;
  
  
   isDisabled() : boolean{
     return this.is_edit;
   }

    testMethod(){
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
            ticketSeverity:[this.contact.severityList]
        });

    }




    /**
     * Constructor
     *
     * @param {FormBuilder} _formBuilder
     */
    constructor(private httpService: HttpClient,private _ticketService : TicketService,
        public matDialogRef: MatDialogRef<TicketFormModuleComponent>,
        @Inject(MAT_DIALOG_DATA) private _data: any,
        private _formBuilder: FormBuilder )
         {

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

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    OnInit() {
        
        this._ticketService.getTicketPriority().subscribe(_ticketPriority => {
            this.ticketPeriorityList = _ticketPriority;
        });
        this._ticketService.getTicketSeverity().subscribe(_ticketSeverity => {
            this.ticketSeverityList = _ticketSeverity;
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
    

