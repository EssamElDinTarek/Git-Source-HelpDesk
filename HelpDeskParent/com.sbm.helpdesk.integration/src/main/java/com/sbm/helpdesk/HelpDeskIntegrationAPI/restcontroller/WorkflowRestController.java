package com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller;

import javax.annotation.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.sbm.helpdesk.common.constant.IntegrationServicesConstant;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.service.facade.*;
import com.sbm.helpdesk.common.exceptions.types.ControllerException;

@RestController
@RequestMapping("/api/workflow")
@CrossOrigin("*")
public class WorkflowRestController {

	@Resource
	private WorkflowServiceFacade facadeService;

	@RequestMapping( method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllWorkflow() throws ControllerException{
			return facadeService.getAllWorkflow();
	}
	@RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO addWorkflow(@RequestBody WorkflowDTO workflowDTO) throws ControllerException {
			return facadeService.addWorkflow(workflowDTO);
	}
	@RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO updateWorkflow(@RequestBody WorkflowDTO workflowDTO) throws ControllerException {
			return facadeService.updateWorkflow(workflowDTO);
	}
	
	@RequestMapping(value="/{"+IntegrationServicesConstant.WORKFLOW_ID+"}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO deleteWorkflow(@PathVariable(IntegrationServicesConstant.WORKFLOW_ID) Long workflowId) throws ControllerException {
			return facadeService.deleteWorkflowById(workflowId);
	}
	@RequestMapping(value="/{"+IntegrationServicesConstant.WORKFLOW_ID+"}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getWorkflowById(@PathVariable(IntegrationServicesConstant.WORKFLOW_ID) Long workflowId) throws ControllerException {
			return facadeService.getWorkflowById(workflowId);
	}
	

}
