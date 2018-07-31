package com.sbm.helpdesk.common.dto;

import java.util.Set;

public class HduserDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long userId;
	private String emailAddress;
	private String firstName;
	private String lastName;
	private String userName;
	//private String userPassword;
	//private Set<AttachmentDTO> attachments;
//	private Set<HdgroupDTO> hdgroups;
	//private Set<HdroleDTO> hdroles;
	//private TeamDTO team;
	//private Set<TicketDTO> tickets;
	//private Set<TicketcommentDTO> ticketcomments;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	//	public Set<HdgroupDTO> getHdgroups() {
//		return hdgroups;
//	}
//	public void setHdgroups(Set<HdgroupDTO> hdgroups) {
//		this.hdgroups = hdgroups;
//	}
	
	
}
