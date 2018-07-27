package com.sbm.helpdesk.common.dto;

import java.math.BigDecimal;

public class TicketSeverityDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long severityId;
	private String severityName;
	private BigDecimal sevrityTimeConstraint;
	public long getSeverityId() {
		return severityId;
	}
	public void setSeverityId(long severityId) {
		this.severityId = severityId;
	}
	public String getSeverityName() {
		return severityName;
	}
	public void setSeverityName(String severityName) {
		this.severityName = severityName;
	}
	public BigDecimal getSevrityTimeConstraint() {
		return sevrityTimeConstraint;
	}
	public void setSevrityTimeConstraint(BigDecimal sevrityTimeConstraint) {
		this.sevrityTimeConstraint = sevrityTimeConstraint;
	}
	
	
	
	
}
