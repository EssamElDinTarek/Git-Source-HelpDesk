package com.sbm.helpdesk.common.dto;

import java.util.Set;


public class HdroleDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long roleId;
	private String roleName;
	private Set<HduserDTO> hdusers;
	private Set<PermissionDTO> permissions;
	
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
	public Set<HduserDTO> getHdusers() {
		return hdusers;
	}
	public void setHdusers(Set<HduserDTO> hdusers) {
		this.hdusers = hdusers;
	}
	public Set<PermissionDTO> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<PermissionDTO> permissions) {
		this.permissions = permissions;
	}
	
	
	
}
