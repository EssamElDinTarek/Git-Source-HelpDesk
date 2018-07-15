package com.sbm.helpdesk.dto;

import java.util.List;

public class UserDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6104011990509049339L;

	private long id;
	private String email;
	private String password;
	private String username;
	
	private List<GroupDTO> groups;
	private List<MenuDTO> menus;
	private List<PermissionDTO> permissions;
	
	public UserDTO() {}
	
	public UserDTO(long id) {}
	
	public UserDTO(long id , String username ,String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public UserDTO(long id , String email,String password, String username) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public List<GroupDTO> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupDTO> groups) {
		this.groups = groups;
	}

	public List<MenuDTO> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuDTO> menus) {
		this.menus = menus;
	}

	public List<PermissionDTO> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PermissionDTO> permissions) {
		this.permissions = permissions;
	} 
	
}
