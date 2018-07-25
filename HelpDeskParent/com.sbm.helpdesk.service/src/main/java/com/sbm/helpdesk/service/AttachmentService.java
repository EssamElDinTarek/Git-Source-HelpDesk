package com.sbm.helpdesk.service;

import java.util.List;

import javax.transaction.Transactional;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.dto.*;

@Transactional
public interface AttachmentService {
	
	public AttachmentDTO addAttachment(AttachmentDTO attachmentDTO)throws BusinessException ;
	public List<AttachmentDTO> getAttachmentByTicId(long ticId) throws BusinessException;
	public String deleteAttachment(Long id) throws BusinessException;
}
