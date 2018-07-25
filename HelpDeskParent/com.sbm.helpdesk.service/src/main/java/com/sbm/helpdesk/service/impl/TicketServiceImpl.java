package com.sbm.helpdesk.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.service.dao.*;
import com.sbm.helpdesk.service.dto.*;
import com.sbm.helpdesk.service.entity.*;

@Service
public class TicketServiceImpl extends BasicServiceImpl<TicketDTO, Ticket> implements TicketService{
	
	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private WorkflowDao workflowDao;
	
	@Autowired
	private TicketSeverityDao severityDao;
	
	@Autowired
	private TicketPriorityDao priorityDao;
	
	
	private Ticket ticket = new Ticket();
		
	public TicketServiceImpl() {}

	@Override
	@Transactional
	public TicketDTO addTicket(TicketDTO ticketDTO) throws BusinessException {
		TicketDTO result = null;
		try {
		ticket = convertToEntity(ticket, ticketDTO);
		Date date= new Date();
		Timestamp ts = new Timestamp(date.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String ticketNumber ="Tic_"+sdf.format(ts)+ String.format("%03d", new Random().nextInt(1000));
		
		ticket.setTicketnumber(ticketNumber);
		ticket.setProject(projectDao.findById(ticketDTO.getProject().getProjectId()));
		ticket.setTicketSeverity(severityDao.findById(ticket.getTicketSeverity().getSeverityId()));
		ticket.setTicketPriority(priorityDao.findById(ticket.getTicketPriority().getPrioprtiyId()));
		ticket.setWorkflow(workflowDao.findById(ticket.getWorkflow().getFlowId()));
		Iterator workflowstepsit =ticket.getWorkflow().getWorkflowSteps().iterator();
		Step step = null;
		while (workflowstepsit.hasNext()) {
			WorkflowStep workflowstep = (WorkflowStep) workflowstepsit.next();
			if(workflowstep.getStepOrder() == new BigDecimal(2)) {
				step = workflowstep.getStep();
				break;
			}
			
		}
		ticket.setStep(step);
		ticket = ticketDao.persist(ticket);
		result = convertToDTO(ticket, ticketDTO);
		}catch(RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
			e1.printStackTrace();
	    	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
	    	}
		return result;
	}

	@Override
	@Transactional
	public TicketDTO updateTicket(TicketDTO ticketDTO) throws BusinessException {
		TicketDTO result = null;
		try {
		ticket = convertToEntity(ticket, ticketDTO);
		ticket.setTicketSeverity(severityDao.findById(ticket.getTicketSeverity().getSeverityId()));
		ticket.setTicketPriority(priorityDao.findById(ticket.getTicketPriority().getPrioprtiyId()));
		ticket.setWorkflow(workflowDao.findById(ticket.getWorkflow().getFlowId()));
		ticket = ticketDao.update(ticket);
		result = convertToDTO(ticket, ticketDTO);
		}catch(RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
			e1.printStackTrace();
	    	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
	    	}
		return result;
	}

	@Override
	@Transactional
	public TicketDTO getByTicketNumber(String ticketnumber) throws BusinessException {
		TicketDTO result = null;
		try {
		TicketDTO ticketDTO = new TicketDTO();
		ticket = ticketDao.getByTicketNumber(ticketnumber);
		result = convertToDTO(ticket, ticketDTO);
		}catch(RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
			e1.printStackTrace();
	    	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
	    	}
		return result;
	}
	
	@Override
	@Transactional
	public TicketDTO getByTicketId(Long ticketId) throws BusinessException {
		TicketDTO result;
		try {
		TicketDTO ticketDTO = new TicketDTO();
		ticket = ticketDao.findById(ticketId);
		result = convertToDTO(ticket, ticketDTO);
		}catch(RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
			e1.printStackTrace();
	    	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
	    	}
		return result;
	}
	
	@Override
	@Transactional
	public List<TicketDTO> getTicketByProjectName(String projectName) throws BusinessException {
		List<TicketDTO> result;
		try {
		List<Ticket> ticketList = ticketDao.getByProjectName(projectName);
		result = ticketList.stream().map(item -> convertToDTO(item, new TicketDTO())).collect(Collectors.toList());
		}catch(RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
			e1.printStackTrace();
	    	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
	    	}
		return result;
	}

	@Override
	@Transactional
	public List<TicketDTO> getByProjectIDAndUserName(long projectId,String userEmail) throws BusinessException {
		List<TicketDTO> result;
		try {
		List<Ticket> ticketList = ticketDao.getByProjectIDAndUserName(projectId, userEmail);
		result = ticketList.stream().map(item -> convertToDTO(item, new TicketDTO())).collect(Collectors.toList());
		}catch(RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
			e1.printStackTrace();
	    	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
	    	}
		return result;
	}
	@Override
	@Transactional
	public String deleteTicket(Long id) throws BusinessException {
		String result = "";
		try {
		Ticket ticket= ticketDao.findById(id);
		ticket.setDeleted(1);
		result = "Sucess";
		}catch(RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
			e1.printStackTrace();
	    	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
	    	}
		return result;
	}
	
	@Override
	@Transactional
	public List<HistoryDetailsDTO> getHistoryByTicketId(long ticketId) throws BusinessException {
		List<HistoryDetailsDTO> result;
		try {
		List<HistoryDetailsDTO> HistoryDetails = ticketDao.getHistoryByTicketId(ticketId);
		result = HistoryDetails;
		}catch(RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
			e1.printStackTrace();
	    	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
	    	}
		return result;
	}
}
