package com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller;

import javax.annotation.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.sbm.helpdesk.common.constant.IntegrationServicesConstant;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.service.facade.*;
import com.sbm.helpdesk.common.exceptions.types.ControllerException;

@RestController
@RequestMapping("/api/portfolio")
@CrossOrigin("*")
public class PortfolioRestController {

	@Resource
	private PortfolioServiceFacade facadeService;
	

	@RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO addPortfolio(@RequestBody PortfolioDTO portfolioDTO) throws ControllerException {
			return facadeService.addPortfolio(portfolioDTO);
	}
	@RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO updatePortfolio(@RequestBody PortfolioDTO portfolioDTO) throws ControllerException {
			return facadeService.updatePortfolio(portfolioDTO);
	}
	@RequestMapping( method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllPortfolio() throws ControllerException {
			return facadeService.getAllPortfolio();
	}
	@RequestMapping(value="/{"+IntegrationServicesConstant.PORTFOLIO_ID+"}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO deletePortfolio(@PathVariable(IntegrationServicesConstant.PORTFOLIO_ID) Long portfolioId) throws ControllerException {
			return facadeService.deletePortfolioById(portfolioId);
	}
	@RequestMapping(value="/{"+IntegrationServicesConstant.PORTFOLIO_ID+"}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getPortfolioById(@PathVariable(IntegrationServicesConstant.PORTFOLIO_ID) Long portfolioId) throws ControllerException {
			return facadeService.getPortfolioById(portfolioId);
	}

}
