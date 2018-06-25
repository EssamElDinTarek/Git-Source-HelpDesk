package com.sbm.helpdesk.dto;

import java.util.Set;

import com.sbm.helpdesk.entity.*;

public class SubcomponentDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long subcomponentId;
	private String subcomponentName;
	private Set<GroupSubcomponent> groupSubcomponents;
	private Component component;
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
	public Set<GroupSubcomponent> getGroupSubcomponents() {
		return groupSubcomponents;
	}
	public void setGroupSubcomponents(Set<GroupSubcomponent> groupSubcomponents) {
		this.groupSubcomponents = groupSubcomponents;
	}
	public Component getComponent() {
		return component;
	}
	public void setComponent(Component component) {
		this.component = component;
	}
	
}
