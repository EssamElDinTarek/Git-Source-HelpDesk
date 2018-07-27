package com.sbm.helpdesk.common.dto;

import java.util.Set;


public class StepDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long stepId;
	private String step;
	private Set<StepprocessDTO> stepprocesses;
	//private Set<WorkflowStepDTO> workflowSteps;
	public long getStepId() {
		return stepId;
	}
	public void setStepId(long stepId) {
		this.stepId = stepId;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public Set<StepprocessDTO> getStepprocesses() {
		return stepprocesses;
	}
	public void setStepprocesses(Set<StepprocessDTO> stepprocesses) {
		this.stepprocesses = stepprocesses;
	}
	/*public Set<WorkflowStepDTO> getWorkflowSteps() {
		return workflowSteps;
	}
	public void setWorkflowSteps(Set<WorkflowStepDTO> workflowSteps) {
		this.workflowSteps = workflowSteps;
	}*/
	
}
