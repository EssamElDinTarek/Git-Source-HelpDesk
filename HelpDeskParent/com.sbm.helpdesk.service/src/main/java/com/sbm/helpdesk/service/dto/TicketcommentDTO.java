package com.sbm.helpdesk.service.dto;

import com.sbm.helpdesk.service.entity.*;

public class TicketcommentDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	private long ticketcommentId;
	private String commentValue;
	private Hduser hduser;
	private Ticket ticket;
	public long getTicketcommentId() {
		return ticketcommentId;
	}
	public void setTicketcommentId(long ticketcommentId) {
		this.ticketcommentId = ticketcommentId;
	}
	public String getCommentValue() {
		return commentValue;
	}
	public void setCommentValue(String commentValue) {
		this.commentValue = commentValue;
	}
	public Hduser getHduser() {
		return hduser;
	}
	public void setHduser(Hduser hduser) {
		this.hduser = hduser;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	
}
