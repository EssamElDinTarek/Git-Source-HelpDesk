package com.sbm.helpdesk.dao;

import com.sbm.helpdesk.entity.*;

public interface ProjectDao extends GenericDao<Project> {

	public Project add(Project project);
	public Project update(Project project);
	public Project getProjectByName(String projectName);
}
