package com.sbm.helpdesk.service.facade;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.ControllerException;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.service.dto.*;
@Service
public class AttachmentServiceFacade {

	@Autowired
	private AttachmentService service;
	
	public ResponseDTO getAllByTicketId(long tickId) throws ControllerException {
		ResponseDTO result = null;
		 try {
		List<AttachmentDTO> _AttachmentList = service.getAttachmentByTicId(tickId);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"get all attachment by ticket_id successfully", 
				"get all attachment by ticket_id successfully", null);
		result = new ResponseDTO(null, _AttachmentList);
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
	
	public ResponseDTO deleteAttachment(Long attachmentId) throws ControllerException {
		ResponseDTO result = null;
		try {
			service.deleteAttachment(attachmentId);
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
	
	public ResponseDTO uploadAttachment(long userId, MultipartFile[] files, long ticketId) throws ControllerException {
		ResponseDTO result = null;
		try {
			System.out.println("Test 2 Upload Attachment "+ userId + "  " + "  " + files.length + "  " + ticketId);
			service.uploadAttachment(userId, files, ticketId);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
					"Tickets has been retrived successfully", 
					"Tickets has been retrived successfully", null);
			result = new ResponseDTO(status, "Success");
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
