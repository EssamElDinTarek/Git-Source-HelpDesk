package com.sbm.helpdesk.common.dto;

import java.util.List;

public class UserDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6104011990509049339L;

	private long userId;
	private String emailAddress;
	private String userPassword;
	private String userName;
	private String firstName;
	private String lastName;
	
public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	//	private List<GroupDTO> groups;
//	private Team team;
//	private List<MenuDTO> menus;
//	private List<PermissionDTO> permissions;
	private List<ProjectDTO> projects;
	public UserDTO() {}
	
	public UserDTO(long id) {}
	
	public UserDTO(long id , String username ,String password) {
		this.userId = id;
		this.userName = username;
		this.userPassword = password;
	}
	
	public UserDTO(long id , String email,String password, String username) {
		this.userId = id;
		this.emailAddress = email;
		this.userName = username;
		this.userPassword = password;
	}
	
	

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
