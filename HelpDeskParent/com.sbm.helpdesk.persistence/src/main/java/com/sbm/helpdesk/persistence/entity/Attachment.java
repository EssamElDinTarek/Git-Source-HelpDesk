package com.sbm.helpdesk.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the ATTACHMENT database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Attachment.findAll", query="SELECT a FROM Attachment a"),
	@NamedQuery(name="Attachment.findAllByTicketId", query="SELECT a FROM Attachment a join a.ticket t where t.ticketId=:arg1 and a.deleted='0'")
})

public class Attachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATTACHMENT_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATTACHMENT_ID_GENERATOR")
	@Column(name="ATTACHMENT_ID", unique=true, nullable=false, precision=22)
	private long attachmentId;

	private String description;

	@Column(name="\"PATH\"")
	private String path;

	@Column(name="IS_DELETED")
	private long deleted;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="MIMETYPE")
	private String mimeType;
	
	@Column(name="ATTACHMENTSIZE")
	private long size;
	
	@Column(name = "CREATEDATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
	
	//bi-directional many-to-one association to Hduser
	@ManyToOne
	@JoinColumn(name="CREATOR_ID")
	private Hduser hduser;

	//bi-directional many-to-one association to Ticket
	@ManyToOne
	@JoinColumn(name="TICKET_ID")
	private Ticket ticket;

	//bi-directional many-to-one association to Workitem
	@ManyToOne
	@JoinColumn(name="WORKITEMID")
	private Workitem workitem;

	public Attachment() {
	}

	public long getAttachmentId() {
		return this.attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Hduser getHduser() {
		return this.hduser;
	}

	public void setHduser(Hduser hduser) {
		this.hduser = hduser;
	}

	public Ticket getTicket() {
		return this.ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Workitem getWorkitem() {
		return this.workitem;
	}

	public void setWorkitem(Workitem workitem) {
		this.workitem = workitem;
	}

	public long getDeleted() {
		return deleted;
	}

	public void setDeleted(long deleted) {
		this.deleted = deleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	

}