package com.sbm.helpdesk.service.facade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.ControllerException;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.service.dto.*;

@Service
public class GroupServiceFacade {
	 @Autowired
	 private  HdGroupService service;
	 
	 public ResponseDTO creatGroup(HdgroupDTO hdgroup) throws ControllerException{
		 ResponseDTO result = null;
		 try {
			HdgroupDTO newHdgroup = service.createGroup(hdgroup.getGroupName());
			result = new ResponseDTO(null, newHdgroup);
		 }catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
		}
	 
	 public ResponseDTO assignPrivilge(HdgroupDTO hdgroup) throws ControllerException{
		 ResponseDTO result = null;
		 try {
		  service.assignPrivilge(hdgroup);
		  result = new ResponseDTO(null,true);
		 }catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
		}
	 
	 public ResponseDTO assignGroupSubcomponents( HdgroupDTO hdgroupDTO) throws ControllerException{
		 ResponseDTO result = null;
		 try {
		  service.assignSubcomponents(hdgroupDTO); 
		  result = new ResponseDTO(null,true);
		 }catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
		}
	 public ResponseDTO getAllUsers() throws ControllerException {
		 ResponseDTO result = null;
		 try {
		 result = new ResponseDTO(null,service.listGroups()) ;
		 }catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
		}
	 
}
