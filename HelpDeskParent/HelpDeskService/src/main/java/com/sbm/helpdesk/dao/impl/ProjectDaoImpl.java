package com.sbm.helpdesk.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sbm.helpdesk.dao.*;
import com.sbm.helpdesk.entity.*;

@Repository
public class ProjectDaoImpl extends GenericDaoImpl<Project> implements ProjectDao {

	@Override
	public Project add(Project project) {
		return persist(project);
	}
	@Override
	public Project update(Project project) {
		return update(project);
	}
	@Override
	public Project getProjectByName(String projectName) {
		try{
			Query query = this.entityManager.createNamedQuery("Project.findProjectByName",Project.class);
			query.setParameter("arg1", projectName);
			return (Project) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
