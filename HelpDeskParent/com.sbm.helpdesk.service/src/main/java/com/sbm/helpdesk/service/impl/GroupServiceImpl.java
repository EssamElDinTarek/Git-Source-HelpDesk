package com.sbm.helpdesk.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.service.dao.*;
import com.sbm.helpdesk.service.dto.*;
import com.sbm.helpdesk.service.entity.*;;

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
	public void assignPrivilge(HdgroupDTO hdgroupDTO) {
		Hdgroup group = hdgroupDao.findById(hdgroupDTO.getGroupId());
		group.setPrivilege(new Privilege(hdgroupDTO.getPrivilege().getPrivilegeId()));

		hdgroupDao.update(group);
	}

	@Override
	@Transactional
	public void assignSubcomponents(HdgroupDTO hdgroupDTO ) {
	 
		
		Hdgroup group = hdgroupDao.findById(hdgroupDTO.getGroupId());
		
		
		List<SubcomponentDTO> subcomponentsDTO = hdgroupDTO.getSubcomponents();
		Hdgroup hdGroup = convertToEntity(new Hdgroup(), hdgroupDTO);
//		List<Subcomponent> subcomponents = 
//				subcomponentsDTO.stream()
//				.map(itemDto -> subcomponentConverter.convertToEntity(new Subcomponent() ,itemDto ))
//							.collect(Collectors.toList());
//		
		
		group.getSubcomponents().clear();
		group.getSubcomponents().addAll(hdGroup.getSubcomponents());
		hdgroupDao.update(group);
		
	}

	@Override
	@Transactional
	public void assignComponents(List<Component> components) {
		// TODO Auto-generated method stub
	}

	@Override
	
	public void assignHdusers(List<Hduser> hdusers) {
		// TODO Auto-generated method stub
	}

	@Override
	@Transactional
	public List<HdgroupDTO> listGroups() {
		List<Hdgroup> hdgroups =  hdgroupDao.findAll();
		List<HdgroupDTO> userDtoList =  hdgroups.stream().
				map( item ->{
					return convertToDTO(item, new HdgroupDTO());
					}).collect(Collectors.toList());
		return userDtoList;
	}
}