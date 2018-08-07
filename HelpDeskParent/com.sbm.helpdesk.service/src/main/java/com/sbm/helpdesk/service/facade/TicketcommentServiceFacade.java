package com.sbm.helpdesk.service.facade;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.ControllerException;
import com.sbm.helpdesk.service.*;

@Service
public class TicketcommentServiceFacade {

	@Autowired
	private TicketcommentService service;
	
	
	public ResponseDTO addTicketcomment(TicketcommentDTO ticketcommentDTO) throws ControllerException {
		ResponseDTO result = null;
		 try {
		TicketcommentDTO _ticketcomment = service.addTicketcomment(ticketcommentDTO);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Attachment has been deleted successfully", 
				"Attachment has been deleted successfully", null);
		result = new ResponseDTO(status, _ticketcomment);
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
	public ResponseDTO getAllByTicketId(long tickId) throws ControllerException {
		ResponseDTO result = null;
		 try {
		List<TicketcommentDTO> _ticketcommentList = service.getTicketcommentByTicId(tickId);
		result = new ResponseDTO(null, _ticketcommentList);
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
	
	public ResponseDTO deleteAttachment(Long id) throws BusinessException {
		service.deleteTicketcomment(id);
		return new ResponseDTO(null, "Sucsses") ;
	}

}
