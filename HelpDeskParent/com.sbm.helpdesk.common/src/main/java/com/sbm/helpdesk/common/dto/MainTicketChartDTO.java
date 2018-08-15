package com.sbm.helpdesk.common.dto;

import java.util.List;

public class MainTicketChartDTO extends BaseDTO {

	private static final long serialVersionUID = 6104011990509049339L;

	private List<WidgetDTO> status;
	private List<WidgetDTO> severity ;
	private List<WidgetDTO> priority ;
	public List<WidgetDTO> getStatus() {
		return status;
	}
	public void setStatus(List<WidgetDTO> status) {
		this.status = status;
	}
	public List<WidgetDTO> getSeverity() {
		return severity;
	}
	public void setSeverity(List<WidgetDTO> severity) {
		this.severity = severity;
	}
	public List<WidgetDTO> getPriority() {
		return priority;
	}
	public void setPriority(List<WidgetDTO> priority) {
		this.priority = priority;
	}
	
	
}
