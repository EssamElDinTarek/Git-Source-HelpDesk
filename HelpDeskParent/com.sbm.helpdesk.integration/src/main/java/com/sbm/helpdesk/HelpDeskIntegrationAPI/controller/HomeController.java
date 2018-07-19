package com.sbm.helpdesk.HelpDeskIntegrationAPI.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller.RestDTOProvider;
import com.sbm.helpdesk.common.constant.*;
import com.sbm.helpdesk.common.dto.ResponseDTO;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.ControllerException;
import com.sbm.helpdesk.service.TicketPriorityService;
import com.sbm.helpdesk.service.TicketService;
import com.sbm.helpdesk.service.TicketSeverityService;
import com.sbm.helpdesk.service.WorkflowService;
import com.sbm.helpdesk.service.dto.BaseDTO;
import com.sbm.helpdesk.service.dto.TicketDTO;
import com.sbm.helpdesk.service.dto.TicketPriorityDTO;
import com.sbm.helpdesk.service.dto.TicketSeverityDTO;
import com.sbm.helpdesk.service.dto.WorkflowDTO;
import com.sbm.helpdesk.service.facade.TicketPriorityServiceFacade;
import com.sbm.helpdesk.service.facade.TicketServiceFacade;

@Controller
@CrossOrigin("*")
public class HomeController {
	
	
	@Resource
	private TicketPriorityServiceFacade facadeService;
	
	@Resource
	private TicketServiceFacade ticketfacadeService;
	
	@Resource
	private TicketService service;

	@Resource
	private WorkflowService wfservice;

	@Resource
	private TicketSeverityService ticketSeverityservice;

	@Resource
	private TicketPriorityService ticketPriorityservice;

	@Resource
	private RestDTOProvider dtoProvider;

	
	@RequestMapping(value = "/ticket", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public ResponseDTO creatTicket(@RequestParam(IntegrationServicesConstant.PATHPARAM_FILES) MultipartFile[] files, @RequestParam(IntegrationServicesConstant.PATHPARAM_TICKET) String ticket,
	         Model model) throws BusinessException, Exception {
		return ticketfacadeService.creatTicket(files, ticket);
	}

	
	@RequestMapping(value = "/ticketupdate", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public ResponseDTO creatTicketupdate(@RequestParam(IntegrationServicesConstant.PATHPARAM_FILES) MultipartFile[] files, @RequestParam(IntegrationServicesConstant.PATHPARAM_TICKET) String ticket,
	         Model model) throws BusinessException, Exception {
		return ticketfacadeService.updateTicket(files, ticket);
	}
	@RequestMapping(value = "/ticket", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> updateTicket(@RequestBody TicketDTO ticketdto) {
		TicketDTO _ticket = null; 
		try {
			_ticket = service.updateTicket(ticketdto);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtoProvider.addObj(_ticket);
	}
	@RequestMapping(value = "/ticket/{"+IntegrationServicesConstant.TICKET_ID+"}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> deleteTicket(@PathVariable(IntegrationServicesConstant.TICKET_ID) Long ticketId) {
		try {
			service.deleteTicket(ticketId);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/ticket", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> getTicketByIdentifier(@RequestParam(IntegrationServicesConstant.SERVICE_RETRIVAL_IDENTIFIER) String key, @RequestParam(IntegrationServicesConstant.SERVICE_RETRIVAL_VALUE) String value) {
		TicketDTO _ticket = null;
		switch (key) {
		case IntegrationServicesConstant.TICKET_ID:
			try {
				_ticket = service.getByTicketId(Long.parseLong(value));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case IntegrationServicesConstant.TICKET_NUMBER:
			try {
				_ticket = service.getByTicketNumber(value);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}
		return dtoProvider.addObj(_ticket);
	}

	@RequestMapping(value = "/tickets", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<TicketDTO> getTiketListByIdentifier(@RequestParam(IntegrationServicesConstant.SERVICE_RETRIVAL_IDENTIFIER) String key, @RequestParam(IntegrationServicesConstant.SERVICE_RETRIVAL_VALUE) String value) {
		List<TicketDTO> _ticketList = null;
		switch (key) {
		case IntegrationServicesConstant.PROJECT_NAME:
			try {
				_ticketList = service.getTicketByProjectName(value);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		return _ticketList;
	}

	@RequestMapping(value = "/workflow", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<WorkflowDTO> getAllWorkflow() {
		List<WorkflowDTO> _workflowList = null;
		try {
			_workflowList = wfservice.getAllWorkflow();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _workflowList;
	}

	@RequestMapping(value = "/ticketseverity", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<TicketSeverityDTO> getAllTicketSeverity() {
		List<TicketSeverityDTO> _ticketSeverityList = null;
		try {
			_ticketSeverityList = ticketSeverityservice.getAllTicketSeverity();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _ticketSeverityList;
	}

	@RequestMapping(value = "/ticketpriority", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<TicketPriorityDTO> getAllTicketPriority() {
		List<TicketPriorityDTO> _ticketPriorityList = null;
		try {
			_ticketPriorityList = ticketPriorityservice.getAllTicketPriority();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _ticketPriorityList;
	}

	@RequestMapping(value = "/ticketprioritys", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllTicketPrioritys() {
		
		try {
			return facadeService.getAllTicketPriority();
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = { "/", "/index" })
	public ModelAndView index(@RequestParam(required = false, defaultValue = "World") String name) {
		ModelAndView ret = new ModelAndView("index");
		// Adds an objet to be used in home.jsp
		ret.addObject("name", name);
		return ret;
	}
}
