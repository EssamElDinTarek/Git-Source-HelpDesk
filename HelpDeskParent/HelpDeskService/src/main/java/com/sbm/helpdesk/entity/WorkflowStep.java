package com.sbm.helpdesk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the WORKFLOW_STEPS database table.
 * 
 */
@Entity
@Table(name="WORKFLOW_STEPS")
@NamedQuery(name="WorkflowStep.findAll", query="SELECT w FROM WorkflowStep w")
public class WorkflowStep extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WORKFLOW_STEPS_WFSTID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WORKFLOW_STEPS_WFSTID_GENERATOR")
	@Column(name="WF_ST_ID", unique=true, nullable=false, precision=38)
	private long wfStId;

	@Column(name="STEP_ORDER", precision=22)
	private BigDecimal stepOrder;

	//bi-directional many-to-one association to Step
	@ManyToOne
	@JoinColumn(name="STEP_ID")
	private Step step;

	//bi-directional many-to-one association to Workflow
	@ManyToOne
	@JoinColumn(name="FLOW_ID")
	private Workflow workflow;

	public WorkflowStep() {
	}

	public long getWfStId() {
		return this.wfStId;
	}

	public void setWfStId(long wfStId) {
		this.wfStId = wfStId;
	}

	public BigDecimal getStepOrder() {
		return this.stepOrder;
	}

	public void setStepOrder(BigDecimal stepOrder) {
		this.stepOrder = stepOrder;
	}

	public Step getStep() {
		return this.step;
	}

	public void setStep(Step step) {
		this.step = step;
	}

	public Workflow getWorkflow() {
		return this.workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (wfStId ^ (wfStId >>> 32));
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
		WorkflowStep other = (WorkflowStep) obj;
		if (wfStId != other.wfStId)
			return false;
		return true;
	}

}