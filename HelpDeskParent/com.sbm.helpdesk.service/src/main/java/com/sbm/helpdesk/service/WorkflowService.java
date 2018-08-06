package com.sbm.helpdesk.service;

import java.util.List;
import javax.transaction.Transactional;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.dto.*;

@Transactional
public interface WorkflowService {
	
	public WorkflowDTO addWorkflow(WorkflowDTO workflowDTO)throws BusinessException;
	public WorkflowDTO updateWorkflow(WorkflowDTO workflowDTO)throws BusinessException;
	public String deleteWorkflow(Long workflowId) throws BusinessException;
	public WorkflowDTO getByWorkflowId(Long workflowId)throws BusinessException;
	public List<WorkflowDTO> getAllWorkflow() throws BusinessException;
}
