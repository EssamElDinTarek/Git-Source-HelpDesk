package com.sbm.helpdesk.common.dto;

import java.util.Date;

public class BehavioralDetailsDTO extends BaseDTO{
	
	private static final long serialVersionUID = -1426700258613198346L;
	
	private long behaviorId;
    private String behaviorName;
    private String behaviorValue;
    private Date actionAt;
    private UserDTO actionBy;
    private StepDTO stepId;
    private TicketDTO ticketId;
    private long id;
    
    
	public long getBehaviorId() {
		return behaviorId;
	}
	public void setBehaviorId(long behaviorId) {
		this.behaviorId = behaviorId;
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
	public Date getActionAt() {
		return actionAt;
	}
	public void setActionAt(Date actionAt) {
		this.actionAt = actionAt;
	}
	public UserDTO getActionBy() {
		return actionBy;
	}
	public void setActionBy(UserDTO actionBy) {
		this.actionBy = actionBy;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
