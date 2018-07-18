package com.sbm.helpdesk.service.dao.impl;

import javax.persistence.Query;
import java.util.*;
import org.springframework.stereotype.Repository;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.dao.*;
import com.sbm.helpdesk.service.entity.*;

@Repository
public class TicketDaoImpl extends GenericDaoImpl<Ticket> implements TicketDao {

	
	@Override
	public Ticket getByTicketNumber(String ticketnumber) throws RespositoryException {
		Ticket result = null;
		try{
			Query query = this.entityManager.createNamedQuery("Ticket.findByTicketNumber",Ticket.class);
			query.setParameter("arg1", ticketnumber);
			result = (Ticket) query.getSingleResult();
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return result;
		
	}
	@Override
	public List<Ticket> getByProjectName(String projectName) throws RespositoryException {
		List<Ticket> result;
		try{
			Query query = this.entityManager.createNamedQuery("Ticket.findByProjectName",Ticket.class);
			query.setParameter("arg1", projectName);
			result = query.getResultList();
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return result;
		
	}
	
}
