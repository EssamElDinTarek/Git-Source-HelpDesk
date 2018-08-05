import {TicketSeverity} from './ticket-severity';
import {TicketPriority} from './ticket-priority';
import {Workflow} from './workflow';
import { Project } from './Project';
export class Ticket {
	description: string;
	title: string;
	ticketPriority: TicketPriority;
	ticketSeverity: TicketSeverity;
	workflow: Workflow;
	ticketNO : string;
	project: Project;
	
}