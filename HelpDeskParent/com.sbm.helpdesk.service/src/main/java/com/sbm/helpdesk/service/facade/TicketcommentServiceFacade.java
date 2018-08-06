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
				"Add Ticketcomment successfully", 
				"Add Ticketcomment successfully", null);
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
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Get All Ticketcomment by Ticket Id successfully", 
				"Get All Ticketcomment by Ticket Id successfully", null);
		result = new ResponseDTO(status, _ticketcommentList);
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
	
	public ResponseDTO deleteTicketcomment(Long id) throws ControllerException {
		
		ResponseDTO result = null;
		try {
			service.deleteTicketcomment(id);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
					"TicketComment has been deleted successfully", 
					"TicketComment has been deleted successfully", null);
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

}
