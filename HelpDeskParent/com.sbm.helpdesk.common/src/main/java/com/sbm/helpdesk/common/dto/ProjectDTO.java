package com.sbm.helpdesk.common.dto;


public class ProjectDTO extends BaseDTO {

	private static final long serialVersionUID = 6104011990509049339L;

	private long projectId;
	private String name;
	private PortfolioDTO portfolio;
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

	public PortfolioDTO getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(PortfolioDTO portfolio) {
		this.portfolio = portfolio;
	}
	

}
