package com.sbm.helpdesk.service.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.dao.*;
import com.sbm.helpdesk.service.entity.*;

@Repository
public class ProjectDaoImpl extends GenericDaoImpl<Project> implements ProjectDao {

	@Override
	public Project add(Project project) throws RespositoryException {
		Project result = null;
		try {
			result = persist(project);
		}catch(Exception e) {
				throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
			   }
		return result;
	}
	@Override
	public Project update(Project project) throws RespositoryException {
		Project result = null;
		try {
			result = update(project);
		}catch(Exception e) {
				throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
			   }
		return result;
	}
	@Override
	public Project getProjectByName(String projectName) throws RespositoryException {
		Project result = null;
		try{
			Query query = this.entityManager.createNamedQuery("Project.findProjectByName",Project.class);
			query.setParameter("arg1", projectName);
			result = (Project) query.getSingleResult();
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return result;
		
	}
}
