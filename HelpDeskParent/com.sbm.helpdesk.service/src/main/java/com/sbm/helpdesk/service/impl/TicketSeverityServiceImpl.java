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
public class TicketSeverityServiceImpl extends BasicServiceImpl<TicketSeverityDTO, TicketSeverity> implements TicketSeverityService{
	
	@Autowired
	private TicketSeverityDao severityDao;
	
	public TicketSeverityServiceImpl() {}

	@Override
	@Transactional
	public List<TicketSeverityDTO> getAllTicketSeverity() {
		List<TicketSeverity> ticketSeverityList = severityDao.findAll();
		List<TicketSeverityDTO> list = ticketSeverityList.stream().map(item -> convertToDTO(item, new TicketSeverityDTO())).collect(Collectors.toList());
		return list;
	}
}
