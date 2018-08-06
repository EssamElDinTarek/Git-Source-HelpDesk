package com.sbm.helpdesk.service.facade;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.ControllerException;
import com.sbm.helpdesk.service.*;

@Service
public class PortfolioServiceFacade {

	@Autowired
	private PortfolioService service;
	
	public ResponseDTO addPortfolio(PortfolioDTO portfolioDTO) throws ControllerException {
		ResponseDTO result = null;
		 try {
		PortfolioDTO _portfolio = service.addPortfolio(portfolioDTO);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Portfolio added successfully", 
				"Portfolio added successfully", null);
		result = new ResponseDTO(status, _portfolio);
		 }catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
	}
	public ResponseDTO updatePortfolio(PortfolioDTO portfolioDTO) throws ControllerException {
		ResponseDTO result = null;
		 try {
		PortfolioDTO _portfolio = service.updatePortfolio(portfolioDTO);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Portfolio updated successfully", 
				"Portfolio updated successfully", null);
		result = new ResponseDTO(status, _portfolio);
		 }catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
	}
	public ResponseDTO getPortfolioById(Long portfolioId) throws ControllerException {
		ResponseDTO result = null;
		 try {
		PortfolioDTO _portfolio = service.getByPortfolioId(portfolioId);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"get portfolio by id successfully", 
				"get portfolio by id successfully", null);
		result = new ResponseDTO(status, _portfolio);
		 }catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
	}
	public ResponseDTO deletePortfolioById(Long protfolioId) throws ControllerException {
		ResponseDTO result = null;
		 try {
			 String res = service.deletePortfolio(protfolioId);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Portfolio deleted successfully", 
				"Portfolio deleted successfully", null);
		result = new ResponseDTO(status, res);
		 }catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
	}
	public ResponseDTO getAllPortfolio() throws ControllerException {
		ResponseDTO result = null;
		 try {
		List<PortfolioDTO> _portfolioList = service.getAllPortfolio();
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"get all portfolio successfully", 
				"get all portfolio successfully", null);
		result = new ResponseDTO(status, _portfolioList);
		 }catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
	}

}
