package com.sbm.helpdesk.service.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TICKET_SEVERITY database table.
 * 
 */
@Entity
@Table(name="TICKET_SEVERITY")
@NamedQuery(name="TicketSeverity.findAll", query="SELECT t FROM TicketSeverity t")
public class TicketSeverity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TICKET_SEVERITY_SEVERITYID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TICKET_SEVERITY_SEVERITYID_GENERATOR")
	@Column(name="SEVERITY_ID", unique=true, nullable=false, precision=22)
	private long severityId;

	@Column(name="SEVERITY_NAME", precision=22)
	private String severityName;

	@Column(name="SEVRITY_TIME_CONSTRAINT", precision=22)
	private BigDecimal sevrityTimeConstraint;

	//bi-directional many-to-one association to Ticket
	//@OneToMany(mappedBy="ticketSeverity")
	//private List<Ticket> tickets;

	public TicketSeverity() {
	}

	public long getSeverityId() {
		return this.severityId;
	}

	public void setSeverityId(long severityId) {
		this.severityId = severityId;
	}

	public String getSeverityName() {
		return this.severityName;
	}

	public void setSeverityName(String severityName) {
		this.severityName = severityName;
	}

	public BigDecimal getSevrityTimeConstraint() {
		return this.sevrityTimeConstraint;
	}

	public void setSevrityTimeConstraint(BigDecimal sevrityTimeConstraint) {
		this.sevrityTimeConstraint = sevrityTimeConstraint;
	}

	/*public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setTicketSeverity(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setTicketSeverity(null);

		return ticket;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (severityId ^ (severityId >>> 32));
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
		TicketSeverity other = (TicketSeverity) obj;
		if (severityId != other.severityId)
			return false;
		return true;
	}

}