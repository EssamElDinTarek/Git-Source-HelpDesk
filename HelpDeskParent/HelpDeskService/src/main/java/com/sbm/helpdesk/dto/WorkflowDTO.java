package com.sbm.helpdesk.dto;

import java.util.Set;

import com.sbm.helpdesk.entity.*;

public class WorkflowDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private Set<Workitem> workitems;
	private String ticketType;
	private Set<Ticket> tickets;
	private Set<WorkflowStep> workflowSteps;
	public Set<Workitem> getWorkitems() {
		return workitems;
	}
	public void setWorkitems(Set<Workitem> workitems) {
		this.workitems = workitems;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	public Set<WorkflowStep> getWorkflowSteps() {
		return workflowSteps;
	}
	public void setWorkflowSteps(Set<WorkflowStep> workflowSteps) {
		this.workflowSteps = workflowSteps;
	}
	
}
