package com.sbm.helpdesk.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
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
	public AttachmentDTO addAttachment(AttachmentDTO attachmentDTO) throws BusinessException {
		attachment = convertToEntity(attachment, attachmentDTO);
		try {
			attachment = attachmentDao.persist(attachment);
		} catch (RespositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convertToDTO(attachment, attachmentDTO);
	}
	@Override
	@Transactional
	public List<AttachmentDTO> getAttachmentByTicId(long ticId) throws BusinessException {
		List<AttachmentDTO> result =null;
		try {
		List<Attachment> attachmentList = attachmentDao.getByTicketId(ticId);
		result = attachmentList.stream().map(item -> convertToDTO(item, new AttachmentDTO())).collect(Collectors.toList());
		}catch(RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
			e1.printStackTrace();
	    	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
	    	}
		return result;
	}
	@Override
	@Transactional
	public String deleteAttachment(Long id) throws BusinessException {
		String result = "";
		try {
		Attachment attachment= attachmentDao.findById(id);
		attachment.setDeleted(1);
		result = "Sucess";
		}catch(RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
			e1.printStackTrace();
	    	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
	    	}
		return result;
	}


}
