package com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller;

import javax.annotation.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.sbm.helpdesk.service.dto.*;
import com.sbm.helpdesk.service.facade.*;
import com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller.RestProvider;
import com.sbm.helpdesk.common.constant.IntegrationServicesConstant;

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin("*")
public class TicketRestController {

	/*@Resource
	private TicketServiceFacade facadeService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO creatTicket(@RequestBody TicketDTO ticketdto) {
		
		return facadeService.creatTicket(ticketdto);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO updateTicket(@RequestBody TicketDTO ticketdto) {
		
		return facadeService.updateTicket(ticketdto);
	}
	
	@RequestMapping(value = "/{"+IntegrationServicesConstant.TICKET_ID+"}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO deleteTicket(@PathVariable(IntegrationServicesConstant.TICKET_ID) Long ticketId) {
		
		return facadeService.deleteTicket(ticketId);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getTicketByIdentifier(@RequestParam(IntegrationServicesConstant.SERVICE_RETRIVAL_IDENTIFIER) String key, @RequestParam(IntegrationServicesConstant.SERVICE_RETRIVAL_VALUE) String value) {

		return facadeService.getTicketByIdentifier(key, value);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getTiketListByIdentifier(@RequestParam(IntegrationServicesConstant.SERVICE_RETRIVAL_IDENTIFIER) String key, @RequestParam(IntegrationServicesConstant.SERVICE_RETRIVAL_VALUE) String value) {
		
		return facadeService.getTiketListByIdentifier(key, value);
	}
*/
}
