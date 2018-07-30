package com.sbm.helpdesk.HelpDeskIntegrationAPI.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
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
import com.sbm.helpdesk.service.AttachmentService;
import com.sbm.helpdesk.service.TicketPriorityService;
import com.sbm.helpdesk.service.TicketService;
import com.sbm.helpdesk.service.TicketSeverityService;
import com.sbm.helpdesk.service.WorkflowService;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.service.facade.AttachmentServiceFacade;
import com.sbm.helpdesk.service.facade.TicketPriorityServiceFacade;
import com.sbm.helpdesk.service.facade.TicketServiceFacade;
import com.sbm.helpdesk.service.facade.TicketcommentServiceFacade;

@Controller
@CrossOrigin("*")
public class HomeController {
	
	
	@Resource
	private TicketPriorityServiceFacade facadeService;
	
	@Resource
	private TicketServiceFacade ticketfacadeService;
	
	@Resource
	private AttachmentServiceFacade attachmentServiceFacade;
	
	@Resource
	private TicketcommentServiceFacade ticketcommentServiceFacade;

	@Resource
	private TicketService service;
	
	@Resource
	private AttachmentService 	attachmentService;

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
	/*@RequestMapping(value = "/ticket", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
	}*/
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
	@RequestMapping(value = "/attachment/{"+IntegrationServicesConstant.ATTACHMENT_ID+"}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> deleteAttachment(@PathVariable(IntegrationServicesConstant.ATTACHMENT_ID) Long attachmentId) {
		try {
			attachmentServiceFacade.deleteAttachment(attachmentId);
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/ticketcomment/{"+IntegrationServicesConstant.TICKETCOMMENT_ID+"}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> deleteTicketcomment(@PathVariable(IntegrationServicesConstant.TICKETCOMMENT_ID) Long id) {
		try {
			ticketcommentServiceFacade.deleteAttachment(id);
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
	@RequestMapping(value = "/attachmentByTicId/{"+IntegrationServicesConstant.TICKET_ID+"}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllAttachmentByTickId(@PathVariable(IntegrationServicesConstant.TICKET_ID) Long ticketId) {
		
		try {
			return attachmentServiceFacade.getAllByTicketId(ticketId);
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/ticketcommentByTicId/{"+IntegrationServicesConstant.TICKET_ID+"}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllTicketCommentByTickId(@PathVariable(IntegrationServicesConstant.TICKET_ID) Long ticketId) {
		
		try {
			return ticketcommentServiceFacade.getAllByTicketId(ticketId);
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/ticketbyproidanduser", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getTiketListByIdentifier(@RequestParam(IntegrationServicesConstant.PROJECT_Id) Long projectId, @RequestParam(IntegrationServicesConstant.USER_EMAIL) String userEmail) throws BusinessException {
		
		try {
			return ticketfacadeService.getByProjectIDAndUserName(projectId, userEmail);
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
			
	}
	@RequestMapping(value = "/ticketcomment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO creatTicketComment(@RequestBody TicketcommentDTO ticketcommentDTO) {
		try {
			return ticketcommentServiceFacade.addTicketcomment(ticketcommentDTO);
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
	
	@RequestMapping(value = "/download", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
    public void downloadFile(HttpServletResponse response, @RequestParam(IntegrationServicesConstant.ATTACHMENT_ID) Long attachmentId) throws IOException, BusinessException {
     
		AttachmentDTO attachmentDTO = attachmentService.getAttachmentById(attachmentId);
		
        File file = new File(attachmentDTO.getPath());
         
        if(!file.exists()){
            String errorMessage = "The file you are looking for does not exist";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }
         
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
         
        response.setContentLength((int)file.length());
 
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
	
	@RequestMapping(value = "/uploadAttachment", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public ResponseDTO uploadAttachment(@RequestParam(IntegrationServicesConstant.PATHPARAM_FILES) MultipartFile[] files, @RequestParam(IntegrationServicesConstant.TICKET_ID) String ticketId,
			@RequestParam(IntegrationServicesConstant.USER_ID) String userId, Model model) throws BusinessException, Exception {
		System.out.println("Test 1 Upload Attachment "+ userId + "  " + "  " + files.length + "  " + ticketId);
		return attachmentServiceFacade.uploadAttachment(Long.parseLong(userId), files, Long.parseLong(ticketId));
	}
	
	@RequestMapping(value = "/stepTicketForward", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO stepTicketForward(@RequestParam(IntegrationServicesConstant.TICKET_ID) Long ticketId) throws ControllerException {
		
		return ticketfacadeService.stepTicketForward(ticketId);
	}
	
	@RequestMapping(value = "/stepTicketBackward", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO stepTicketBackward(@RequestParam(IntegrationServicesConstant.TICKET_ID) Long ticketId) throws ControllerException {
		
		return ticketfacadeService.stepTicketBackward(ticketId);
	}
}
