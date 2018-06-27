package com.sbm.helpdesk.service;


import java.util.List;

import com.sbm.helpdesk.dto.HdgroupDTO;
import com.sbm.helpdesk.dto.UserDTO;
import com.sbm.helpdesk.entity.Component;
import com.sbm.helpdesk.entity.GroupSubcomponent;
import com.sbm.helpdesk.entity.Hdgroup;
import com.sbm.helpdesk.entity.Hduser;
import com.sbm.helpdesk.entity.Privilege;

public interface HdGroupService {
 public HdgroupDTO createGroup(String groupName);
 public HdgroupDTO assignPrivilge(HdgroupDTO hdgroupDTO);
 public HdgroupDTO assignGroupSubcomponents(List<GroupSubcomponent> groupSubcomponents);
 public HdgroupDTO assignComponents(List<Component> components);
 public HdgroupDTO assignHdusers(List<Hduser> hdusers);
 public List<HdgroupDTO> listGroups();

}
