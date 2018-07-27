package com.sbm.helpdesk.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;
import com.sbm.helpdesk.common.dto.*;

@Service
public class GroupServiceImpl  extends BasicServiceImpl<HdgroupDTO, Hdgroup>  implements HdGroupService {

    @Autowired
    private HdgroupDao hdgroupDao;

       
    @Override
    @Transactional
	public HdgroupDTO createGroup(String groupName) throws BusinessException {
    	HdgroupDTO result = null;
    	try{
    	Hdgroup newHdGroup = new Hdgroup(groupName);
    	hdgroupDao.persist(newHdGroup);
    	HdgroupDTO hdgroupDTO = new HdgroupDTO();
		result = convertToDTO(newHdGroup, hdgroupDTO);
    	}catch(RespositoryException e) {
    		e.printStackTrace();
    		throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
    	}
    	catch(Exception e1) {
    		e1.printStackTrace();
        	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
        	}
    	return result;
	}

	@Override
	@Transactional
	public void assignPrivilge(HdgroupDTO hdgroupDTO) throws BusinessException {
		try {
		Hdgroup group = hdgroupDao.findById(hdgroupDTO.getGroupId());
		group.setPrivilege(new Privilege(hdgroupDTO.getPrivilege().getPrivilegeId()));
		hdgroupDao.update(group);
		}catch(RespositoryException e) {
    		e.printStackTrace();
    		throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
    		e1.printStackTrace();
        	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
        	}
	}

	@Override
	@Transactional
	public void assignSubcomponents(HdgroupDTO hdgroupDTO ) throws BusinessException {
	 
		try {
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
		
		}catch(RespositoryException e) {
    		e.printStackTrace();
    		throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
    		e1.printStackTrace();
        	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
        	}
	}

	@Override
	@Transactional
	public void assignComponents(List<Component> components) throws BusinessException{
		// TODO Auto-generated method stub
	}

	@Override
	
	public void assignHdusers(List<Hduser> hdusers) throws BusinessException{
		// TODO Auto-generated method stub
	}

	@Override
	@Transactional
	public List<HdgroupDTO> listGroups() throws BusinessException {
		List<HdgroupDTO> result;
		try {
		List<Hdgroup> hdgroups =  hdgroupDao.findAll();
		result =  hdgroups.stream().
				map( item ->{
					return convertToDTO(item, new HdgroupDTO());
					}).collect(Collectors.toList());
		}catch(RespositoryException e) {
    		e.printStackTrace();
    		throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
    		e1.printStackTrace();
        	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
        	}
		return result;
	}
}