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
	@Override
	public List<Ticket> getByProjectIDAndUserName(long projectId,String userEmail) throws RespositoryException {
		List<Ticket> result;
		try{
			String sqlString = "select TICKET.* FROM TICKET, PROJECT,TEAM, STEPS,HDUSER where"
					+ " TICKET.PROJECT_ID = PROJECT.PROJECT_ID and ticket.step_id = STEPS.STEP_ID and STEPS.TEAM_ID = TEAM.REC_ID "
					+ "and HDUSER.TEAM_ID =TEAM.REC_ID and PROJECT.PROJECT_ID = ? and  HDUSER.EMAIL_ADDRESS = ?";
			Query query = this.entityManager.createNativeQuery(sqlString,Ticket.class);
			query.setParameter(1, projectId);
			query.setParameter(2, userEmail);
			result = query.getResultList();
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return result;
		
	}
	
}
