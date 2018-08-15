package com.sbm.helpdesk.common.dto;

import java.util.Date;

public class PortfolioDBDetailsDTO extends BaseDTO {

	private static final long serialVersionUID = 6104011990509049339L;

	private long portfolioId;
	private String name;
	private long closedProject;
	private long openProject;
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
	public long getClosedProject() {
		return closedProject;
	}
	public void setClosedProject(long closedProject) {
		this.closedProject = closedProject;
	}
	public long getOpenProject() {
		return openProject;
	}
	public void setOpenProject(long openProject) {
		this.openProject = openProject;
	}
	
	
	
}
