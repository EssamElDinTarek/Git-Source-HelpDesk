package com.sbm.helpdesk.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbm.helpdesk.common.constant.IntegrationServicesConstant;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.common.enums.servicesEnums.ServicesEnums;

@Service
public class AttachmentServiceImpl extends BasicServiceImpl<AttachmentDTO, Attachment> implements AttachmentService{
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	private StepDao stepDao;
	
	@Autowired
	private UserDao userDao;
	
	@Resource
	BehavioralDetailsService behavioralDetailsService;
	
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
	public AttachmentDTO getAttachmentById(long attachmentId) throws BusinessException {
		AttachmentDTO result =null;
		try {
		Attachment attachment = attachmentDao.findById(attachmentId);
		AttachmentDTO AttachmentDTO = new AttachmentDTO();
		result = convertToDTO(attachment, AttachmentDTO);
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
		behavioralDetailsService.createBehavioralDetails
		(createBehavioralDetailsHistory(attachment,ServicesEnums.BEHAVIOR_VALUE_DELETE.getStringValue()));
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
	
	@Override
	@Transactional
	public boolean uploadAttachment(long userId, MultipartFile[] files, long ticketId) throws BusinessException {
		boolean result = false;
		
		try {
			Ticket ticket = ticketDao.findById(ticketId);
			Hduser user = userDao.findById(userId);
			result = saveAttachment(user, files, ticket);
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
	public boolean saveAttachment(Hduser user, MultipartFile[] files, Ticket ticket) throws BusinessException {
		boolean result = false;
		String folderPath = IntegrationServicesConstant.ATTACHMENT_PATH+ticket.getTicketnumber()+"_attachment/";
		Date date = new Date();
		try {
			File folder = new File(folderPath);
			if(!folder.exists()){
				folder.mkdirs();
			}
			for(MultipartFile file :files) {
				 if (!file.getOriginalFilename().isEmpty()) {
					 String filePath = folderPath +  file.getOriginalFilename();
			         BufferedOutputStream outputStream = new BufferedOutputStream(
			               new FileOutputStream(
			                     new File(folderPath, file.getOriginalFilename())));
			         outputStream.write(file.getBytes());
			         outputStream.flush();
			         outputStream.close();
			         Attachment attachment = new Attachment();
			         attachment.setDescription(file.getOriginalFilename());
			         attachment.setMimeType(file.getContentType());
			         attachment.setName(file.getOriginalFilename());
			         attachment.setCreationDate(date);
			         attachment.setSize(file.getSize());
			         attachment.setPath(filePath);
			         attachment.setTicket(ticket);
			         attachment.setHduser(user);
			         attachmentDao.persist(attachment);
			         behavioralDetailsService.
			         	createBehavioralDetails(createBehavioralDetailsHistory(attachment,ServicesEnums.BEHAVIOR_VALUE_ADD.getStringValue()));
			      }
		result = true;
		}
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
	
	public BehavioralDetails createBehavioralDetailsHistory(Attachment attachment, String value) throws RespositoryException {
		BehavioralDetails behavioralDetails = new BehavioralDetails();
		Ticket ticket = ticketDao.findById(attachment.getTicket().getTicketId());
		behavioralDetails.setBehaviorName(ServicesEnums.BEHAVIOR_NAME_ATTACHMENT.getStringValue());
		behavioralDetails.setBehaviorValue(value);
		behavioralDetails.setId(attachment.getAttachmentId());
		behavioralDetails.setStepId(stepDao.findById(ticket.getStep().getStepId()));
		behavioralDetails.setTicketId(ticket);
		behavioralDetails.setActionBy(userDao.findById(attachment.getHduser().getUserId()));
		behavioralDetails.setActionAt(new Date());
		return behavioralDetails;
	}

}
