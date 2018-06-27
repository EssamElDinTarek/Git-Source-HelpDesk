package com.sbm.helpdesk.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.helpdesk.dao.HdgroupDao;
import com.sbm.helpdesk.dao.UserDao;
import com.sbm.helpdesk.dto.HdgroupDTO;
import com.sbm.helpdesk.dto.UserDTO;
import com.sbm.helpdesk.entity.Component;
import com.sbm.helpdesk.entity.GroupSubcomponent;
import com.sbm.helpdesk.entity.Hdgroup;
import com.sbm.helpdesk.entity.Hduser;
import com.sbm.helpdesk.entity.Privilege;
import com.sbm.helpdesk.service.HdGroupService;;

@Service
public class GroupServiceImpl  extends BasicServiceImpl<HdgroupDTO, Hdgroup>  implements HdGroupService {

    @Autowired
    private HdgroupDao hdgroupDao;

       
    @Override
    @Transactional
	public HdgroupDTO createGroup(String groupName) {
    	Hdgroup newHdGroup = new Hdgroup(groupName);
    	hdgroupDao.persist(newHdGroup);
    	HdgroupDTO hdgroupDTO = new HdgroupDTO();
    	
		return convertToDTO(newHdGroup, hdgroupDTO);
	}

	@Override
	@Transactional
	public HdgroupDTO assignPrivilge(HdgroupDTO hdgroupDTO) {
		Hdgroup group = hdgroupDao.findById(hdgroupDTO.getGroupId());
		group.setPrivilege(new Privilege(hdgroupDTO.getPrivilege().getPrivilegeId()));

		hdgroupDao.update(group);
		return convertToDTO(group, hdgroupDTO);
	}

	@Override
	@Transactional
	public HdgroupDTO assignGroupSubcomponents(List<GroupSubcomponent> groupSubcomponents) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public HdgroupDTO assignComponents(List<Component> components) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public HdgroupDTO assignHdusers(List<Hduser> hdusers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HdgroupDTO> listGroups() {
		List<Hdgroup> hdgroups =  hdgroupDao.findAll();
		List<HdgroupDTO> userDtoList =  hdgroups.stream().
				map(item -> convertToDTO(item, new HdgroupDTO())).collect(Collectors.toList());
		return userDtoList;
	}
}