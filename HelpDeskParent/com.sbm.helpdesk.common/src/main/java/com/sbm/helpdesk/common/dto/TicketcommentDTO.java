package com.sbm.helpdesk.common.dto;

import java.util.Date;

public class TicketcommentDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	private long ticketcommentId;
	private String commentValue;
	private HduserDTO hduser;
	private Long ticketId;
    private Date writtenOn;
	public Date getWrittenOn() {
		return writtenOn;
	}
	public void setWrittenOn(Date writtenOn) {
		this.writtenOn = writtenOn;
	}
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
	public HduserDTO getHduser() {
		return hduser;
	}
	public void setHduser(HduserDTO hduser) {
		this.hduser = hduser;
	}
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	
	
	
	
}
