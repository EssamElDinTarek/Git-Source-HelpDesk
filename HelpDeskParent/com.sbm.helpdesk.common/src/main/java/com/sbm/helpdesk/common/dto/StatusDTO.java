package com.sbm.helpdesk.common.dto;

import java.util.Set;

public class StatusDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	private long statusId;
	private String status;
	//private Set<TicketDTO> tickets;
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
	
	
	
}
