package com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.service.AttachmentService;
import com.sbm.helpdesk.service.facade.*;
import com.sbm.helpdesk.common.constant.IntegrationServicesConstant;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.ControllerException;

@RestController
@RequestMapping("/api/attachment")
@CrossOrigin("*")
public class AttachmentRestController {

	@Resource
	private AttachmentServiceFacade facadeService;
	
	@Resource
	private AttachmentService 	attachmentService;
	
	@RequestMapping(value = "/{"+IntegrationServicesConstant.ATTACHMENT_ID+"}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO deleteAttachment(@PathVariable(IntegrationServicesConstant.ATTACHMENT_ID) Long attachmentId) throws ControllerException {
			return facadeService.deleteAttachment(attachmentId);
	}

	@RequestMapping( method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public ResponseDTO uploadAttachment(@RequestParam(IntegrationServicesConstant.PATHPARAM_FILES) MultipartFile[] files, @RequestParam(IntegrationServicesConstant.TICKET_ID) String ticketId,
			@RequestParam(IntegrationServicesConstant.USER_ID) String userId, Model model) throws ControllerException {
		return facadeService.uploadAttachment(userId, files, ticketId);
	}
	
	@RequestMapping(value = "/ticid/{"+IntegrationServicesConstant.TICKET_ID+"}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllAttachmentByTickId(@PathVariable(IntegrationServicesConstant.TICKET_ID) Long ticketId) throws ControllerException {
			return facadeService.getAllByTicketId(ticketId);
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
	
	

}
