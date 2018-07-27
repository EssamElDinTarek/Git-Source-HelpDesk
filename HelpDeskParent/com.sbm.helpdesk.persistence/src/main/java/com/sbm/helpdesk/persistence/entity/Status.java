package com.sbm.helpdesk.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the STATUS database table.
 * 
 */
@Entity
@Table(name="STATUS")
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STATUS_STATUSID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STATUS_STATUSID_GENERATOR")
	@Column(name="STATUS_ID", unique=true, nullable=false, precision=22)
	private long statusId;

	@Column(length=200)
	private String status;

	//bi-directional many-to-many association to Ticket
	 @JoinTable(name = "TICKET_STATUS", joinColumns = {
		        @JoinColumn(name = "STATUS_ID", referencedColumnName = "STATUS_ID")}, inverseJoinColumns = {
		        @JoinColumn(name = "TICKET_ID", referencedColumnName = "TICKET_ID")})
		    @ManyToMany
	private List<Ticket> tickets;

	public Status() {
	}

	public long getStatusId() {
		return this.statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (statusId ^ (statusId >>> 32));
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
		Status other = (Status) obj;
		if (statusId != other.statusId)
			return false;
		return true;
	}
	
	

}