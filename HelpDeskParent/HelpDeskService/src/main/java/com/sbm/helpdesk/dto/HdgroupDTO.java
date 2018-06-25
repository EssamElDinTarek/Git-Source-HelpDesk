package com.sbm.helpdesk.dto;

import java.math.BigDecimal;
import java.util.Set;

import com.sbm.helpdesk.entity.*;

public class HdgroupDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long groupId;
	private String groupName;
	private BigDecimal privilegeId;
	private Set<GroupSubcomponent> groupSubcomponents;
	private Set<Component> components;
	private Set<Hduser> hdusers;
	
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public BigDecimal getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(BigDecimal privilegeId) {
		this.privilegeId = privilegeId;
	}
	public Set<GroupSubcomponent> getGroupSubcomponents() {
		return groupSubcomponents;
	}
	public void setGroupSubcomponents(Set<GroupSubcomponent> groupSubcomponents) {
		this.groupSubcomponents = groupSubcomponents;
	}
	public Set<Component> getComponents() {
		return components;
	}
	public void setComponents(Set<Component> components) {
		this.components = components;
	}
	public Set<Hduser> getHdusers() {
		return hdusers;
	}
	public void setHdusers(Set<Hduser> hdusers) {
		this.hdusers = hdusers;
	}
	
	
}
