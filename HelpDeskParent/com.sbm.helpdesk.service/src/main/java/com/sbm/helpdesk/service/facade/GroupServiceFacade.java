package com.sbm.helpdesk.service.facade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.service.dto.*;

@Service
public class GroupServiceFacade {
	 @Autowired
	 private  HdGroupService service;
	 
	 public ResponseDTO creatGroup(HdgroupDTO hdgroup){
			HdgroupDTO newHdgroup = service.createGroup(hdgroup.getGroupName());
					return new ResponseDTO(null, newHdgroup);
		}
	 
	 public ResponseDTO assignPrivilge(HdgroupDTO hdgroup){
		  service.assignPrivilge(hdgroup);
		  return new ResponseDTO(null,true);
		}
	 
	 public ResponseDTO assignGroupSubcomponents( HdgroupDTO hdgroupDTO){
		  service.assignSubcomponents(hdgroupDTO); 
		  return new ResponseDTO(null,true);
		}
	 public ResponseDTO getAllUsers() {
		 return new ResponseDTO(null,service.listGroups()) ;
		}
	 
}
