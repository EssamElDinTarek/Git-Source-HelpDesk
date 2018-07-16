package com.sbm.helpdesk.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.service.dto.*;
import com.sbm.helpdesk.service.entity.*;;

@Service
public class ProjectServiceImpl  extends BasicServiceImpl<ProjectDTO, Project>  implements ProjectService {


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
}