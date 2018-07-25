package com.sbm.helpdesk.service.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.dao.*;
import com.sbm.helpdesk.service.entity.*;
@Repository
public class AttachmentDaoImpl extends GenericDaoImpl<Attachment> implements AttachmentDao {

	@Override
	public List<Attachment> getByTicketId(long ticID) throws RespositoryException {
		List<Attachment> result;
		try{
			Query query = this.entityManager.createNamedQuery("Attachment.findAllByTicketId",Attachment.class);
			query.setParameter("arg1", ticID);
			result = query.getResultList();
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return result;
		
	}
}
