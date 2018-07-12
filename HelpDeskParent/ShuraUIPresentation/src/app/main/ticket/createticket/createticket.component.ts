import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import {TicketService} from '../../../services/ticket.service';
import { Ticket } from '../../../models/ticket';
import { TicketPriority } from '../../../models/ticket-priority';
import { TicketSeverity } from '../../../models/ticket-severity';
import { Workflow } from '../../../models/workflow';
@Component({
  selector: 'app-createticket',
  templateUrl: './createticket.component.html',
  styleUrls: ['./createticket.component.scss']
})
export class CreateticketComponent implements OnInit, OnDestroy {
  form: FormGroup;
  formErrors: any;

  ticket: Ticket = new Ticket();
  ticketSeverityList: TicketSeverity[];
  ticketPeriorityList: TicketPriority[];
  workflowList: Workflow[];
  // Private
  private _unsubscribeAll: Subject<any>;

  /**
   * Constructor
   *
   * @param {FormBuilder} _formBuilder
   */
  constructor(private _formBuilder: FormBuilder, private _ticketService: TicketService) {
      // Reactive form errors
      this.formErrors = {
          title   : {},
          status : {},
          description  : {},
          workflow   : {},
          severity   : {},
          priority   : {}
      };

      this._unsubscribeAll = new Subject();
  }

  
  ngOnInit(): void {
      // Reactive Form
      this.form = this._formBuilder.group({
        
          title : ['', Validators.required],
          status  : ['', Validators.required],
          description  : ['', Validators.required],
          workflow   : ['', Validators.required],
          severity   : ['', Validators.required],
          priority   : ['', Validators.required]
      });

      this.form.valueChanges
          .pipe(takeUntil(this._unsubscribeAll))
          .subscribe(() => {
              this.onFormValuesChanged();
          });

    
          this._ticketService.getTicketPriority().subscribe( _ticketPriority => {
            this.ticketPeriorityList = _ticketPriority;
          });
          this._ticketService.getTicketSeverity().subscribe( _ticketSeverity => {
           this.ticketSeverityList = _ticketSeverity;
         });
         this._ticketService.getWorkflow().subscribe( _workflowlist => {
            this.workflowList = _workflowlist;
          });

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
   * On form values changed
   */
  onFormValuesChanged(): void {
      for ( const field in this.formErrors ) {
          if ( !this.formErrors.hasOwnProperty(field) ) {
              continue;
          }

          // Clear previous errors
          this.formErrors[field] = {};

          // Get the control
          const control = this.form.get(field);

          if ( control && control.dirty && !control.valid ) {
              this.formErrors[field] = control.errors;
          }
      }
  }

//   /**
//    * Finish the horizontal stepper
//    */
//   finishHorizontalStepper(): void {
//       alert('You have finished the horizontal stepper!');
//   }

//   /**
//    * Finish the vertical stepper
//    */
//   finishVerticalStepper(): void {
//       alert('You have finished the vertical stepper!');
//   }

  addTicket(): void{
      debugger;
    this._ticketService.addTicket(this.ticket).subscribe(_ticket =>{
        alert('created successfully');
    });
  }

}
