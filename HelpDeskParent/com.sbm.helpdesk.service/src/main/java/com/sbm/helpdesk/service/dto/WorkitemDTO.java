package com.sbm.helpdesk.service.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.sbm.helpdesk.service.entity.Attachment;
import com.sbm.helpdesk.service.entity.Ticket;

public class WorkitemDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long itemId;
	private Date datefrom;
	private Date dateto;
	private String description;
	private BigDecimal ticketstatus;
	//private Set<Attachment> attachments;
	private Ticket ticket;
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public Date getDatefrom() {
		return datefrom;
	}
	public void setDatefrom(Date datefrom) {
		this.datefrom = datefrom;
	}
	public Date getDateto() {
		return dateto;
	}
	public void setDateto(Date dateto) {
		this.dateto = dateto;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getTicketstatus() {
		return ticketstatus;
	}
	public void setTicketstatus(BigDecimal ticketstatus) {
		this.ticketstatus = ticketstatus;
	}
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
}
