package com.sbm.helpdesk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the WORKITEM database table.
 * 
 */
@Entity
@Table(name="WORKITEM")
@NamedQuery(name="Workitem.findAll", query="SELECT w FROM Workitem w")
public class Workitem extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WORKITEM_ITEMID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WORKITEM_ITEMID_GENERATOR")
	@Column(name="ITEM_ID", unique=true, nullable=false, precision=22)
	private long itemId;

	@Temporal(TemporalType.DATE)
	private Date datefrom;

	@Temporal(TemporalType.DATE)
	private Date dateto;

	@Column(length=2000)
	private String description;

	@Column(precision=22)
	private BigDecimal ticketstatus;

	//bi-directional many-to-one association to Ticket
	@ManyToOne
	@JoinColumn(name="TICKET_ID")
	private Ticket ticket;

	public Workitem() {
	}

	public long getItemId() {
		return this.itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public Date getDatefrom() {
		return this.datefrom;
	}

	public void setDatefrom(Date datefrom) {
		this.datefrom = datefrom;
	}

	public Date getDateto() {
		return this.dateto;
	}

	public void setDateto(Date dateto) {
		this.dateto = dateto;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getTicketstatus() {
		return this.ticketstatus;
	}

	public void setTicketstatus(BigDecimal ticketstatus) {
		this.ticketstatus = ticketstatus;
	}

	public Ticket getTicket() {
		return this.ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (itemId ^ (itemId >>> 32));
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
		Workitem other = (Workitem) obj;
		if (itemId != other.itemId)
			return false;
		return true;
	}

}