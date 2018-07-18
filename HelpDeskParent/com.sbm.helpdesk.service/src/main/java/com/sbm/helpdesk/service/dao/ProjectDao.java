package com.sbm.helpdesk.service.dao;

import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.entity.*;

public interface ProjectDao extends GenericDao<Project> {

	public Project add(Project project) throws RespositoryException;
	public Project update(Project project) throws RespositoryException;
	public Project getProjectByName(String projectName) throws RespositoryException;
}
