package com.sbm.helpdesk.service;

import java.util.List;
import javax.transaction.Transactional;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.persistence.entity.*;
import com.sbm.helpdesk.common.dto.*;

@Transactional
public interface ProjectService {
	
 public void openProject(ProjectDTO projectDto);
 public ProjectDTO closeProject(Long projectID);
 public void assignHdusersToProject(List<Hduser> hdusers);
 public List<ProjectDTO> getProjectByPortfolioId(Long portfolioId) throws BusinessException;
 public ProjectDTO addProject(ProjectDTO projectDTO) throws BusinessException;
 public ProjectDTO updateProject(ProjectDTO projectDTO) throws BusinessException;
 public String deleteProject(Long id) throws BusinessException;
 public List<ProjectDTO> getAllProject() throws BusinessException;
 public ProjectDTO getByProjectId(Long projectId) throws BusinessException;

}
