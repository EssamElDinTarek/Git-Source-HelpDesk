package com.sbm.helpdesk.service.dao;

import java.util.List;

import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.entity.*;

public interface AttachmentDao extends GenericDao<Attachment> {

	public List<Attachment> getByTicketId(long ticID) throws RespositoryException;
}
