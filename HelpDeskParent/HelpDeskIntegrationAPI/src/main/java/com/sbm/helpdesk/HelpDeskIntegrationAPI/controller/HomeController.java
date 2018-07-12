package com.sbm.helpdesk.HelpDeskIntegrationAPI.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller.RestDTOProvider;
import com.sbm.helpdesk.dto.BaseDTO;
import com.sbm.helpdesk.dto.TicketDTO;
import com.sbm.helpdesk.dto.TicketPriorityDTO;
import com.sbm.helpdesk.dto.TicketSeverityDTO;
import com.sbm.helpdesk.dto.WorkflowDTO;
import com.sbm.helpdesk.service.TicketPriorityService;
import com.sbm.helpdesk.service.TicketService;
import com.sbm.helpdesk.service.TicketSeverityService;
import com.sbm.helpdesk.service.WorkflowService;

@Controller
@CrossOrigin("*")
public class HomeController {/*

	@RequestMapping(value= {"/hello"})
	public ModelAndView hello(@RequestParam(required=false, defaultValue="World") String name) {
		ModelAndView ret = new ModelAndView("home");
		// Adds an objet to be used in home.jsp
		ret.addObject("name", name);
		return ret;
	}*/
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
	
	@RequestMapping(value = "/ticket", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> creatTicket(@RequestBody TicketDTO ticketdto){
		TicketDTO newTicket = service.addTicket(ticketdto);
				return dtoProvider.addObj(newTicket);
	}
	
	@RequestMapping(value = "/ticket", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> updateTicket(@RequestBody TicketDTO ticketdto){
		TicketDTO _ticket = service.updateTicket(ticketdto);
				return dtoProvider.addObj(_ticket);
	}
	@RequestMapping(value = "/ticket/{ticketNumber}", method = RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> getTicketByNumber(@PathVariable("ticketNumber")String ticketNumber ){
		TicketDTO _ticket = service.getByTicketNumber(ticketNumber);
				return dtoProvider.addObj(_ticket);
	}
	@RequestMapping(value = "/ticket", method = RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<TicketDTO> getByProjectName(@RequestParam("projectname")String projectname ){
		List<TicketDTO> _ticketList = service.getTicketByProjectName(projectname);
				return _ticketList;
	}
	@RequestMapping(value = "/workflow", method = RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<WorkflowDTO> getAllWorkflow( ){
		List<WorkflowDTO> _workflowList = wfservice.getAllWorkflow();
				return _workflowList;
	}
	
	@RequestMapping(value = "/ticketseverity", method = RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<TicketSeverityDTO> getAllTicketSeverity( ){
		List<TicketSeverityDTO> _ticketSeverityList = ticketSeverityservice.getAllTicketSeverity();
				return _ticketSeverityList;
	}
	
	@RequestMapping(value = "/ticketpriority", method = RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<TicketPriorityDTO> getAllTicketPriority( ){
		List<TicketPriorityDTO> _ticketPriorityList = ticketPriorityservice.getAllTicketPriority();
				return _ticketPriorityList;
	}
	
	@RequestMapping(value= {"/","/index"})
	public ModelAndView index(@RequestParam(required=false, defaultValue="World") String name) {
		ModelAndView ret = new ModelAndView("index");
		// Adds an objet to be used in home.jsp
		ret.addObject("name", name);
		return ret;
	}
}
