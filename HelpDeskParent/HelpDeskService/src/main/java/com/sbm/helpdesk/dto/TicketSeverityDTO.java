package com.sbm.helpdesk.dto;

import java.math.BigDecimal;

import com.sbm.helpdesk.entity.*;

public class TicketSeverityDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long severityId;
	private BigDecimal severityName;
	private BigDecimal sevrityTimeConstraint;
	public long getSeverityId() {
		return severityId;
	}
	public void setSeverityId(long severityId) {
		this.severityId = severityId;
	}
	public BigDecimal getSeverityName() {
		return severityName;
	}
	public void setSeverityName(BigDecimal severityName) {
		this.severityName = severityName;
	}
	public BigDecimal getSevrityTimeConstraint() {
		return sevrityTimeConstraint;
	}
	public void setSevrityTimeConstraint(BigDecimal sevrityTimeConstraint) {
		this.sevrityTimeConstraint = sevrityTimeConstraint;
	}
	
	
	
	
}
