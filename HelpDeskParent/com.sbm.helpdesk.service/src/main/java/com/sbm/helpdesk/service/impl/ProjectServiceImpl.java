package com.sbm.helpdesk.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.service.dao.ProjectDao;
import com.sbm.helpdesk.service.dto.*;
import com.sbm.helpdesk.service.entity.*;;

@Service
public class ProjectServiceImpl  extends BasicServiceImpl<ProjectDTO, Project>  implements ProjectService {

	@Autowired
	private ProjectDao projectDao;

	@Override
	@Transactional
	public void openProject(ProjectDTO projectDto) {
		/*Project bluePrintProject = new Project();
		Project project = convertToEntity(bluePrintProject, projectDto);
		projectDao.persist(project);*/
		
	}

	@Override
	@Transactional
	public ProjectDTO updateProject(Long projectID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public ProjectDTO closeProject(Long projectID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void assignHdusersToProject(List<Hduser> hdusers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProjectDTO getProjectById(Long projectId) throws BusinessException {
		ProjectDTO result;
		try {
			Project project = projectDao.getProjectById(projectId);
			ProjectDTO projectDTO = new ProjectDTO();
			result =  convertToDTO(project,projectDTO);
		}catch(RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
			e1.printStackTrace();
	    	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
	    	}
		 return result;
	}

	@Override
	public List<ProjectDTO> getProjectByPortfolioId(Long portfolioId) throws BusinessException {
		List<ProjectDTO> result;
		try {
			List<Project> projects = projectDao.getProjectsByPortfolioId(portfolioId);
			System.out.println("Hello Test: " + projects.size());
			result =  projects.stream().
					map(item -> convertToDTO(item, new ProjectDTO())).collect(Collectors.toList());
		}catch(RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
			e1.printStackTrace();
	    	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
	    	}
		 return result;
	}
}