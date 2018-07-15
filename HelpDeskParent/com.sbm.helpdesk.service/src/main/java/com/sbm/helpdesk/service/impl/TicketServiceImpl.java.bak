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
public class TicketServiceImpl extends BasicServiceImpl<TicketDTO, Ticket> implements TicketService{
	
	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	private Ticket ticket = new Ticket();
		
	public TicketServiceImpl() {}

	@Override
	@Transactional
	public TicketDTO addTicket(TicketDTO ticketDTO) {
		ticket = convertToEntity(ticket, ticketDTO);
		ticket = ticketDao.persist(ticket);
		return convertToDTO(ticket, ticketDTO);
	}

	@Override
	@Transactional
	public TicketDTO updateTicket(TicketDTO ticketDTO) {
		ticket = convertToEntity(ticket, ticketDTO);
		ticket = ticketDao.update(ticket);
		return convertToDTO(ticket, ticketDTO);
	}

	@Override
	@Transactional
	public TicketDTO getByTicketNumber(String ticketnumber) {
		TicketDTO ticketDTO = new TicketDTO();
		ticket = ticketDao.getByTicketNumber(ticketnumber);
		return convertToDTO(ticket, ticketDTO);
	}
	
	@Override
	@Transactional
	public List<TicketDTO> getTicketByProjectName(String projectName) {
		List<Ticket> ticketList = ticketDao.getByProjectName(projectName);
		List<TicketDTO> list = ticketList.stream().map(item -> convertToDTO(item, new TicketDTO())).collect(Collectors.toList());
		return list;
	}

}
