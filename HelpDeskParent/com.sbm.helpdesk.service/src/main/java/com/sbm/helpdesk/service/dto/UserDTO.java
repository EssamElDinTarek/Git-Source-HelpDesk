package com.sbm.helpdesk.service.dto;

import java.util.List;

import com.sbm.helpdesk.service.entity.Team;

public class UserDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6104011990509049339L;

	private long userId;
	private String email;
	private String password;
	private String username;
	
//	private List<GroupDTO> groups;
//	private Team team;
//	private List<MenuDTO> menus;
//	private List<PermissionDTO> permissions;
	private List<ProjectDTO> projects;
	public UserDTO() {}
	
	public UserDTO(long id) {}
	
	public UserDTO(long id , String username ,String password) {
		this.userId = id;
		this.username = username;
		this.password = password;
	}
	
	public UserDTO(long id , String email,String password, String username) {
		this.userId = id;
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

//	public List<GroupDTO> getGroups() {
//		return groups;
//	}
//
//	public void setGroups(List<GroupDTO> groups) {
//		this.groups = groups;
//	}

//	public Team getTeam() {
//		return team;
//	}
//
//	public void setTeam(Team team) {
//		this.team = team;
//	}

//	public List<MenuDTO> getMenus() {
//		return menus;
//	}
//
//	public void setMenus(List<MenuDTO> menus) {
//		this.menus = menus;
//	}
//
//	public List<PermissionDTO> getPermissions() {
//		return permissions;
//	}
//
//	public void setPermissions(List<PermissionDTO> permissions) {
//		this.permissions = permissions;
//	}
//
	public List<ProjectDTO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	} 
	
}
