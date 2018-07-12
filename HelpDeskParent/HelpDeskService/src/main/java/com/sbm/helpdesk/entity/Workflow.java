package com.sbm.helpdesk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the WORKFLOW database table.
 * 
 */
@Entity
@Table(name="WORKFLOW")
@NamedQuery(name="Workflow.findAll", query="SELECT w FROM Workflow w")
public class Workflow extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WORKFLOW_FLOWID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WORKFLOW_FLOWID_GENERATOR")
	@Column(name="FLOW_ID", unique=true, nullable=false, precision=22)
	private long flowId;

	@Column(name="TICKET_TYPE", length=200)
	private String ticketType;

	//bi-directional many-to-one association to Ticket
	/*@OneToMany(mappedBy="workflow")
	private List<Ticket> tickets;
    */
	//bi-directional many-to-one association to WorkflowStep
	@OneToMany(mappedBy="workflow",fetch = FetchType.EAGER)
	private List<WorkflowStep> workflowSteps;

	public Workflow() {
	}

	public long getFlowId() {
		return this.flowId;
	}

	public void setFlowId(long flowId) {
		this.flowId = flowId;
	}

	public String getTicketType() {
		return this.ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	/*public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setWorkflow(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setWorkflow(null);

		return ticket;
	}*/

	public List<WorkflowStep> getWorkflowSteps() {
		return this.workflowSteps;
	}

	public void setWorkflowSteps(List<WorkflowStep> workflowSteps) {
		this.workflowSteps = workflowSteps;
	}

	/*public WorkflowStep addWorkflowStep(WorkflowStep workflowStep) {
		getWorkflowSteps().add(workflowStep);
		workflowStep.setWorkflow(this);

		return workflowStep;
	}

	public WorkflowStep removeWorkflowStep(WorkflowStep workflowStep) {
		getWorkflowSteps().remove(workflowStep);
		workflowStep.setWorkflow(null);

		return workflowStep;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (flowId ^ (flowId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Workflow other = (Workflow) obj;
		if (flowId != other.flowId)
			return false;
		return true;
	}

}