package com.sbm.helpdesk.service;

import javax.transaction.Transactional;

import com.sbm.helpdesk.service.dto.*;

@Transactional
public interface AttachmentService {
	
	public AttachmentDTO addAttachment(AttachmentDTO attachmentDTO);
}
