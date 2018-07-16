package com.sbm.helpdesk.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<TicketPriorityDTO> getAllTicketPriority() {
		List<TicketPriority> ticketPriorityList = priorityDao.findAll();
		List<TicketPriorityDTO> list = ticketPriorityList.stream().map(item -> convertToDTO(item, new TicketPriorityDTO())).collect(Collectors.toList());
		return list;
	}

}
