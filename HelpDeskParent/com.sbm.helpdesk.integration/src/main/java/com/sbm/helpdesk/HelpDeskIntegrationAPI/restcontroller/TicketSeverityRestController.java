package com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller;

import javax.annotation.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.service.facade.*;
import com.sbm.helpdesk.common.exceptions.types.ControllerException;

@RestController
@RequestMapping("/api/ticketseverity")
@CrossOrigin("*")
public class TicketSeverityRestController {

	@Resource
	private TicketSeverityServiceFacade facadeService;
	

	@RequestMapping( method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllTicketSeverity() throws ControllerException {
			return facadeService.getAllTicketSeverity();
	}
	

}
