package com.sbm.helpdesk.service.dto;

import java.util.Set;

import com.sbm.helpdesk.service.entity.Portfolio;
import com.sbm.helpdesk.service.entity.Ticket;

public class ProjectDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long projectId;
	private String name;
	private Portfolio portfolio;
	private Set<Ticket> tickets;
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Portfolio getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	
}
