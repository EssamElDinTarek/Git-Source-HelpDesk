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


	public ResponseDTO creatTicket(MultipartFile[] files, String ticket) throws ControllerException {
		ResponseDTO result = null;
		try {
			TicketDTO ticketDTO = service.addTicket(files, ticket);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001",
					"Ticket has been created successfully", "Ticket has been created successfully", null);
			result = new ResponseDTO(status, ticketDTO);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return result;
	}

	public ResponseDTO updateTicket(MultipartFile[] files, String ticket) throws ControllerException {
		ResponseDTO result = null;
		try {
			service.updateTicket(files, ticket);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001",
					"Ticket has been updated successfully", "Ticket has been updated successfully", null);
			result = new ResponseDTO(status, "Sucsses");
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return result;
	}

	public ResponseDTO deleteTicket(Long ticketId) throws ControllerException {

		ResponseDTO result = null;
		try {
			service.deleteTicket(ticketId);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001",
					"Ticket has been deleted successfully", "Ticket has been deleted successfully", null);
			result = new ResponseDTO(status, "Sucsses");
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return result;
	}

	public ResponseDTO getTicketByIdentifier(String key, String value) throws ControllerException {

		ResponseDTO result = null;
		try {
			TicketDTO _ticket = null;

			switch (key) {
			case IntegrationServicesConstant.TICKET_ID:
				_ticket = service.getByTicketId(Long.parseLong(value));
				break;
			case IntegrationServicesConstant.TICKET_NUMBER:
				_ticket = service.getByTicketNumber(value);
				break;

			}

			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001",
					"Ticket has been retrived successfully", "Ticket has been retrived successfully", null);
			result = new ResponseDTO(status, _ticket);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return result;

	}

	public ResponseDTO getTiketListByIdentifier(String key, String value) throws ControllerException {
		ResponseDTO result = null;
		try {
			List<TicketDTO> _ticketList = null;
			switch (key) {
			case IntegrationServicesConstant.PROJECT_NAME:
				_ticketList = service.getTicketByProjectName(value);
				break;
			}

			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001",
					"Tickets has been retrived successfully", "Tickets has been retrived successfully", null);
			result = new ResponseDTO(status, _ticketList);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return result;
	}

	public ResponseDTO getByProjectIDAndUserName(Long projectId, String userEmail) throws ControllerException {
		ResponseDTO result = null;
		try {
			List<TicketDTO> _ticketList = service.getByProjectIDAndUserName(projectId, userEmail);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001",
					"Tickets has been retrived successfully", "Tickets has been retrived successfully", null);
			result = new ResponseDTO(status, _ticketList);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return result;

	}
	public ResponseDTO getByWorkflowIDAndUserName(Long workflowtId, String userEmail) throws ControllerException {
		ResponseDTO result = null;
		try {
			List<TicketDTO> _ticketList = service.getByWorkflowIDAndUserName(workflowtId, userEmail);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001",
					"Tickets has been retrived successfully", "Tickets has been retrived successfully", null);
			result = new ResponseDTO(status, _ticketList);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return result;

	}

	public ResponseDTO getHistoryByTicketId(Long ticketId) throws ControllerException {
		ResponseDTO result = null;
		try {
			List<HistoryDetailsDTO> historyDetails = service.getHistoryByTicketId(ticketId);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001",
					"History has been retrived successfully", "History has been retrived successfully", null);
			result = new ResponseDTO(status, historyDetails);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return result;

	}

	public ResponseDTO stepTicketForward(Long ticketId) throws ControllerException {
		ResponseDTO result = null;
		try {
			TicketDTO ticket = service.stepTicketForward(ticketId);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001",
					"Ticket has been Steped Forward successfully", "Ticket has been Steped Forward successfully",
					null);
			result = new ResponseDTO(status, ticket);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return result;

	}

	public ResponseDTO stepTicketBackward(Long ticketId) throws ControllerException {
		ResponseDTO result = null;
		try {
			TicketDTO ticket = service.stepTicketBackward(ticketId);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001",
					"Ticket has been Steped Backward successfully", "Ticket has been Steped Backward successfully",
					null);
			result = new ResponseDTO(status, ticket);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return result;

	}
	public ResponseDTO getSeverityPriorityStatusByUserName(String userEmail) throws ControllerException {
		ResponseDTO result = null;
		try {
			MainTicketChartDTO chartDTO ;
			chartDTO = service.getSeverityPriorityStatusByUserName(userEmail);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001",
					"Tickets has been retrived successfully", "Tickets has been retrived successfully", null);
			result = new ResponseDTO(status, chartDTO);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return result;

	}
	public ResponseDTO getDashBoardCountByProjectIDAndUserName(Long projectId, String userEmail) throws ControllerException {
		ResponseDTO result = null;
		try {
			List<WidgetDTO> list ;
			list = service.getDashBoardCountByProjectIDAndUserName(projectId, userEmail);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001",
					"Tickets has been retrived successfully", "Tickets has been retrived successfully", null);
			result = new ResponseDTO(status, list);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return result;

	}
	public ResponseDTO getWeekChartStatusesNumber(Long projectId) throws ControllerException {
		ResponseDTO result = null;
		try {
			List<WidgetDTO> list ;
			list = service.getWeekChartStatusesNumber(projectId);
			ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001",
					"Tickets has been retrived successfully", "Tickets has been retrived successfully", null);
			result = new ResponseDTO(status, list);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return result;

	}

}
