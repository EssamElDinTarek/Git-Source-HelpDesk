package com.sbm.helpdesk.persistence.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.dao.InformationalDetailsDao;
import com.sbm.helpdesk.persistence.entity.InformationalDetails;

@Repository
public class InformationalDetailsDaoImp extends GenericDaoImpl<InformationalDetails> implements InformationalDetailsDao{

	@Override
	public List<InformationalDetails> getInformationalDetailsByTicketId(long ticketId) throws RespositoryException {
		List<InformationalDetails> result;
		try{
			TypedQuery<InformationalDetails> query = this.entityManager.createNamedQuery("InformationalDetails.findByticketId",InformationalDetails.class);
			query.setParameter("ticketId", ticketId);
			result = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return result;
	}

}
