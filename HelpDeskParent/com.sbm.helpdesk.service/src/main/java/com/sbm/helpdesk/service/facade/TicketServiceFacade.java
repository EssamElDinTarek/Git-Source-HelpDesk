package com.sbm.helpdesk.service.facade;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbm.helpdesk.common.constant.IntegrationServicesConstant;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.service.dto.*;

@Service
public class TicketServiceFacade {

	@Autowired
	private TicketService service;
	
	@Autowired
	private AttachmentService attachmentService;
	
	
	public ResponseDTO creatTicket( MultipartFile[] files, String ticket) throws BusinessException, Exception {
		ObjectMapper mapper = new ObjectMapper();
		TicketDTO ticketdto = mapper.readValue(ticket, new TypeReference<TicketDTO>() {});
		TicketDTO newTicket = service.addTicket(ticketdto);
		String folderPath = IntegrationServicesConstant.ATTACHMENT_PATH+newTicket.getTicketnumber()+"_attachment/";
		new File(folderPath).mkdirs();
		for(MultipartFile file :files) {
			 if (!file.getOriginalFilename().isEmpty()) {
				 String filePath = folderPath +  file.getOriginalFilename();
		         BufferedOutputStream outputStream = new BufferedOutputStream(
		               new FileOutputStream(
		                     new File(folderPath, file.getOriginalFilename())));
		         outputStream.write(file.getBytes());
		         outputStream.flush();
		         outputStream.close();
		         AttachmentDTO attachmentDTO = new AttachmentDTO();
		         attachmentDTO.setDescription(file.getOriginalFilename());
		         attachmentDTO.setPath(filePath);
		         attachmentDTO.setTicket(newTicket);
		         attachmentService.addAttachment(attachmentDTO);
		      }
		}
		
		if(newTicket == null)
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Ticket has been added successfully", 
				"Ticket has been added successfully", null);
		return new ResponseDTO(status, newTicket) ;
	}
	public ResponseDTO updateTicket(TicketDTO ticketdto) throws BusinessException {
		TicketDTO _ticket = service.updateTicket(ticketdto);
		if(_ticket == null)
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Ticket has been updated successfully", 
				"Ticket has been updated successfully", null);
		return new ResponseDTO(status, _ticket) ;
	}
	public ResponseDTO updateTicket( MultipartFile[] files, String ticket) throws BusinessException, Exception {
		ObjectMapper mapper = new ObjectMapper();
		TicketDTO ticketdto = mapper.readValue(ticket, new TypeReference<TicketDTO>() {});
		TicketDTO _ticket = service.updateTicket(ticketdto);
		String folderPath = IntegrationServicesConstant.ATTACHMENT_PATH+_ticket.getTicketnumber()+"_attachment/";
		new File(folderPath).mkdirs();
		for(MultipartFile file :files) {
			 if (!file.getOriginalFilename().isEmpty()) {
				 String filePath = folderPath +  file.getOriginalFilename();
		         BufferedOutputStream outputStream = new BufferedOutputStream(
		               new FileOutputStream(
		                     new File(folderPath, file.getOriginalFilename())));
		         outputStream.write(file.getBytes());
		         outputStream.flush();
		         outputStream.close();
		         AttachmentDTO attachmentDTO = new AttachmentDTO();
		         attachmentDTO.setDescription(file.getOriginalFilename());
		         attachmentDTO.setPath(filePath);
		         attachmentDTO.setTicket(_ticket);
		         attachmentService.addAttachment(attachmentDTO);
		      }
		}
		if(_ticket == null)
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Ticket has been updated successfully", 
				"Ticket has been updated successfully", null);
		return new ResponseDTO(status, _ticket) ;
	}
	public ResponseDTO deleteTicket(Long ticketId) throws ControllerException {
		
		ResponseDTO result = null;
		try {
			service.deleteTicket(ticketId);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
					"Attachment has been deleted successfully", 
					"Attachment has been deleted successfully", null);
			result = new ResponseDTO(status, "Sucsses");
			 }catch(BusinessException e) {
				 e.printStackTrace();
				 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
				}
			 catch(Exception e1) {
				 e1.printStackTrace();
				 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
			 }
			 return result;
	}
	
	public ResponseDTO getTicketByIdentifier(String key, String value) throws BusinessException {
		TicketDTO _ticket = null;
		switch (key) {
		case IntegrationServicesConstant.TICKET_ID:
			_ticket = service.getByTicketId(Long.parseLong(value));
			break;
		case IntegrationServicesConstant.TICKET_NUMBER:
			_ticket = service.getByTicketNumber(value);
			break;

		}
		/*if(_ticket == null)
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);*/
		
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Ticket has been retrived successfully", 
				"Ticket has been retrived successfully", null);
		
		return new ResponseDTO(null, _ticket);
	}
	
	public ResponseDTO getTiketListByIdentifier(String key, String value) throws BusinessException {
		List<TicketDTO> _ticketList = null;
		switch (key) {
		case IntegrationServicesConstant.PROJECT_NAME:
			_ticketList = service.getTicketByProjectName(value);
			break;
		}
		/*if(_ticketList == null)
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);*/
		
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Tickets has been retrived successfully", 
				"Tickets has been retrived successfully", null);
		
		return new ResponseDTO(null, _ticketList);
	}
	public ResponseDTO getByProjectIDAndUserName(Long projectId, String userEmail) throws ControllerException {
		ResponseDTO result = null;
		try {
			List<TicketDTO> _ticketList = service.getByProjectIDAndUserName(projectId, userEmail);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
					"Tickets has been retrived successfully", 
					"Tickets has been retrived successfully", null);
			result =  new ResponseDTO(null, _ticketList);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
		
	}
	
	public ResponseDTO getHistoryByTicketId(Long ticketId) throws ControllerException {
		ResponseDTO result = null;
		try {
			List<HistoryDetailsDTO> historyDetails = service.getHistoryByTicketId(ticketId);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
					"Tickets has been retrived successfully", 
					"Tickets has been retrived successfully", null);
			result =  new ResponseDTO(status, historyDetails);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
		
	}
	
	

}
