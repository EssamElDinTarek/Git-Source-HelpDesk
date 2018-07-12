package com.sbm.helpdesk.service;

import java.util.List;

import com.sbm.helpdesk.dto.*;
import com.sbm.helpdesk.entity.Ticket;
import com.sbm.helpdesk.entity.Workflow;

public interface WorkflowService {
	
	/*public TicketDTO addTicket(TicketDTO ticketDTO);
	public TicketDTO updateTicket(TicketDTO ticketDTO);
	public TicketDTO getByTicketNumber(String ticketnumber);*/
	public List<WorkflowDTO> getAllWorkflow();
}
