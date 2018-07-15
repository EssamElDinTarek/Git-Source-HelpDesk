package com.sbm.helpdesk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.helpdesk.dao.*;
import com.sbm.helpdesk.dto.*;
import com.sbm.helpdesk.entity.*;
import com.sbm.helpdesk.service.*;

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
