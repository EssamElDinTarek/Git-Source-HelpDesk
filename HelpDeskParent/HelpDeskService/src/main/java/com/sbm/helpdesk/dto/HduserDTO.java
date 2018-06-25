package com.sbm.helpdesk.dto;

import java.util.Set;

import com.sbm.helpdesk.entity.*;

public class HduserDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long userId;
	private String emailAddress;
	private String firstName;
	private String lastName;
	private String userName;
	private String userPassword;
	private Set<Attachment> attachments;
	private Set<Hdgroup> hdgroups;
	private Set<Hdrole> hdroles;
	private Team team;
	private Set<Ticket> tickets;
	private Set<Ticketcomment> ticketcomments;
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
	public Set<Attachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}
	public Set<Hdgroup> getHdgroups() {
		return hdgroups;
	}
	public void setHdgroups(Set<Hdgroup> hdgroups) {
		this.hdgroups = hdgroups;
	}
	public Set<Hdrole> getHdroles() {
		return hdroles;
	}
	public void setHdroles(Set<Hdrole> hdroles) {
		this.hdroles = hdroles;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	public Set<Ticketcomment> getTicketcomments() {
		return ticketcomments;
	}
	public void setTicketcomments(Set<Ticketcomment> ticketcomments) {
		this.ticketcomments = ticketcomments;
	}
	
	
}
