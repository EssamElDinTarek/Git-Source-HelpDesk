package com.sbm.helpdesk.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.common.enums.servicesEnums.ServicesEnums;

@Service
public class TicketcommentServiceImpl extends BasicServiceImpl<TicketcommentDTO, Ticketcomment> implements TicketcommentService{
	
	@Autowired
	private TicketcommentDao ticketcommentDao;
	
	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	private StepDao stepDao;
	
	@Autowired
	private HduserDao hduserDao;
	
	@Resource
	BehavioralDetailsService behavioralDetailsService;
	
	private Ticketcomment ticketcomment = new Ticketcomment();
		
	public TicketcommentServiceImpl() {}

	@Override
	@Transactional
	public TicketcommentDTO addTicketcomment(TicketcommentDTO ticketcommentDTO) throws BusinessException {
		ticketcomment = convertToEntity(ticketcomment, ticketcommentDTO);
		try {
			ticketcomment = ticketcommentDao.persist(ticketcomment);
			behavioralDetailsService.createBehavioralDetails(createBehavioralDetailsHistory(ticketcomment,ServicesEnums.BEHAVIOR_VALUE_ADD.getStringValue()));
		} catch (RespositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convertToDTO(ticketcomment, ticketcommentDTO);
	}
	@Override
	@Transactional
	public List<TicketcommentDTO> getTicketcommentByTicId(long ticId) throws BusinessException {
		List<TicketcommentDTO> result=null;
		try {
		List<Ticketcomment> ticketcommentList = ticketcommentDao.getByTicketId(ticId);
		result = ticketcommentList.stream().map(item -> convertToDTO(item, new TicketcommentDTO())).collect(Collectors.toList());
		}catch(Exception e1) {
			e1.printStackTrace();
	    	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
	    	}
		return result;
	}

	@Override
	@Transactional
	public String deleteTicketcomment(Long id) throws BusinessException {
		String result = "";
		try {
		Ticketcomment ticketcomment= ticketcommentDao.findById(id);
		ticketcomment.setDeleted(1);
		behavioralDetailsService.createBehavioralDetails(createBehavioralDetailsHistory(ticketcomment,ServicesEnums.BEHAVIOR_VALUE_DELETE.getStringValue()));
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
	
	public BehavioralDetails createBehavioralDetailsHistory(Ticketcomment ticketcomment, String value) throws RespositoryException {
		BehavioralDetails behavioralDetails = new BehavioralDetails();
		Ticket ticket = ticketDao.findById(ticketcomment.getTicket().getTicketId());
		behavioralDetails.setBehaviorName(ServicesEnums.BEHAVIOR_NAME_COMMENT.getStringValue());
		behavioralDetails.setBehaviorValue(value);
		behavioralDetails.setId(ticketcomment.getTicketcommentId());
		behavioralDetails.setStepId(stepDao.findById(ticket.getStep().getStepId()));
		behavioralDetails.setTicketId(ticket);
		behavioralDetails.setActionBy(hduserDao.findById(ticketcomment.getHduser().getUserId()));
		behavioralDetails.setActionAt(new Date());
		return behavioralDetails;
	}

}
