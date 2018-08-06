package com.sbm.helpdesk.service;

import java.util.List;
import javax.transaction.Transactional;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.dto.*;

@Transactional
public interface PortfolioService {
	
	public PortfolioDTO addPortfolio(PortfolioDTO portfolioDTO)throws BusinessException;
	public PortfolioDTO updatePortfolio(PortfolioDTO portfolioDTO)throws BusinessException;
	public String deletePortfolio(Long id) throws BusinessException;
	public PortfolioDTO getByPortfolioId(Long portfolioId)throws BusinessException;
	public List<PortfolioDTO> getAllPortfolio() throws BusinessException;
}
