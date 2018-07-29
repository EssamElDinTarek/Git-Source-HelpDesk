package com.sbm.helpdesk.persistence.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.dao.BehavioralDetailsDao;
import com.sbm.helpdesk.persistence.entity.BehavioralDetails;

@Repository
public class BehavioralDetailsDaoImp extends GenericDaoImpl<BehavioralDetails> implements BehavioralDetailsDao{

	@Override
	public List<BehavioralDetails> getBehavioralDetailsByTicketId(long ticketId) throws RespositoryException {
		List<BehavioralDetails> result;
		try{
			TypedQuery<BehavioralDetails> query = this.entityManager.createNamedQuery("BehavioralDetails.findByticketId",BehavioralDetails.class);
			query.setParameter("ticketId", ticketId);
			result = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return result;
	}

}
