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
import com.sbm.helpdesk.persistence.dao.PortfolioDao;
import com.sbm.helpdesk.persistence.dao.ProjectDao;
import com.sbm.helpdesk.persistence.entity.*;
import com.sbm.helpdesk.common.dto.*;

@Service
public class ProjectServiceImpl  extends BasicServiceImpl<ProjectDTO, Project>  implements ProjectService {

	@Autowired
	private ProjectDao dao;
	
	@Autowired
	private PortfolioDao portfoliodao;

	private Project project = new Project();
	@Override
	@Transactional
	public void openProject(ProjectDTO projectDto) {
		/*Project bluePrintProject = new Project();
		Project project = convertToEntity(bluePrintProject, projectDto);
		projectDao.persist(project);*/
		
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
	public List<ProjectDTO> getProjectByPortfolioId(Long portfolioId) throws BusinessException {
		List<ProjectDTO> result;
		try {
			List<Project> projects = dao.getProjectsByPortfolioId(portfolioId);
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
	
	@Override
	public ProjectDTO addProject(ProjectDTO projectDTO) throws BusinessException {
		project = convertToEntity(project, projectDTO);
		try {
			project = dao.persist(project);
		} catch (RespositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convertToDTO(project, projectDTO);
	}
	@Override
	public ProjectDTO updateProject(ProjectDTO projectDTO) throws BusinessException {
		try {
			project = convertToEntity(project, projectDTO);
			//project.setPortfolio(portfoliodao.findById(project.getPortfolio().getPortfolioId()));
			project = dao.update(project);
		
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return  convertToDTO(project, projectDTO);
	}
	
	@Override
	public String deleteProject(Long id) throws BusinessException {
		String result = "";
		try {
			project= dao.findById(id);
			project.setDeleted(1);
		result = "Sucess";
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
	public ProjectDTO getByProjectId(Long projectId) throws BusinessException {
		ProjectDTO projectDTO = new ProjectDTO();
		try {
			project = dao.findById(projectId);
			projectDTO = convertToDTO(project, projectDTO);
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return projectDTO;
	}
	@Override
	public List<ProjectDTO> getAllProject() throws BusinessException {
		List<ProjectDTO> result;
		try {
		List<Project> projectList = dao.findAll();
		result = projectList.stream().map(item -> convertToDTO(item, new ProjectDTO())).collect(Collectors.toList());
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