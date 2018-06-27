package com.sbm.helpdesk.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRIVILEGE database table.
 * 
 */
public class PrivilegeDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long privilegeId;

	private String privilegeName;

	public long getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(long privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	
	
}