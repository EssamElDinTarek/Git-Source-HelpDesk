package com.sbm.helpdesk.dto;

import com.sbm.helpdesk.entity.*;

public class StepprocessDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	private long processId;
	private String process;
	//private Step step;
	public long getProcessId() {
		return processId;
	}
	public void setProcessId(long processId) {
		this.processId = processId;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	/*public Step getStep() {
		return step;
	}
	public void setStep(Step step) {
		this.step = step;
	}*/
	
}
