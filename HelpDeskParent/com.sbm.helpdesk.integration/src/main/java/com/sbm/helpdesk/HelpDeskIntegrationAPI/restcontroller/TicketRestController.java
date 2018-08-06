package com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller;

import javax.annotation.Resource;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.service.facade.*;
import com.sbm.helpdesk.common.constant.IntegrationServicesConstant;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.ControllerException;

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin("*")
public class TicketRestController {

	@Resource
	private TicketServiceFacade facadeService;
	

	@RequestMapping(value = "/{"+IntegrationServicesConstant.TICKET_ID+"}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO deleteTicket(@PathVariable(IntegrationServicesConstant.TICKET_ID) Long ticketId) throws ControllerException {
		return facadeService.deleteTicket(ticketId);
	}

	
	@RequestMapping( method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public ResponseDTO creatTicket(@RequestParam(IntegrationServicesConstant.PATHPARAM_FILES) MultipartFile[] files, @RequestParam(IntegrationServicesConstant.PATHPARAM_TICKET) String ticket,
	         Model model) throws BusinessException, Exception {
		
		return facadeService.creatTicket(files, ticket);
	}

	
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public ResponseDTO creatTicketupdate(@RequestParam(IntegrationServicesConstant.PATHPARAM_FILES) MultipartFile[] files, @RequestParam(IntegrationServicesConstant.PATHPARAM_TICKET) String ticket,
	         Model model) throws BusinessException, Exception {
		return facadeService.updateTicket(files, ticket);
	}
	@RequestMapping( method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getTicketByIdentifier(@RequestParam(IntegrationServicesConstant.SERVICE_RETRIVAL_IDENTIFIER) String key, @RequestParam(IntegrationServicesConstant.SERVICE_RETRIVAL_VALUE) String value) throws ControllerException {

		return facadeService.getTicketByIdentifier(key, value);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getTiketListByIdentifier(@RequestParam(IntegrationServicesConstant.SERVICE_RETRIVAL_IDENTIFIER) String key, @RequestParam(IntegrationServicesConstant.SERVICE_RETRIVAL_VALUE) String value) throws ControllerException {
		
		return facadeService.getTiketListByIdentifier(key, value);
	}
	
	@RequestMapping(value = "/history", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getHistoryByTicketId(@RequestParam(IntegrationServicesConstant.SERVICE_RETRIVAL_VALUE) Long ticketId) throws ControllerException {
		return facadeService.getHistoryByTicketId(ticketId);
	}
	
	@RequestMapping(value = "/stepTicketForward", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO stepTicketForward(@RequestParam(IntegrationServicesConstant.TICKET_ID) Long ticketId) throws ControllerException {
		return facadeService.stepTicketForward(ticketId);
	}
	
	@RequestMapping(value = "/stepTicketBackward", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO stepTicketBackward(@RequestParam(IntegrationServicesConstant.TICKET_ID) Long ticketId) throws ControllerException {
		return facadeService.stepTicketBackward(ticketId);
	}
	@RequestMapping(value = "/ticketbyproidanduser", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getTiketListByIdentifier(@RequestParam(IntegrationServicesConstant.PROJECT_ID) Long projectId, @RequestParam(IntegrationServicesConstant.USER_EMAIL) String userEmail) throws ControllerException {
		return facadeService.getByProjectIDAndUserName(projectId, userEmail);
	}
	@RequestMapping(value = "/ticketbywfidanduser", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getByWorkflowIDAndUserName(@RequestParam(IntegrationServicesConstant.WORKFLOW_ID) Long workflowId, @RequestParam(IntegrationServicesConstant.USER_EMAIL) String userEmail) throws ControllerException {
		return facadeService.getByWorkflowIDAndUserName(workflowId, userEmail);
	}
	@RequestMapping(value = "/severityprioritystatusbyuser", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getSeverityPriorityStatusByUserName(@RequestParam(IntegrationServicesConstant.USER_EMAIL) String userEmail) throws ControllerException {
		return facadeService.getSeverityPriorityStatusByUserName(userEmail);
	}

}
