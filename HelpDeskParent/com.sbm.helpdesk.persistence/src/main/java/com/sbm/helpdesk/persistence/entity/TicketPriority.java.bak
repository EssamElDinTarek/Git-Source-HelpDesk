package com.sbm.helpdesk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TICKET_PRIORITY database table.
 * 
 */
@Entity
@Table(name="TICKET_PRIORITY")
@NamedQuery(name="TicketPriority.findAll", query="SELECT t FROM TicketPriority t")
public class TicketPriority extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TICKET_PRIORITY_PRIOPRTIYID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TICKET_PRIORITY_PRIOPRTIYID_GENERATOR")
	@Column(name="PRIOPRTIY_ID", unique=true, nullable=false, precision=22)
	private long prioprtiyId;

	@Column(name="PRIORITY_DESC", length=50)
	private String priorityDesc;

	@Column(name="PRIORITY_LEVEL", length=20)
	private String priorityLevel;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="ticketPriority")
	private List<Ticket> tickets;

	public TicketPriority() {
	}

	public long getPrioprtiyId() {
		return this.prioprtiyId;
	}

	public void setPrioprtiyId(long prioprtiyId) {
		this.prioprtiyId = prioprtiyId;
	}

	public String getPriorityDesc() {
		return this.priorityDesc;
	}

	public void setPriorityDesc(String priorityDesc) {
		this.priorityDesc = priorityDesc;
	}

	public String getPriorityLevel() {
		return this.priorityLevel;
	}

	public void setPriorityLevel(String priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setTicketPriority(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setTicketPriority(null);

		return ticket;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (prioprtiyId ^ (prioprtiyId >>> 32));
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
		TicketPriority other = (TicketPriority) obj;
		if (prioprtiyId != other.prioprtiyId)
			return false;
		return true;
	}

}