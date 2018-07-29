package com.sbm.helpdesk.common.dto;

import java.util.List;
import java.util.Set;


public class ProjectDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long projectId;
	private String name;
//	private PortfolioDTO portfolio;
	//private List<HduserDTO> hdusers;
	//private Set<Ticket> tickets;
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
//	public Portfolio getPortfolio() {
//		return portfolio;
//	}
//	public void setPortfolio(Portfolio portfolio) {
//		this.portfolio = portfolio;
//	}
//	@Override
//	public String toString() {
//		return "ProjectDTO [projectId=" + projectId + ", name=" + name + "]";
//	}
	
}
