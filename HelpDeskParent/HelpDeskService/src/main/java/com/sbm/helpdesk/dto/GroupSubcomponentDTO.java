package com.sbm.helpdesk.dto;

import com.sbm.helpdesk.entity.*;

public class GroupSubcomponentDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long id;
	private String privilige;
	private Hdgroup hdgroup;
	private Subcomponent subcomponent;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPrivilige() {
		return privilige;
	}
	public void setPrivilige(String privilige) {
		this.privilige = privilige;
	}
	public Hdgroup getHdgroup() {
		return hdgroup;
	}
	public void setHdgroup(Hdgroup hdgroup) {
		this.hdgroup = hdgroup;
	}
	public Subcomponent getSubcomponent() {
		return subcomponent;
	}
	public void setSubcomponent(Subcomponent subcomponent) {
		this.subcomponent = subcomponent;
	}
	
	
}
