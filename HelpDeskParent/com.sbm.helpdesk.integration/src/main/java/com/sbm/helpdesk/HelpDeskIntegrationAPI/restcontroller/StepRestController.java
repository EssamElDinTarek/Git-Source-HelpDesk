package com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller;

import javax.annotation.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.sbm.helpdesk.common.constant.IntegrationServicesConstant;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.service.facade.*;
import com.sbm.helpdesk.common.exceptions.types.ControllerException;

@RestController
@RequestMapping("/api/step")
@CrossOrigin("*")
public class StepRestController {

	@Resource
	private StepServiceFacade facadeService;
	

	@RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO addStep(@RequestBody StepDTO stepDTO) throws ControllerException {
			return facadeService.addStep(stepDTO);
	}
	@RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO updateStep(@RequestBody StepDTO stepDTO) throws ControllerException {
			return facadeService.updateStep(stepDTO);
	}
	@RequestMapping( method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllStep() throws ControllerException {
			return facadeService.getAllStep();
	}
	@RequestMapping(value="/{"+IntegrationServicesConstant.STEP_ID+"}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO deleteStep(@PathVariable(IntegrationServicesConstant.STEP_ID) Long stepId) throws ControllerException {
			return facadeService.deleteStepById(stepId);
	}
	@RequestMapping(value="/{"+IntegrationServicesConstant.STEP_ID+"}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getStepById(@PathVariable(IntegrationServicesConstant.STEP_ID) Long stepId) throws ControllerException {
			return facadeService.getStepById(stepId);
	}

}
