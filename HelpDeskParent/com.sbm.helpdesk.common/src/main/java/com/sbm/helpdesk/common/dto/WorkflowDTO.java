package com.sbm.helpdesk.common.dto;

import java.util.List;

public class WorkflowDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	private long flowId;
	private String ticketType;
	//private Set<Ticket> tickets;
	private List<WorkflowStepDTO> workflowSteps;
	
	
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	/*public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}*/
	
	public long getFlowId() {
		return flowId;
	}
	public void setFlowId(long flowId) {
		this.flowId = flowId;
	}
	public List<WorkflowStepDTO> getWorkflowSteps() {
		return workflowSteps;
	}
	public void setWorkflowSteps(List<WorkflowStepDTO> workflowSteps) {
		this.workflowSteps = workflowSteps;
	}
	
	
	
}
