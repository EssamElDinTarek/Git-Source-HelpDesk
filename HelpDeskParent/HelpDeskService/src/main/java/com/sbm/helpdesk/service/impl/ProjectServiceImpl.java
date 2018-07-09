package com.sbm.helpdesk.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.helpdesk.dao.ProjectDao;
 import com.sbm.helpdesk.dto.ProjectDTO;
import com.sbm.helpdesk.dto.SubcomponentDTO;
 import com.sbm.helpdesk.entity.Component;
import com.sbm.helpdesk.entity.Project;
import com.sbm.helpdesk.entity.Hduser;
import com.sbm.helpdesk.entity.Privilege;
import com.sbm.helpdesk.entity.Subcomponent;
import com.sbm.helpdesk.service.HdGroupService;
import com.sbm.helpdesk.service.ProjectService;;

@Service
public class ProjectServiceImpl  extends BasicServiceImpl<ProjectDTO, Project>  implements ProjectService {

    //@Autowired//(required= true)
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
}