package com.sbm.helpdesk.persistence.dao;

import java.util.List;

import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.entity.*;

public interface UserDao extends GenericDao<Hduser> {

	public Hduser add(Hduser user) throws RespositoryException;
	public List<Hduser> listUsers() throws RespositoryException;
	public Hduser login(String email, String password) throws RespositoryException;
	public Hduser findByEmail(String email) throws RespositoryException;
	public List<Hduser> findByProjectId(Long projectId) throws RespositoryException;
	public List<Hduser> findByPortfolioId(Long portfolioId) throws RespositoryException;

}
