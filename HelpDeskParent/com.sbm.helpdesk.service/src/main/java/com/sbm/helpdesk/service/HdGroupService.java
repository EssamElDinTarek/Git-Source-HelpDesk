package com.sbm.helpdesk.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.persistence.entity.*;
import com.sbm.helpdesk.common.dto.*;

@Transactional
public interface HdGroupService {
 public HdgroupDTO createGroup(String groupName) throws BusinessException;
 public void assignPrivilge(HdgroupDTO hdgroupDTO) throws BusinessException;
 public void assignSubcomponents(HdgroupDTO hdgroupDTO) throws BusinessException;
 public void assignComponents(List<Component> components) throws BusinessException;
 public void assignHdusers(List<Hduser> hdusers) throws BusinessException;
 public List<HdgroupDTO> listGroups() throws BusinessException;

}
