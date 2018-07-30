import {TicketSeverity} from './ticket-severity';
import {TicketPriority} from './ticket-priority';

import { FuseUtils } from '@fuse/utils';

import {Workflow} from './workflow';

export class Ticket {
	id:string;
	description: string;
	status: string;
    title: string;
    project:string;
	ticketPriority: TicketPriority;
	ticketSeverity: TicketSeverity;
	workflow: Workflow;



	/**
     * Constructor
     *
     * @param ticket
     */
    constructor(ticket)
    {
        {
            this.id = ticket.id ;
            this.title = ticket.name || '';
            this.description = ticket.description;
            this.status = ticket.status;
        }
    }
}