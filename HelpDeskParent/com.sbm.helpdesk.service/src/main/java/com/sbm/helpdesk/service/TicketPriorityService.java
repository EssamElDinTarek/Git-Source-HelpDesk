package com.sbm.helpdesk.service;

import java.util.List;
import javax.transaction.Transactional;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.dto.*;

@Transactional
public interface TicketPriorityService {
	
	/*public TicketDTO addTicket(TicketDTO ticketDTO);
	public TicketDTO updateTicket(TicketDTO ticketDTO);
	public TicketDTO getByTicketNumber(String ticketnumber);*/
	public List<TicketPriorityDTO> getAllTicketPriority() throws BusinessException;
}
