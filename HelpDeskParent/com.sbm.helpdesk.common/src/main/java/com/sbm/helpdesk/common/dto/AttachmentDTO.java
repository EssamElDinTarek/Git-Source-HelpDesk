package com.sbm.helpdesk.common.dto;

import java.util.Date;

public class AttachmentDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long attachmentId;
	private String description;
	private String path;
	private HduserDTO hduser;
	//private TicketDTO ticket;
	private String name;
	private String mimeType;
	private long size;
	private Date creationDate;
	//private WorkitemDTO workitem;
	
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
	public HduserDTO getHduser() {
		return hduser;
	}
	public void setHduser(HduserDTO hduser) {
		this.hduser = hduser;
	}
	/*public TicketDTO getTicket() {
		return ticket;
	}
	public void setTicket(TicketDTO ticket) {
		this.ticket = ticket;
	}*/
	/*public WorkitemDTO getWorkitem() {
		return workitem;
	}
	public void setWorkitem(WorkitemDTO workitem) {
		this.workitem = workitem;
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
}
