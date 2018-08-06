package com.sbm.helpdesk.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.common.enums.servicesEnums.ServicesEnums;

@Service
public class PortfolioServiceImpl extends BasicServiceImpl<PortfolioDTO, Portfolio> implements PortfolioService{
	
	
	@Autowired
	private PortfolioDao dao;
	
	@Autowired
	private UserDao userDao;
	
	private Portfolio portfolio = new Portfolio();
	@Override
	@Transactional
	public PortfolioDTO addPortfolio(PortfolioDTO portfolioDTO) throws BusinessException {
		portfolio = convertToEntity(portfolio, portfolioDTO);
		try {
			portfolio.setHduser(userDao.findByEmail(portfolio.getHduser().getEmailAddress()));
			portfolio = dao.persist(portfolio);
		} catch (RespositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convertToDTO(portfolio, portfolioDTO);
	}
	@Override
	@Transactional
	public PortfolioDTO updatePortfolio(PortfolioDTO portfolioDTO) throws BusinessException {
		try {
			portfolio = convertToEntity(portfolio, portfolioDTO);
			portfolio.setHduser(userDao.findById(portfolio.getHduser().getUserId()));
			portfolio = dao.update(portfolio);
		
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return  convertToDTO(portfolio, portfolioDTO);
	}
	
	@Override
	@Transactional
	public String deletePortfolio(Long id) throws BusinessException {
		String result = "";
		try {
			portfolio= dao.findById(id);
			portfolio.setDeleted(1);
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
	public List<PortfolioDTO> getAllPortfolio() throws BusinessException {
		List<PortfolioDTO> result;
		try {
		List<Portfolio> portfolioList = dao.findAll();
		result = portfolioList.stream().map(item -> convertToDTO(item, new PortfolioDTO())).collect(Collectors.toList());
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
	public PortfolioDTO getByPortfolioId(Long portfolioId) throws BusinessException {
		PortfolioDTO portfolioDTO = new PortfolioDTO();
		try {
			portfolio = dao.findById(portfolioId);
			portfolioDTO = convertToDTO(portfolio, portfolioDTO);
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return portfolioDTO;
	}

}
