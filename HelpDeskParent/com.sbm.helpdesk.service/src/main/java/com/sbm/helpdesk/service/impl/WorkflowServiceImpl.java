package com.sbm.helpdesk.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;
import com.sbm.helpdesk.common.dto.*;

@Service
public class WorkflowServiceImpl extends BasicServiceImpl<WorkflowDTO, Workflow> implements WorkflowService{
	
	@Autowired
	private WorkflowDao dao;

	private Workflow workflow = new Workflow();
	
	@Override
	public WorkflowDTO addWorkflow(WorkflowDTO workflowDTO) throws BusinessException {
		workflow = convertToEntity(workflow, workflowDTO);
		try {
			workflow = dao.persist(workflow);
		} catch (RespositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convertToDTO(workflow, workflowDTO);
	}
	@Override
	public WorkflowDTO updateWorkflow(WorkflowDTO workflowDTO) throws BusinessException {
		try {
			workflow = convertToEntity(workflow, workflowDTO);
			workflow = dao.update(workflow);
		
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return  convertToDTO(workflow, workflowDTO);
	}
	
	@Override
	public String deleteWorkflow(Long id) throws BusinessException {
		String result = "";
		try {
			workflow= dao.findById(id);
			workflow.setDeleted(1);
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
	public WorkflowDTO getByWorkflowId(Long workflowId) throws BusinessException {
		WorkflowDTO workflowDTO = new WorkflowDTO();
		try {
			workflow = dao.findById(workflowId);
			workflowDTO = convertToDTO(workflow, workflowDTO);
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return workflowDTO;
	}
	@Override
	@Transactional
	public List<WorkflowDTO> getAllWorkflow() throws BusinessException {
		List<WorkflowDTO> result;
		try {
		List<Workflow> workflowList = dao.findAll();
		result = workflowList.stream().map(item -> convertToDTO(item, new WorkflowDTO())).collect(Collectors.toList());
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
