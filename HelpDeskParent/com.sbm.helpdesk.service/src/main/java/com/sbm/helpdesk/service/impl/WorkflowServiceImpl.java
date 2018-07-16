package com.sbm.helpdesk.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.service.dao.*;
import com.sbm.helpdesk.service.dto.*;
import com.sbm.helpdesk.service.entity.*;

@Service
public class WorkflowServiceImpl extends BasicServiceImpl<WorkflowDTO, Workflow> implements WorkflowService{
	
	@Autowired
	private WorkflowDao workflowDao;
	
		
	public WorkflowServiceImpl() {}


	@Override
	@Transactional
	public List<WorkflowDTO> getAllWorkflow() {
		List<Workflow> workflowList = workflowDao.findAll();
		List<WorkflowDTO> list = workflowList.stream().map(item -> convertToDTO(item, new WorkflowDTO())).collect(Collectors.toList());
		return list;
	}


}
