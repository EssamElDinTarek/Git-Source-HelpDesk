package com.sbm.helpdesk.service;

import java.util.List;
import javax.transaction.Transactional;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.common.dto.*;

@Transactional
public interface TeamService {
	
	public TeamDTO addTeam(TeamDTO teamDTO)throws BusinessException;
	public TeamDTO updateTeam(TeamDTO teamDTO)throws BusinessException;
	public String deleteTeam(Long teamId) throws BusinessException;
	public TeamDTO getByTeamId(Long teamId)throws BusinessException;
	public List<TeamDTO> getAllTeam() throws BusinessException;
	public List<WidgetDTO> getProjectTeamsandMembersCount(long projectId) throws BusinessException;
}
