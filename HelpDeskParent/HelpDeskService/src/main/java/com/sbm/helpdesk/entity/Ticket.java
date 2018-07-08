package com.sbm.helpdesk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TICKET database table.
 * 
 */
@Entity
@Table(name="TICKET")
@NamedQueries({
	@NamedQuery(name="Ticket.findAll", query="SELECT t FROM Ticket t"),
	@NamedQuery(name="Ticket.findByTicketNumber", query="SELECT t FROM Ticket t where t.ticketnumber=:arg1"),
	@NamedQuery(name="Ticket.findByProjectName", query="SELECT t FROM Ticket t join t.project p where p.name=:arg1")
})

public class Ticket extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TICKET_TICKETID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TICKET_TICKETID_GENERATOR")
	@Column(name="TICKET_ID", unique=true, nullable=false, precision=22)
	private long ticketId;

	@Temporal(TemporalType.DATE)
	private Date creationdate;

	@Column(name="TICKET_NUMBER",length=50)
	private String ticketnumber;

	@Column(length=255)
	private String description;
	
	@Column(length=255)
	private String status;

	@Column(length=255)
	private String title;

	//bi-directional many-to-one association to Attachment
	@OneToMany(mappedBy="ticket")
	private List<Attachment> attachments;

	//bi-directional many-to-one association to Hduser
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CREATOR_ID")
	private Hduser hduser;

	//bi-directional many-to-one association to Project
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PROJECT_ID")
	private Project project;

	//bi-directional many-to-many association to Status
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="TICKET_STATUS"
		, joinColumns={
			@JoinColumn(name="TICKET_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="STATUS_ID")
			}
		)
	private List<Status> statuses;

	//bi-directional many-to-one association to Ticket
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="STEP_ID")
	private Ticket ticket;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="ticket")
	private List<Ticket> tickets;

	//bi-directional many-to-one association to TicketPriority
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PRIORITY_ID")
	private TicketPriority ticketPriority;

	//bi-directional many-to-one association to TicketSeverity
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="SEVERITY_ID")
	private TicketSeverity ticketSeverity;

	//bi-directional many-to-one association to Workflow
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="WORKFLOW_ID")
	private Workflow workflow;

	//bi-directional many-to-one association to Ticketcomment
	@OneToMany(mappedBy="ticket")
	private List<Ticketcomment> ticketcomments;

	//bi-directional many-to-one association to Workitem
	@OneToMany(mappedBy="ticket")
	private List<Workitem> workitems;

	public Ticket() {
	}

	public long getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public Date getCreationdate() {
		return this.creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Attachment> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public Attachment addAttachment(Attachment attachment) {
		getAttachments().add(attachment);
		attachment.setTicket(this);

		return attachment;
	}

	public Attachment removeAttachment(Attachment attachment) {
		getAttachments().remove(attachment);
		attachment.setTicket(null);

		return attachment;
	}

	public Hduser getHduser() {
		return this.hduser;
	}

	public void setHduser(Hduser hduser) {
		this.hduser = hduser;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Status> getStatuses() {
		return this.statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}

	public Ticket getTicket() {
		return this.ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setTicket(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setTicket(null);

		return ticket;
	}

	public TicketPriority getTicketPriority() {
		return this.ticketPriority;
	}

	public void setTicketPriority(TicketPriority ticketPriority) {
		this.ticketPriority = ticketPriority;
	}

	public TicketSeverity getTicketSeverity() {
		return this.ticketSeverity;
	}

	public void setTicketSeverity(TicketSeverity ticketSeverity) {
		this.ticketSeverity = ticketSeverity;
	}

	public Workflow getWorkflow() {
		return this.workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public List<Ticketcomment> getTicketcomments() {
		return this.ticketcomments;
	}

	public void setTicketcomments(List<Ticketcomment> ticketcomments) {
		this.ticketcomments = ticketcomments;
	}

	public Ticketcomment addTicketcomment(Ticketcomment ticketcomment) {
		getTicketcomments().add(ticketcomment);
		ticketcomment.setTicket(this);

		return ticketcomment;
	}

	public Ticketcomment removeTicketcomment(Ticketcomment ticketcomment) {
		getTicketcomments().remove(ticketcomment);
		ticketcomment.setTicket(null);

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
		workitem.setTicket(this);

		return workitem;
	}

	public Workitem removeWorkitem(Workitem workitem) {
		getWorkitems().remove(workitem);
		workitem.setTicket(null);

		return workitem;
	}

	public String getTicketnumber() {
		return ticketnumber;
	}

	public void setTicketnumber(String ticketnumber) {
		this.ticketnumber = ticketnumber;
	}

	

}