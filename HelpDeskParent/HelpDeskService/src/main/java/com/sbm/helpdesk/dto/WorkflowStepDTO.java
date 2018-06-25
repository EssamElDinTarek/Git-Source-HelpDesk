package com.sbm.helpdesk.dto;

import java.math.BigDecimal;

import com.sbm.helpdesk.entity.*;

public class WorkflowStepDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long id;
	private BigDecimal stepOrder;
	private Step step;
	private Workflow workflow;
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
	public Step getStep() {
		return step;
	}
	public void setStep(Step step) {
		this.step = step;
	}
	public Workflow getWorkflow() {
		return workflow;
	}
	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}
	
}
