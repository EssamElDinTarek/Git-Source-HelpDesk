package com.sbm.helpdesk.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.helpdesk.common.dto.BehavioralDetailsDTO;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.BehavioralDetailsService;
import com.sbm.helpdesk.persistence.dao.BehavioralDetailsDao;
import com.sbm.helpdesk.persistence.entity.BehavioralDetails;

@Service
public class BehavioralDetailsServiceImp extends BasicServiceImpl<BehavioralDetailsDTO, BehavioralDetails> implements BehavioralDetailsService{

	@Autowired
	private BehavioralDetailsDao BehavioralDetailsDao;
	
	@Override
	public void createBehavioralDetails(BehavioralDetails BehavioralDetails) throws BusinessException {
		try {
			
			BehavioralDetailsDao.persist(BehavioralDetails);
			
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
	public List<BehavioralDetailsDTO> getBehavioralDetailsByTicketId(long ticketId) throws BusinessException {
		List<BehavioralDetailsDTO> result;
		try {
			List<BehavioralDetails> BehavioralDetailsList = BehavioralDetailsDao.getBehavioralDetailsByTicketId(ticketId);
			result = BehavioralDetailsList.stream().map(item -> convertToDTO(item, new BehavioralDetailsDTO())).collect(Collectors.toList());
			
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
