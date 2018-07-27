package com.sbm.helpdesk.persistence.entity;

import java.math.BigDecimal;
import java.util.Date;

public class HistoryDetails{
	
    private String type;
    private String colName;
    private String oldValue;
    private String newValue;
    private BigDecimal actionBy;
    private Date actionAt;
    private String behaviorName;
    private String behaviorValue;
    private BigDecimal id;
    private BigDecimal ticketId;
    private BigDecimal stepId;
    
    public HistoryDetails() {}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public BigDecimal getActionBy() {
		return actionBy;
	}

	public void setActionBy(BigDecimal actionBy) {
		this.actionBy = actionBy;
	}

	public Date getActionAt() {
		return actionAt;
	}

	public void setActionAt(Date actionAt) {
		this.actionAt = actionAt;
	}

	public String getBehaviorName() {
		return behaviorName;
	}

	public void setBehaviorName(String behaviorName) {
		this.behaviorName = behaviorName;
	}

	public String getBehaviorValue() {
		return behaviorValue;
	}

	public void setBehaviorValue(String behaviorValue) {
		this.behaviorValue = behaviorValue;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getTicketId() {
		return ticketId;
	}

	public void setTicketId(BigDecimal ticketId) {
		this.ticketId = ticketId;
	}

	public BigDecimal getStepId() {
		return stepId;
	}

	public void setStepId(BigDecimal stepId) {
		this.stepId = stepId;
	}

}
