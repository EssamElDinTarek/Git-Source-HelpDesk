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
@NamedQuery(name="Ticket.findAll", query="SELECT t FROM Ticket t")
public class Ticket extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TICKET_TICKETID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TICKET_TICKETID_GENERATOR")
	@Column(name="TICKET_ID", unique=true, nullable=false, precision=22)
	private long ticketId;

	@Temporal(TemporalType.DATE)
	private Date creationdate;

	@Column(length=255)
	private String description;

	@Column(length=255)
	private String status;

	@Column(length=255)
	private String title;

	//bi-directional many-to-one association to Hduser
	@ManyToOne
	@JoinColumn(name="CREATOR_ID")
	private Hduser hduser;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="PROJECT_ID")
	private Project project;

	//bi-directional many-to-many association to Status
	 @ManyToMany(mappedBy = "tickets")
	private List<Status> statuses;

	//bi-directional many-to-one association to TicketPriority
	@ManyToOne
	@JoinColumn(name="PRIORITY_ID")
	private TicketPriority ticketPriority;

	//bi-directional many-to-one association to TicketSeverity
	@ManyToOne
	@JoinColumn(name="SEVERITY_ID")
	private TicketSeverity ticketSeverity;

	//bi-directional many-to-one association to Workflow
	@ManyToOne
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ticketId ^ (ticketId >>> 32));
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
		Ticket other = (Ticket) obj;
		if (ticketId != other.ticketId)
			return false;
		return true;
	}

}