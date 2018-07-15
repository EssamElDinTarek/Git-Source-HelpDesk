package com.sbm.helpdesk.dto;

import java.util.Set;

import com.sbm.helpdesk.entity.Hduser;
import com.sbm.helpdesk.entity.Permission;

public class HdroleDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long roleId;
	private String roleName;
	private Set<Hduser> hdusers;
	private Set<Permission> permissions;
	
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<Hduser> getHdusers() {
		return hdusers;
	}
	public void setHdusers(Set<Hduser> hdusers) {
		this.hdusers = hdusers;
	}
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	
	
}
