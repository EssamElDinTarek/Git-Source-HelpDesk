package com.sbm.helpdesk.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;
import com.sbm.helpdesk.common.dto.*;

@Service
public class TeamServiceImpl extends BasicServiceImpl<TeamDTO, Team> implements TeamService{
	
	
	@Autowired
	private TeamDao dao;
	private Team team = new Team();
	
	@Override
	@Transactional
	public TeamDTO addTeam(TeamDTO teamDTO) throws BusinessException {
		team = convertToEntity(team, teamDTO);
		try {
			team = dao.persist(team);
		} catch (RespositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convertToDTO(team, teamDTO);
	}
	@Override
	@Transactional
	public TeamDTO updateTeam(TeamDTO teamDTO) throws BusinessException {
		try {
			team = convertToEntity(team, teamDTO);
			team = dao.update(team);
		
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return  convertToDTO(team, teamDTO);
	}
	
	@Override
	@Transactional
	public String deleteTeam(Long id) throws BusinessException {
		String result = "";
		try {
			team= dao.findById(id);
			team.setDeleted(1);
		result = "Sucess";
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
	public List<TeamDTO> getAllTeam() throws BusinessException {
		List<TeamDTO> result;
		try {
		List<Team> teamList = dao.findAll();
		result = teamList.stream().map(item -> convertToDTO(item, new TeamDTO())).collect(Collectors.toList());
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
	public TeamDTO getByTeamId(Long teamId) throws BusinessException {
		TeamDTO teamDTO = new TeamDTO();
		try {
			team = dao.findById(teamId);
			teamDTO = convertToDTO(team, teamDTO);
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return teamDTO;
	}
	public List<WidgetDTO> getProjectTeamsandMembersCount(long projectId) throws BusinessException{
		List<WidgetDTO> result;
		try {
			 result = dao.getProjectTeamsandMembersCount(projectId);
		
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
