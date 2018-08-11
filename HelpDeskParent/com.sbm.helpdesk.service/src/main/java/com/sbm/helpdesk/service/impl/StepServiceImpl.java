package com.sbm.helpdesk.service.impl;

import java.util.List;
import java.util.stream.Collectors;
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
public class StepServiceImpl extends BasicServiceImpl<StepDTO, Step> implements StepService{
	
	
	@Autowired
	private StepDao dao;
	
	private Step step = new Step();
	@Override
	public StepDTO addStep(StepDTO stepDTO) throws BusinessException {
		step = convertToEntity(step, stepDTO);
		try {
			step = dao.persist(step);
		} catch (RespositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convertToDTO(step, stepDTO);
	}
	@Override
	public StepDTO updateStep(StepDTO stepDTO) throws BusinessException {
		try {
			step = convertToEntity(step, stepDTO);
			step = dao.update(step);
		
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return  convertToDTO(step, stepDTO);
	}
	
	@Override
	public String deleteStep(Long id) throws BusinessException {
		String result = "";
		try {
			step= dao.findById(id);
			step.setDeleted(1);
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
	public StepDTO getByStepId(Long stepId) throws BusinessException {
		StepDTO stepDTO = new StepDTO();
		try {
			step = dao.findById(stepId);
			stepDTO = convertToDTO(step, stepDTO);
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return stepDTO;
	}
	@Override
	public List<StepDTO> getAllStep() throws BusinessException {
		List<StepDTO> result;
		try {
		List<Step> stepList = dao.findAll();
		result = stepList.stream().map(item -> convertToDTO(item, new StepDTO())).collect(Collectors.toList());
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
