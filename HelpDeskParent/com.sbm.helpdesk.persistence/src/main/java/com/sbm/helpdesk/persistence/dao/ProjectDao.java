package com.sbm.helpdesk.persistence.dao;

import java.util.List;

import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.entity.*;

public interface ProjectDao extends GenericDao<Project> {

	public Project getProjectByName(String projectName) throws RespositoryException;
	public List<Project> getProjectsByPortfolioId(Long portfolioId) throws RespositoryException;
}
