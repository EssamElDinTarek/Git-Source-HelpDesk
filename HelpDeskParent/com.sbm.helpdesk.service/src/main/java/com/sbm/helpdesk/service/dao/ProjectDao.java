package com.sbm.helpdesk.service.dao;

import com.sbm.helpdesk.service.entity.*;

public interface ProjectDao extends GenericDao<Project> {

	public Project add(Project project);
	public Project update(Project project);
	public Project getProjectByName(String projectName);
}
