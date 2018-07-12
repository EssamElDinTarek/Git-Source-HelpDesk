import {TicketSeverity} from './ticket-severity';
import {TicketPriority} from './ticket-priority';
import {Workflow} from './workflow';
export class Ticket {
	description: string;
	status: string;
	title: string;
	ticketPriority: TicketPriority;
	ticketSeverity: TicketSeverity;
	workflow: Workflow;
}