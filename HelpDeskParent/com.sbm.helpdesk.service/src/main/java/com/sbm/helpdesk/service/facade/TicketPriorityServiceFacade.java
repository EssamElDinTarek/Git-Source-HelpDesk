package com.sbm.helpdesk.service.facade;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.service.dto.*;
@Service
public class TicketPriorityServiceFacade {

	@Autowired
	private TicketPriorityService service;
	
	public ResponseDTO getAllTicketPriority() {
		List<TicketPriorityDTO> _ticketPriorityList = service.getAllTicketPriority();
		return new ResponseDTO(null, _ticketPriorityList);
	}

}
