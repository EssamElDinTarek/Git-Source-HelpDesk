package com.sbm.helpdesk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.helpdesk.dao.*;
import com.sbm.helpdesk.dto.*;
import com.sbm.helpdesk.entity.*;
import com.sbm.helpdesk.service.*;

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
