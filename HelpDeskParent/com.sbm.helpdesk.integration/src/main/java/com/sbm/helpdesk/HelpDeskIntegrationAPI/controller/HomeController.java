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
import com.sbm.helpdesk.common.mailer.Mailer;
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
	
	

	
	

	

	

	

	

	
	
	
	
	
	@RequestMapping(value = { "/", "/index" })
	public ModelAndView index(@RequestParam(required = false, defaultValue = "World") String name) {
		ModelAndView ret = new ModelAndView("index");
		// Adds an objet to be used in home.jsp
		ret.addObject("name", name);
		return ret;
	}
	
	
	
}
