package com.sbm.helpdesk.service.dto;

import java.util.Date;

public class InformationalDetailsDTO extends BaseDTO{

	private static final long serialVersionUID = 1837069428839100713L;
	
    private long infoId;
    
    private String colName;
    private String oldValue;
    private String newValue;
    private Date updatedAt;
    private HduserDTO updatedBy;
    private StepDTO stepId;
    private TicketDTO ticketId;
    
	public InformationalDetailsDTO() {}
	
	public InformationalDetailsDTO(long infoId) {}

	public long getInfoId() {
		return infoId;
	}

	public void setInfoId(long infoId) {
		this.infoId = infoId;
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

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public HduserDTO getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(HduserDTO updatedBy) {
		this.updatedBy = updatedBy;
	}

	public StepDTO getStepId() {
		return stepId;
	}

	public void setStepId(StepDTO stepId) {
		this.stepId = stepId;
	}

	public TicketDTO getTicketId() {
		return ticketId;
	}

	public void setTicketId(TicketDTO ticketId) {
		this.ticketId = ticketId;
	}

}
