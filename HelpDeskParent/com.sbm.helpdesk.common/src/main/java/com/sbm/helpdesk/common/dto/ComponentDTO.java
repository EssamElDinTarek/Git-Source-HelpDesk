package com.sbm.helpdesk.common.dto;

import java.util.Set;
public class ComponentDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long componentId;
	private String componentName;
//	private Set<Hdgroup> hdgroups;
//	private Set<Subcomponent> subcomponents;
	public long getComponentId() {
		return componentId;
	}
	public void setComponentId(long componentId) {
		this.componentId = componentId;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
//	public Set<Hdgroup> getHdgroups() {
//		return hdgroups;
//	}
//	public void setHdgroups(Set<Hdgroup> hdgroups) {
//		this.hdgroups = hdgroups;
//	}
//	public Set<Subcomponent> getSubcomponents() {
//		return subcomponents;
//	}
//	public void setSubcomponents(Set<Subcomponent> subcomponents) {
//		this.subcomponents = subcomponents;
//	}
	
	
}
