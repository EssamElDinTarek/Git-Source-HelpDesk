package com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller;


import javax.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.service.dto.*;
import com.sbm.helpdesk.service.facade.*;

@RestController
@RequestMapping("/api/group")
@CrossOrigin("*")
public class GroupRestController {

	
	@Resource
	private GroupServiceFacade facadeService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO creatGroup(@RequestBody HdgroupDTO hdgroup){
		return facadeService.creatGroup(hdgroup);
	}
	
	@RequestMapping(value = "/assignPrivilge", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO assignPrivilge(@RequestBody HdgroupDTO hdgroup){
		return facadeService.assignPrivilge(hdgroup);
	}
	
	@RequestMapping(value = "/assignSubcomponents", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO assignGroupSubcomponents(@RequestBody HdgroupDTO hdgroupDTO){
		return facadeService.assignGroupSubcomponents(hdgroupDTO); 
	}
//	
//	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<BaseDTO> login(@RequestBody Map<String, String> map) {
//		return dtoProvider.getObj((UserDTO) service.login(map.get("email"), map.get("password")));
//	}
//	
	@RequestMapping(value = "/", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllUsers() {
		return facadeService.getAllUsers();
	}
}
