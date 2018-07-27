package com.sbm.helpdesk.common.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

public class HdgroupDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	

	private long groupId;

	private String groupName;

	private PrivilegeDTO privilege;

	private List<SubcomponentDTO> subcomponents;
	
	private List<ComponentDTO> components;
	
	private List<HduserDTO> hdusers;

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

	public PrivilegeDTO getPrivilege() {
		return privilege;
	}

	public void setPrivilege(PrivilegeDTO privilege) {
		this.privilege = privilege;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public List<SubcomponentDTO> getSubcomponents() {
		return subcomponents;
	}
	
	public void setSubcomponents(List<SubcomponentDTO> subcomponents) {
		this.subcomponents = subcomponents;
	}

	public List<ComponentDTO> getComponents() {
		return components;
	}

	public void setComponents(List<ComponentDTO> components) {
		this.components = components;
	}

	public List<HduserDTO> getHdusers() {
		return hdusers;
	}

	public void setHdusers(List<HduserDTO> hdusers) {
		this.hdusers = hdusers;
	}
	
	


	 
	
}
