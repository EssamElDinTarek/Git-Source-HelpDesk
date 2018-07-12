package com.sbm.helpdesk.service;

import java.util.List;

import com.sbm.helpdesk.dto.*;
import com.sbm.helpdesk.entity.Ticket;

public interface TicketSeverityService {
	
	/*public TicketDTO addTicket(TicketDTO ticketDTO);
	public TicketDTO updateTicket(TicketDTO ticketDTO);
	public TicketDTO getByTicketNumber(String ticketnumber);*/
	public List<TicketSeverityDTO> getAllTicketSeverity();
}
