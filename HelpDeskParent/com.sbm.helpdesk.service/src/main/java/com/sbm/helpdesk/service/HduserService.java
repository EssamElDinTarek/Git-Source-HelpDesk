package com.sbm.helpdesk.service;

import java.util.List;
import javax.transaction.Transactional;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.entity.Hduser;
import com.sbm.helpdesk.common.dto.*;

@Transactional
public interface HduserService {
	
	
	public List<HduserDTO> findByProjectId(Long projectId) throws BusinessException;
	public List<HduserDTO> findByPortfolioId(Long portfolioId) throws BusinessException;
}
