package com.sbm.helpdesk.service.dao.impl;

import javax.persistence.Query;
import java.util.*;
import org.springframework.stereotype.Repository;

import com.sbm.helpdesk.service.dao.*;
import com.sbm.helpdesk.service.entity.*;

@Repository
public class TicketDaoImpl extends GenericDaoImpl<Ticket> implements TicketDao {

	
	@Override
	public Ticket getByTicketNumber(String ticketnumber) {
		try{
			Query query = this.entityManager.createNamedQuery("Ticket.findByTicketNumber",Ticket.class);
			query.setParameter("arg1", ticketnumber);
			return (Ticket) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	public List<Ticket> getByProjectName(String projectName) {
		try{
			Query query = this.entityManager.createNamedQuery("Ticket.findByProjectName",Ticket.class);
			query.setParameter("arg1", projectName);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
