package com.sbm.helpdesk.service.dao;


import java.util.*;

import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.dto.HistoryDetailsDTO;
import com.sbm.helpdesk.service.entity.Ticket;


public interface TicketDao extends GenericDao<Ticket> {

	
	public Ticket getByTicketNumber(String ticketnumber) throws RespositoryException;
	public List<Ticket> getByProjectName(String projectName) throws RespositoryException;
	public List<Ticket> getByProjectIDAndUserName(long projectId,String userEmail) throws RespositoryException;
	List<HistoryDetailsDTO> getHistoryByTicketId(long ticketId) throws RespositoryException;
}
