package com.sbm.helpdesk.dto;

import java.util.Set;

import com.sbm.helpdesk.entity.Stepprocess;
import com.sbm.helpdesk.entity.WorkflowStep;

public class StepDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long stepId;
	private String step;
	private Set<Stepprocess> stepprocesses;
	private Set<WorkflowStep> workflowSteps;
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
	public Set<Stepprocess> getStepprocesses() {
		return stepprocesses;
	}
	public void setStepprocesses(Set<Stepprocess> stepprocesses) {
		this.stepprocesses = stepprocesses;
	}
	public Set<WorkflowStep> getWorkflowSteps() {
		return workflowSteps;
	}
	public void setWorkflowSteps(Set<WorkflowStep> workflowSteps) {
		this.workflowSteps = workflowSteps;
	}
	
}
