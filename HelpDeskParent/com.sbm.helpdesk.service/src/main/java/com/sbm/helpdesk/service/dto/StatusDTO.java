package com.sbm.helpdesk.service.dto;

import java.util.Set;

import com.sbm.helpdesk.service.entity.Ticket;

public class StatusDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	private long statusId;
	private String status;
	private Set<Ticket> tickets;
	public long getStatusId() {
		return statusId;
	}
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	
}
