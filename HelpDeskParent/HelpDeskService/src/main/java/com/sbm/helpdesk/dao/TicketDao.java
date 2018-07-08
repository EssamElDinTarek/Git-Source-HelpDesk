package com.sbm.helpdesk.dao;


import java.util.*;

import com.sbm.helpdesk.entity.Ticket;


public interface TicketDao extends GenericDao<Ticket> {

	
	public Ticket getByTicketNumber(String ticketnumber);
	public List<Ticket> getByProjectName(String projectName);
	
}
