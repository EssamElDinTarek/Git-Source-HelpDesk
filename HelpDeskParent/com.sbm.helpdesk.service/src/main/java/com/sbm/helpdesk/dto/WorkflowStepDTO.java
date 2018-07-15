package com.sbm.helpdesk.dto;

import java.math.BigDecimal;

import com.sbm.helpdesk.entity.*;

public class WorkflowStepDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long id;
	private BigDecimal stepOrder;
	private StepDTO step;
	//private WorkflowDTO workflow;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BigDecimal getStepOrder() {
		return stepOrder;
	}
	public void setStepOrder(BigDecimal stepOrder) {
		this.stepOrder = stepOrder;
	}
	public StepDTO getStep() {
		return step;
	}
	public void setStep(StepDTO step) {
		this.step = step;
	}
	/*public WorkflowDTO getWorkflow() {
		return workflow;
	}
	public void setWorkflow(WorkflowDTO workflow) {
		this.workflow = workflow;
	}*/
	
}
