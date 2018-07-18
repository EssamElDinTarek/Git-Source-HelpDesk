package com.sbm.helpdesk.service.impl;

import java.util.List;
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
public class TicketPriorityServiceImpl extends BasicServiceImpl<TicketPriorityDTO, TicketPriority> implements TicketPriorityService{
	
	
	@Autowired
	private TicketPriorityDao priorityDao;
	
	public TicketPriorityServiceImpl() {}

	@Override
	@Transactional
	public List<TicketPriorityDTO> getAllTicketPriority() throws BusinessException {
		List<TicketPriorityDTO> result;
		try {
		List<TicketPriority> ticketPriorityList = priorityDao.findAll();
		result = ticketPriorityList.stream().map(item -> convertToDTO(item, new TicketPriorityDTO())).collect(Collectors.toList());
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
