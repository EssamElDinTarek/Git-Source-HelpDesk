package com.sbm.helpdesk.common.dto;

import java.util.Date;

public class ProjectDBDetailsDTO extends BaseDTO {

	private static final long serialVersionUID = 6104011990509049339L;

	private long projectId;
	private String name;
	private String status;
	private long userCount;
	private long ticketCount;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getUserCount() {
		return userCount;
	}
	public void setUserCount(long userCount) {
		this.userCount = userCount;
	}
	public long getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(long ticketCount) {
		this.ticketCount = ticketCount;
	}
	
}
