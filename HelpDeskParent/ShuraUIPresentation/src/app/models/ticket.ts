import {TicketSeverity} from './ticket-severity';
import {TicketPriority} from './ticket-priority';
import {Workflow} from './workflow';
import { Project } from './Project';
import { Status } from './status';

export class Ticket {
	ticketId:string;
	description: string;
	status: Status;
	title: string;
	ticketPriority: TicketPriority;
	ticketSeverity: TicketSeverity;
	workflow: Workflow;
	ticketNO : string;
	project: Project;
	constructor(ticket){}
}