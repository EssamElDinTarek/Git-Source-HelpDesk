package com.sbm.helpdesk.service.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the STEPPROCESS database table.
 * 
 */
@Entity
@Table(name="STEPPROCESS")
@NamedQuery(name="Stepprocess.findAll", query="SELECT s FROM Stepprocess s")
public class Stepprocess extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STEPPROCESS_PROCESSID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STEPPROCESS_PROCESSID_GENERATOR")
	@Column(name="PROCESS_ID", unique=true, nullable=false, precision=22)
	private long processId;

	@Column(length=200)
	private String process;

	//bi-directional many-to-one association to Component
	@ManyToOne
	@JoinColumn(name="COMPONENT_ID")
	private Component component;

	//bi-directional many-to-one association to Step
	@ManyToOne
	@JoinColumn(name="STEP_ID")
	private Step step;

	public Stepprocess() {
	}

	public long getProcessId() {
		return this.processId;
	}

	public void setProcessId(long processId) {
		this.processId = processId;
	}

	public String getProcess() {
		return this.process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public Component getComponent() {
		return this.component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public Step getStep() {
		return this.step;
	}

	public void setStep(Step step) {
		this.step = step;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (processId ^ (processId >>> 32));
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
		Stepprocess other = (Stepprocess) obj;
		if (processId != other.processId)
			return false;
		return true;
	}

}