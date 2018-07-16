package com.sbm.helpdesk.service.dto;

import java.util.Set;

import com.sbm.helpdesk.service.entity.Project;

public class PortfolioDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long portfolioId;
	private String name;
	private Set<Project> projects;
	public long getPortfolioId() {
		return portfolioId;
	}
	public void setPortfolioId(long portfolioId) {
		this.portfolioId = portfolioId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	
}
