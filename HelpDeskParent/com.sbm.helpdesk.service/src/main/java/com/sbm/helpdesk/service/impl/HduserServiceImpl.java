package com.sbm.helpdesk.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;
import com.sbm.helpdesk.common.dto.*;

@Service
public class HduserServiceImpl extends BasicServiceImpl<HduserDTO, Hduser> implements HduserService{
	
	@Autowired
	private UserDao userDao;
	
	Hduser _user = new Hduser();

	
	public List<HduserDTO> findByProjectId(Long projectId) throws BusinessException{
		List<HduserDTO> result =null;
		try {
			List<Hduser> userList = userDao.findByProjectId(projectId);
			result = userList.stream().map(item -> convertToDTO(item, new HduserDTO())).collect(Collectors.toList());
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
	public List<HduserDTO> findByPortfolioId(Long portfolioId) throws BusinessException{
		List<HduserDTO> result =null;
		try {
			List<Hduser> userList = userDao.findByPortfolioId(portfolioId);
			result = userList.stream().map(item -> convertToDTO(item, new HduserDTO())).collect(Collectors.toList());
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
