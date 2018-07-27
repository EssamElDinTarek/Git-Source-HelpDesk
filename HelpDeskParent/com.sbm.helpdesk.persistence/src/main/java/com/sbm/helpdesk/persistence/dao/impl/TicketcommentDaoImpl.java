package com.sbm.helpdesk.persistence.dao.impl;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;

@Repository
public class TicketcommentDaoImpl extends GenericDaoImpl<Ticketcomment> implements TicketcommentDao {

	
	@Override
	public List<Ticketcomment> getByTicketId(long ticID) throws RespositoryException {
		List<Ticketcomment> result;
		try{
			Query query = this.entityManager.createNamedQuery("Ticketcomment.findAllByTicketId",Ticketcomment.class);
			query.setParameter("arg1", ticID);
			result = query.getResultList();
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return result;
		
	}
}
