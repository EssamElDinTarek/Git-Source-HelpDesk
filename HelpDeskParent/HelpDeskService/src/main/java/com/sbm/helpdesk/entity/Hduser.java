package com.sbm.helpdesk.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


/**
 * The persistent class for the HDUSER database table.
 * 
 */
@Entity
@Table(name="HDUSER")
@NamedQuery(name="Hduser.findAll", query="SELECT h FROM Hduser h")
public class Hduser extends BaseEntity implements Serializable ,UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HDUSER_USERID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HDUSER_USERID_GENERATOR")
	@Column(name="USER_ID", unique=true, nullable=false, precision=22)
	private long userId;

	@Column(name="EMAIL_ADDRESS", length=200)
	private String emailAddress;

	@Column(name="FIRST_NAME", length=200)
	private String firstName;

	@Column(name="LAST_NAME", length=200)
	private String lastName;

	@Column(name="USER_NAME", length=200)
	private String userName;

	@Column(name="USER_PASSWORD", length=200)
	private String userPassword;

	//bi-directional many-to-one association to Attachment
	@OneToMany(mappedBy="hduser")
	private List<Attachment> attachments;

	//bi-directional many-to-many association to Hdgroup
	@ManyToMany(mappedBy="hdusers")
	private List<Hdgroup> hdgroups;

	//bi-directional many-to-many association to Hdrole
	@ManyToMany(mappedBy="hdusers")
	private List<Hdrole> hdroles;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="TEAM_ID")
	private Team team;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="hduser")
	private List<Ticket> tickets;

	//bi-directional many-to-one association to Ticketcomment
	@OneToMany(mappedBy="hduser")
	private List<Ticketcomment> ticketcomments;

	//bi-directional many-to-one association to Workitem
	@OneToMany(mappedBy="hduser")
	private List<Workitem> workitems;

	public Hduser() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<Attachment> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public Attachment addAttachment(Attachment attachment) {
		getAttachments().add(attachment);
		attachment.setHduser(this);

		return attachment;
	}

	public Attachment removeAttachment(Attachment attachment) {
		getAttachments().remove(attachment);
		attachment.setHduser(null);

		return attachment;
	}

	public List<Hdgroup> getHdgroups() {
		return this.hdgroups;
	}

	public void setHdgroups(List<Hdgroup> hdgroups) {
		this.hdgroups = hdgroups;
	}

	public List<Hdrole> getHdroles() {
		return this.hdroles;
	}

	public void setHdroles(List<Hdrole> hdroles) {
		this.hdroles = hdroles;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setHduser(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setHduser(null);

		return ticket;
	}

	public List<Ticketcomment> getTicketcomments() {
		return this.ticketcomments;
	}

	public void setTicketcomments(List<Ticketcomment> ticketcomments) {
		this.ticketcomments = ticketcomments;
	}

	public Ticketcomment addTicketcomment(Ticketcomment ticketcomment) {
		getTicketcomments().add(ticketcomment);
		ticketcomment.setHduser(this);

		return ticketcomment;
	}

	public Ticketcomment removeTicketcomment(Ticketcomment ticketcomment) {
		getTicketcomments().remove(ticketcomment);
		ticketcomment.setHduser(null);

		return ticketcomment;
	}
	

	public List<Workitem> getWorkitems() {
		return this.workitems;
	}

	public void setWorkitems(List<Workitem> workitems) {
		this.workitems = workitems;
	}

	public Workitem addWorkitem(Workitem workitem) {
		getWorkitems().add(workitem);
		workitem.setHduser(this);

		return workitem;
	}

	public Workitem removeWorkitem(Workitem workitem) {
		getWorkitems().remove(workitem);
		workitem.setHduser(null);

		return workitem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hduser other = (Hduser) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

	
	/// --------------------- spring security
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.userPassword;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}