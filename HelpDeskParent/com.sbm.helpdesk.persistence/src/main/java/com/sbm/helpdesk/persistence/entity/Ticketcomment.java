package com.sbm.helpdesk.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the TICKETCOMMENT database table.
 * 
 */
@Entity
@Table(name="TICKETCOMMENT")
@NamedQueries({
	@NamedQuery(name="Ticketcomment.findAll", query="SELECT t FROM Ticketcomment t"),
	@NamedQuery(name="Ticketcomment.findAllByTicketId", query="SELECT com FROM Ticketcomment com join com.ticket t where t.ticketId=:arg1 and com.deleted='0'")
})

public class Ticketcomment extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TICKETCOMMENT_TICKETCOMMENTID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TICKETCOMMENT_TICKETCOMMENTID_GENERATOR")
	@Column(name="TICKETCOMMENT_ID", unique=true, nullable=false, precision=22)
	private long ticketcommentId;

	@Column(name="COMMENT_VALUE", length=200)
	private String commentValue;

	//bi-directional many-to-one association to Hduser
	@ManyToOne
	@JoinColumn(name="CREATOR_ID")
	private Hduser hduser;

	//bi-directional many-to-one association to Ticket
	@ManyToOne
	@JoinColumn(name="TICKET_ID")
	private Ticket ticket;
	
	@Column(name = "WRITTEN_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date writtenOn;

	public Date getWrittenOn() {
		return writtenOn;
	}

	public void setWrittenOn(Date writtenOn) {
		this.writtenOn = writtenOn;
	}

	@Column(name="IS_DELETED")
	private long deleted;
	
	public Ticketcomment() {
	}

	public long getTicketcommentId() {
		return this.ticketcommentId;
	}

	public void setTicketcommentId(long ticketcommentId) {
		this.ticketcommentId = ticketcommentId;
	}

	public String getCommentValue() {
		return this.commentValue;
	}

	public void setCommentValue(String commentValue) {
		this.commentValue = commentValue;
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
	

	public long getDeleted() {
		return deleted;
	}

	public void setDeleted(long deleted) {
		this.deleted = deleted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ticketcommentId ^ (ticketcommentId >>> 32));
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
		Ticketcomment other = (Ticketcomment) obj;
		if (ticketcommentId != other.ticketcommentId)
			return false;
		return true;
	}

}