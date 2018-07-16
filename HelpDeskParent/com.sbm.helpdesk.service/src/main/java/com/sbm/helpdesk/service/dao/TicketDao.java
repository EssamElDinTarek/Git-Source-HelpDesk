package com.sbm.helpdesk.service.dao;


import java.util.*;

import com.sbm.helpdesk.service.entity.Ticket;


public interface TicketDao extends GenericDao<Ticket> {

	
	public Ticket getByTicketNumber(String ticketnumber);
	public List<Ticket> getByProjectName(String projectName);
	
}
