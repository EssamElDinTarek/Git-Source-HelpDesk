package com.sbm.helpdesk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.multipart.MultipartFile;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.service.dto.*;

@Transactional
public interface AttachmentService {
	
	public AttachmentDTO addAttachment(AttachmentDTO attachmentDTO)throws BusinessException ;
	public List<AttachmentDTO> getAttachmentByTicId(long ticId) throws BusinessException;
	public String deleteAttachment(Long id) throws BusinessException;
	public boolean uploadAttachment(long userId, MultipartFile[] files, long ticketId) throws BusinessException;
	public AttachmentDTO getAttachmentById(long attachmentId) throws BusinessException;
}
