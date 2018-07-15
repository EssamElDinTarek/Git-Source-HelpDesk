package com.sbm.helpdesk.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sbm.helpdesk.dto.HdgroupDTO;
import com.sbm.helpdesk.dto.UserDTO;
import com.sbm.helpdesk.entity.Component;
 
import com.sbm.helpdesk.entity.Hdgroup;
import com.sbm.helpdesk.entity.Hduser;
import com.sbm.helpdesk.entity.Privilege;

@Transactional
public interface HdGroupService {
 public HdgroupDTO createGroup(String groupName);
 public void assignPrivilge(HdgroupDTO hdgroupDTO);
 public void assignSubcomponents(HdgroupDTO hdgroupDTO);
 public void assignComponents(List<Component> components);
 public void assignHdusers(List<Hduser> hdusers);
 public List<HdgroupDTO> listGroups();

}
