package com.sbm.helpdesk.service;

import java.util.List;
import javax.transaction.Transactional;

import com.sbm.helpdesk.service.dto.ProjectDTO;
import com.sbm.helpdesk.service.entity.Hduser;

@Transactional
public interface ProjectService {
	
 public void openProject(ProjectDTO projectDto);
 public ProjectDTO updateProject(Long projectID);
 public ProjectDTO closeProject(Long projectID);
 public void assignHdusersToProject(List<Hduser> hdusers);


}
