package com.sbm.helpdesk.persistence.dao;

import java.util.List;

import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.entity.BehavioralDetails;

public interface BehavioralDetailsDao extends GenericDao<BehavioralDetails> {
	
	public List<BehavioralDetails> getBehavioralDetailsByTicketId(long ticketId) throws RespositoryException;

}
