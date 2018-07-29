package com.sbm.helpdesk.common.dto;

import java.util.Set;

import javax.persistence.Column;


public class SubcomponentDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	
	private long subcomponentId;
	private String subcomponentName;
	
	
	public long getSubcomponentId() {
		return subcomponentId;
	}
	public void setSubcomponentId(long subcomponentId) {
		this.subcomponentId = subcomponentId;
	}
	public String getSubcomponentName() {
		return subcomponentName;
	}
	public void setSubcomponentName(String subcomponentName) {
		this.subcomponentName = subcomponentName;
	}
	

}
