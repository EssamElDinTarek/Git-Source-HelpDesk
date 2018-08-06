package com.sbm.helpdesk.service;

import java.util.List;
import javax.transaction.Transactional;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.dto.*;

@Transactional
public interface StepService {
	public StepDTO addStep(StepDTO stepDTO)throws BusinessException;
	public StepDTO updateStep(StepDTO stepDTO)throws BusinessException;
	public String deleteStep(Long stepid) throws BusinessException;
	public StepDTO getByStepId(Long stepId)throws BusinessException;
	public List<StepDTO> getAllStep() throws BusinessException;
}
