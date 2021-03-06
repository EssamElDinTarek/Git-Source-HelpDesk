import {TicketSeverity} from './ticket-severity';
import {TicketPriority} from './ticket-priority';
import {Workflow} from './workflow';
import { Project } from './Project';
import { Status } from './status';
import { User } from './user';

export class Ticket {
	ticketId:number;
	description: string;
	status: Status;
	title: string;
	ticketPriority: TicketPriority;
	ticketSeverity: TicketSeverity;
	workflow: Workflow;
	ticketnumber : string;
	project: Project;
	creationdate: string;
	hduser:User = new User();
	
	constructor(ticket){}
}