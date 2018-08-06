package com.sbm.helpdesk.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the STEPS database table.
 * 
 */
@Entity
@Table(name="STEPS")
@NamedQuery(name="Step.findAll", query="SELECT s FROM Step s")
public class Step extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STEPS_STEPID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STEPS_STEPID_GENERATOR")
	@Column(name="STEP_ID", unique=true, nullable=false, precision=22)
	private long stepId;

	@Column(length=200)
	private String step;

	//bi-directional many-to-one association to Stepprocess
	@OneToMany(mappedBy="step", fetch = FetchType.LAZY)
	private List<Stepprocess> stepprocesses;

	//bi-directional many-to-one association to WorkflowStep
	@OneToMany(mappedBy="step")
	private List<WorkflowStep> workflowSteps;

	//bi-directional many-to-one association to Workitem
	@OneToMany(mappedBy="step")
	private List<Workitem> workitems;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="TEAM_ID")
	private Team team;

	@Column(name="IS_DELETED",nullable=false)
	private long deleted;
	
	public Step() {
	}

	public long getStepId() {
		return this.stepId;
	}

	public void setStepId(long stepId) {
		this.stepId = stepId;
	}

	public String getStep() {
		return this.step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public List<Stepprocess> getStepprocesses() {
		return this.stepprocesses;
	}

	public void setStepprocesses(List<Stepprocess> stepprocesses) {
		this.stepprocesses = stepprocesses;
	}

	public Stepprocess addStepprocess(Stepprocess stepprocess) {
		getStepprocesses().add(stepprocess);
		stepprocess.setStep(this);

		return stepprocess;
	}

	public Stepprocess removeStepprocess(Stepprocess stepprocess) {
		getStepprocesses().remove(stepprocess);
		stepprocess.setStep(null);

		return stepprocess;
	}

	public List<WorkflowStep> getWorkflowSteps() {
		return this.workflowSteps;
	}

	public void setWorkflowSteps(List<WorkflowStep> workflowSteps) {
		this.workflowSteps = workflowSteps;
	}

	public WorkflowStep addWorkflowStep(WorkflowStep workflowStep) {
		getWorkflowSteps().add(workflowStep);
		workflowStep.setStep(this);

		return workflowStep;
	}

	public WorkflowStep removeWorkflowStep(WorkflowStep workflowStep) {
		getWorkflowSteps().remove(workflowStep);
		workflowStep.setStep(null);

		return workflowStep;
	}

	public List<Workitem> getWorkitems() {
		return this.workitems;
	}

	public void setWorkitems(List<Workitem> workitems) {
		this.workitems = workitems;
	}

	public Workitem addWorkitem(Workitem workitem) {
		getWorkitems().add(workitem);
		workitem.setStep(this);

		return workitem;
	}

	public Workitem removeWorkitem(Workitem workitem) {
		getWorkitems().remove(workitem);
		workitem.setStep(null);

		return workitem;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	

	public long getDeleted() {
		return deleted;
	}

	public void setDeleted(long deleted) {
		this.deleted = deleted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (stepId ^ (stepId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Step other = (Step) obj;
		if (stepId != other.stepId)
			return false;
		return true;
	}

}