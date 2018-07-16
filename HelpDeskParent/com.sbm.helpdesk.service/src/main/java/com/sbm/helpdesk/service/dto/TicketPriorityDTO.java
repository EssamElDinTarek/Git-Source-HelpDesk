package com.sbm.helpdesk.service.dto;

import com.sbm.helpdesk.service.entity.*;

public class TicketPriorityDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long prioprtiyId;
	private String priorityDesc;
	private String priorityLevel;
	public long getPrioprtiyId() {
		return prioprtiyId;
	}
	public void setPrioprtiyId(long prioprtiyId) {
		this.prioprtiyId = prioprtiyId;
	}
	public String getPriorityDesc() {
		return priorityDesc;
	}
	public void setPriorityDesc(String priorityDesc) {
		this.priorityDesc = priorityDesc;
	}
	public String getPriorityLevel() {
		return priorityLevel;
	}
	public void setPriorityLevel(String priorityLevel) {
		this.priorityLevel = priorityLevel;
	}
	
	
}
