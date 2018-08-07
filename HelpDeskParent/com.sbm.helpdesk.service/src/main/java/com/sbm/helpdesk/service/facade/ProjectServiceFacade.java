package com.sbm.helpdesk.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.service.*;

@Service
public class ProjectServiceFacade {

	@Autowired
	private ProjectService service;
	
	
	public ResponseDTO openProject(ProjectDTO projectDto){
		service.openProject(projectDto);
		return new ResponseDTO(null,"success" );
	}
}
