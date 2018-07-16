package com.sbm.helpdesk.service.dto;

import java.util.Date;
import java.util.Set;

import com.sbm.helpdesk.service.entity.*;

public class TicketDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long ticketId;
	private Date creationdate;
	private String description;
	private String status;
	private String title;
	private String ticketnumber;
	//private Set<AttachmentDTO> attachments;
	//private HduserDTO hduser;
	//private ProjectDTO project;
	//private Set<StatusDTO> statuses;
	private WorkflowDTO workflow;
	//private Set<TicketcommentDTO> ticketcomments;
	//private Set<WorkitemDTO> workitems;
	private TicketPriorityDTO ticketPriority;
	private TicketSeverityDTO ticketSeverity;
	public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public Date getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTicketnumber() {
		return ticketnumber;
	}
	public void setTicketnumber(String ticketnumber) {
		this.ticketnumber = ticketnumber;
	}
	public TicketPriorityDTO getTicketPriority() {
		return ticketPriority;
	}
	public void setTicketPriority(TicketPriorityDTO ticketPriority) {
		this.ticketPriority = ticketPriority;
	}
	public TicketSeverityDTO getTicketSeverity() {
		return ticketSeverity;
	}
	public void setTicketSeverity(TicketSeverityDTO ticketSeverity) {
		this.ticketSeverity = ticketSeverity;
	}
	public WorkflowDTO getWorkflow() {
		return workflow;
	}
	public void setWorkflow(WorkflowDTO workflow) {
		this.workflow = workflow;
	}
	
	
	
	
	
}
