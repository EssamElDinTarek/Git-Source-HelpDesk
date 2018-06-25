package com.sbm.helpdesk.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ATTACHMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Attachment.findAll", query="SELECT a FROM Attachment a")
public class Attachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ATTACHMENT_ID")
	private long attachmentId;

	private String description;

	@Column(name="\"PATH\"")
	private String path;

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

}