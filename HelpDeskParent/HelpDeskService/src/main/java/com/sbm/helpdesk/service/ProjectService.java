package com.sbm.helpdesk.service;


import java.util.List;

import com.sbm.helpdesk.dto.ProjectDTO;
import com.sbm.helpdesk.entity.Hduser;


public interface ProjectService {
	
 public void openProject(ProjectDTO projectDto);
 public ProjectDTO updateProject(Long projectID);
 public ProjectDTO closeProject(Long projectID);
 public void assignHdusersToProject(List<Hduser> hdusers);


}
