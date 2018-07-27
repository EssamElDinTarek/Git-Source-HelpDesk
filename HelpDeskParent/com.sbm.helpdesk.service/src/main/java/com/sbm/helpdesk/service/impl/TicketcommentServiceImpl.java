package com.sbm.helpdesk.service.impl;

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
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;
import com.sbm.helpdesk.common.dto.*;

@Service
public class TicketcommentServiceImpl extends BasicServiceImpl<TicketcommentDTO, Ticketcomment> implements TicketcommentService{
	
	@Autowired
	private TicketcommentDao ticketcommentDao;
	
	private Ticketcomment ticketcomment = new Ticketcomment();
		
	public TicketcommentServiceImpl() {}

	@Override
	@Transactional
	public TicketcommentDTO addTicketcomment(TicketcommentDTO ticketcommentDTO) throws BusinessException {
		ticketcomment = convertToEntity(ticketcomment, ticketcommentDTO);
		try {
			ticketcomment = ticketcommentDao.persist(ticketcomment);
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

}
