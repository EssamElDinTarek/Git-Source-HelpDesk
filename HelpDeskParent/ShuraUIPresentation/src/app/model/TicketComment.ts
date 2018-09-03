import { User } from "../models/user";

export class TicketComment {
	commentValue: string;
	ticketcommentId: number;
	hduser: User;
	ticketId : number;
	ss:any;
	writtenOn:string;
}