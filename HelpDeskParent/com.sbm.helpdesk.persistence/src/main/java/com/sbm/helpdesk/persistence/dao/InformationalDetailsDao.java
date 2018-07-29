package com.sbm.helpdesk.persistence.dao;

import java.util.List;

import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.entity.InformationalDetails;

public interface InformationalDetailsDao extends GenericDao<InformationalDetails> {
	
	public List<InformationalDetails> getInformationalDetailsByTicketId(long ticketId) throws RespositoryException;

}
