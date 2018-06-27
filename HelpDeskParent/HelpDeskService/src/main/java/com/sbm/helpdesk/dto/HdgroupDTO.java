package com.sbm.helpdesk.dto;

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

import com.sbm.helpdesk.entity.*;

public class HdgroupDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	

	private long groupId;

	private String groupName;

	private PrivilegeDTO privilege;

 

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

	 
	
}
