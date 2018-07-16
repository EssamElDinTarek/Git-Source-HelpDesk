package com.sbm.helpdesk.service;

import java.util.List;
import javax.transaction.Transactional;

import com.sbm.helpdesk.service.dto.*;

@Transactional
public interface TicketSeverityService {
	
	/*public TicketDTO addTicket(TicketDTO ticketDTO);
	public TicketDTO updateTicket(TicketDTO ticketDTO);
	public TicketDTO getByTicketNumber(String ticketnumber);*/
	public List<TicketSeverityDTO> getAllTicketSeverity();
}
