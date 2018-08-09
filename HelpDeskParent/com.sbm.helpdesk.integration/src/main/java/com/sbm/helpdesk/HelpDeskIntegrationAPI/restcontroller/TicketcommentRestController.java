package com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller;

import javax.annotation.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.service.facade.*;
import com.sbm.helpdesk.common.constant.IntegrationServicesConstant;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.ControllerException;

@RestController
@RequestMapping("/api/ticketcomment")
@CrossOrigin("*")
public class TicketcommentRestController {

	@Resource
	private TicketcommentServiceFacade facadeService;
	

	@RequestMapping(value = "/{"+IntegrationServicesConstant.TICKETCOMMENT_ID+"}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO deleteTicketcomment(@PathVariable(IntegrationServicesConstant.TICKETCOMMENT_ID) Long id) throws ControllerException{
			return facadeService.deleteTicketcomment(id);
	}
	@RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO addTicketComment(@RequestBody TicketcommentDTO ticketcommentDTO) throws ControllerException{
			return facadeService.addTicketcomment(ticketcommentDTO);
	}

	@RequestMapping(value = "/tickid/{"+IntegrationServicesConstant.TICKET_ID+"}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllTicketCommentByTickId(@PathVariable(IntegrationServicesConstant.TICKET_ID) Long ticketId) throws ControllerException{
			return facadeService.getAllByTicketId(ticketId);
	}
	

}
