import { Component, Inject, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { Contact } from '../contact.model';
import { TicketService } from '../../../services/ticket.service';






@Component({
  selector: 'app-ticket-form-module',
  templateUrl: './ticket-form-module.component.html',
  styleUrls: ['./ticket-form-module.component.scss']
})
export class TicketFormModuleComponent {




  action: string;
    contact: Contact;
    contactForm: FormGroup;
    dialogTitle: string;

    /**
     * Constructor
     *
     * @param {MatDialogRef<ContactsContactFormDialogComponent>} matDialogRef
     * @param _data
     * @param {FormBuilder} _formBuilder
     */
    constructor(
        public matDialogRef: MatDialogRef<TicketFormModuleComponent>,
        @Inject(MAT_DIALOG_DATA) private _data: any,
        private _formBuilder: FormBuilder, private _ticketService : TicketService
    )
    {
        // Set the defaults
        this.action = _data.action;

        if ( this.action === 'edit' )
        {
            this.dialogTitle = 'Edit Ticket';
            this.contact = _data.contact;
        }
        else
        {
            this.dialogTitle = 'New Ticket';
            this.contact = new Contact({});
        }

        this.contactForm = this.createContactForm();
    }

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
     * Create contact form
     *
     * @returns {FormGroup}
     */
    createContactForm(): FormGroup
    {
        return this._formBuilder.group({
            ticketId      : [this.contact.ticketId],
            title    : [this.contact.title],
            creationdate: [this.contact.creationdate],
            description  : [this.contact.description],
            status: [this.contact.status],
            ticketnumber : [this.contact.ticketnumber],
        });
    }
}
