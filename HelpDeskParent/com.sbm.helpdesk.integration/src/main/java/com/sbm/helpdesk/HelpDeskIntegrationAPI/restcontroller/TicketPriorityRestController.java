package com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller;

import javax.annotation.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.service.facade.*;
import com.sbm.helpdesk.common.exceptions.types.ControllerException;

@RestController
@RequestMapping("/api/ticketpriority")
@CrossOrigin("*")
public class TicketPriorityRestController {

	@Resource
	private TicketPriorityServiceFacade facadeService;
	

	@RequestMapping( method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllTicketPrioritys() throws ControllerException {
			return facadeService.getAllTicketPriority();
	}
	

}
