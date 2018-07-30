package com.sbm.helpdesk.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.InformationalDetailsService;
import com.sbm.helpdesk.persistence.dao.InformationalDetailsDao;
import com.sbm.helpdesk.common.dto.InformationalDetailsDTO;
import com.sbm.helpdesk.persistence.entity.InformationalDetails;

@Service
public class InformationalDetailsServiceImp extends BasicServiceImpl<InformationalDetailsDTO, InformationalDetails> implements InformationalDetailsService{

	@Autowired
	private InformationalDetailsDao informationalDetailsDao;
	
	@Override
	public void createInformationalDetails(InformationalDetails informationalDetails) throws BusinessException {
		try {
			
			informationalDetailsDao.persist(informationalDetails);
			
		}catch(RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
			e1.printStackTrace();
	    	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
	    	}
		
	}

	@Override
	public List<InformationalDetailsDTO> getInformationalDetailsByTicketId(long ticketId) throws BusinessException {
		List<InformationalDetailsDTO> result;
		try {
			List<InformationalDetails> informationalDetailsList = informationalDetailsDao.getInformationalDetailsByTicketId(ticketId);
			result = informationalDetailsList.stream().map(item -> convertToDTO(item, new InformationalDetailsDTO())).collect(Collectors.toList());
			
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
