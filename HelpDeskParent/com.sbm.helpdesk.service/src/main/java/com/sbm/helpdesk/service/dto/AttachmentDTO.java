package com.sbm.helpdesk.service.dto;

import com.sbm.helpdesk.service.entity.*;

public class AttachmentDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long attachmentId;
	private String description;
	private String path;
	private Hduser hduser;
	private Ticket ticket;
	private Workitem workitem;
	
	public long getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
	public Workitem getWorkitem() {
		return workitem;
	}
	public void setWorkitem(Workitem workitem) {
		this.workitem = workitem;
	}
	
}
