package com.sbm.helpdesk.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.service.dao.*;
import com.sbm.helpdesk.service.dto.*;
import com.sbm.helpdesk.service.entity.*;

@Service
public class AttachmentServiceImpl extends BasicServiceImpl<AttachmentDTO, Attachment> implements AttachmentService{
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	private Attachment attachment = new Attachment();
		
	public AttachmentServiceImpl() {}

	@Override
	@Transactional
	public AttachmentDTO addAttachment(AttachmentDTO attachmentDTO) throws RespositoryException {
		attachment = convertToEntity(attachment, attachmentDTO);
		attachment = attachmentDao.persist(attachment);
		return convertToDTO(attachment, attachmentDTO);
	}

}
