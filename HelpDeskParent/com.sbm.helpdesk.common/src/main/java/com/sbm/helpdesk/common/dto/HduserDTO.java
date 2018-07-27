package com.sbm.helpdesk.common.dto;

import java.util.Set;

public class HduserDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long userId;
	private String emailAddress;
	private String firstName;
	private String lastName;
	private String userName;
	private String userPassword;
	//private Set<AttachmentDTO> attachments;
//	private Set<HdgroupDTO> hdgroups;
	private Set<HdroleDTO> hdroles;
	private TeamDTO team;
	private Set<TicketDTO> tickets;
	private Set<TicketcommentDTO> ticketcomments;
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
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
	
public TeamDTO getTeam() {
		return team;
	}
	public void setTeam(TeamDTO team) {
		this.team = team;
	}
	public Set<TicketDTO> getTickets() {
		return tickets;
	}
	public void setTickets(Set<TicketDTO> tickets) {
		this.tickets = tickets;
	}
	public Set<TicketcommentDTO> getTicketcomments() {
		return ticketcomments;
	}
	public void setTicketcomments(Set<TicketcommentDTO> ticketcomments) {
		this.ticketcomments = ticketcomments;
	}
	//	public Set<HdgroupDTO> getHdgroups() {
//		return hdgroups;
//	}
//	public void setHdgroups(Set<HdgroupDTO> hdgroups) {
//		this.hdgroups = hdgroups;
//	}
	public Set<HdroleDTO> getHdroles() {
		return hdroles;
	}
	public void setHdroles(Set<HdroleDTO> hdroles) {
		this.hdroles = hdroles;
	}

	
}
