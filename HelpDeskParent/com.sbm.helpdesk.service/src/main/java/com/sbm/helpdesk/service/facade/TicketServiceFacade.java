package com.sbm.helpdesk.service.facade;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.*;
import com.sbm.helpdesk.common.constant.IntegrationServicesConstant;
import com.sbm.helpdesk.service.*;

@Service
public class TicketServiceFacade {

	@Autowired
	private TicketService service;
	
	@Autowired
	private AttachmentService attachmentService;
	
	
	public ResponseDTO creatTicket( MultipartFile[] files, String ticket) throws ControllerException {
		ResponseDTO result = null;
		try {
			TicketDTO ticketDTO =service.addTicket(files, ticket);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
					"Attachment has been created successfully", 
					"Attachment has been created successfully", null);
			result = new ResponseDTO(status, ticketDTO);
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
	/*public ResponseDTO updateTicket(TicketDTO ticketdto) throws BusinessException {
		TicketDTO _ticket = service.updateTicket(ticketdto);
		if(_ticket == null)
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Ticket has been updated successfully", 
				"Ticket has been updated successfully", null);
		return new ResponseDTO(status, _ticket) ;
	}*/
	public ResponseDTO updateTicket( MultipartFile[] files, String ticket) throws ControllerException {
		ResponseDTO result = null;
		try {
			service.updateTicket(files, ticket);
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
	
	public ResponseDTO stepTicketForward(Long ticketId) throws ControllerException {
		ResponseDTO result = null;
		try {
			TicketDTO ticket = service.stepTicketForward(ticketId);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
					"Tickets has been Steped Forward successfully", 
					"Tickets has been Steped Forward successfully", null);
			result =  new ResponseDTO(status, ticket);
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
	
	public ResponseDTO stepTicketBackward(Long ticketId) throws ControllerException {
		ResponseDTO result = null;
		try {
			TicketDTO ticket = service.stepTicketBackward(ticketId);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
					"Tickets has been Steped Backward successfully", 
					"Tickets has been Steped Backward successfully", null);
			result =  new ResponseDTO(status, ticket);
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
