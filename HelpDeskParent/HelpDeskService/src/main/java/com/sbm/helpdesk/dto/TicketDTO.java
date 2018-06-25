package com.sbm.helpdesk.dto;

import java.util.Date;
import java.util.Set;

import com.sbm.helpdesk.entity.*;

public class TicketDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long ticketId;
	private Date creationdate;
	private String description;
	private String status;
	private String title;
	private Set<Attachment> attachments;
	private Hduser hduser;
	private Project project;
	private Set<Status> statuses;
	private Workflow workflow;
	private Set<Ticketcomment> ticketcomments;
	private Set<Workitem> workitems;
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
	public Set<Attachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}
	public Hduser getHduser() {
		return hduser;
	}
	public void setHduser(Hduser hduser) {
		this.hduser = hduser;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Set<Status> getStatuses() {
		return statuses;
	}
	public void setStatuses(Set<Status> statuses) {
		this.statuses = statuses;
	}
	public Workflow getWorkflow() {
		return workflow;
	}
	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}
	public Set<Ticketcomment> getTicketcomments() {
		return ticketcomments;
	}
	public void setTicketcomments(Set<Ticketcomment> ticketcomments) {
		this.ticketcomments = ticketcomments;
	}
	public Set<Workitem> getWorkitems() {
		return workitems;
	}
	public void setWorkitems(Set<Workitem> workitems) {
		this.workitems = workitems;
	}
	
	
}
