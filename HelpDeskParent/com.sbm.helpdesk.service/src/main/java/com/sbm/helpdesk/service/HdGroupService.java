package com.sbm.helpdesk.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.service.dto.HdgroupDTO;
import com.sbm.helpdesk.service.dto.UserDTO;
import com.sbm.helpdesk.service.entity.Component;
import com.sbm.helpdesk.service.entity.Hdgroup;
import com.sbm.helpdesk.service.entity.Hduser;
import com.sbm.helpdesk.service.entity.Privilege;

@Transactional
public interface HdGroupService {
 public HdgroupDTO createGroup(String groupName) throws BusinessException;
 public void assignPrivilge(HdgroupDTO hdgroupDTO) throws BusinessException;
 public void assignSubcomponents(HdgroupDTO hdgroupDTO) throws BusinessException;
 public void assignComponents(List<Component> components) throws BusinessException;
 public void assignHdusers(List<Hduser> hdusers) throws BusinessException;
 public List<HdgroupDTO> listGroups() throws BusinessException;

}
