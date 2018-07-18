package com.sbm.helpdesk.service.facade;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.service.dto.*;
@Service
public class WorkflowServiceFacade {

	@Autowired
	private WorkflowService service;
	
	public ResponseDTO getAllWorkflow() {
		List<WorkflowDTO> _workflowList = service.getAllWorkflow();
		return new ResponseDTO(null, _workflowList);
	}
	
}
