package com.sbm.helpdesk.service.dao;

import java.util.List;

import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.entity.*;

public interface TicketcommentDao extends GenericDao<Ticketcomment> {

	public List<Ticketcomment> getByTicketId(long ticID) throws RespositoryException ;
}
