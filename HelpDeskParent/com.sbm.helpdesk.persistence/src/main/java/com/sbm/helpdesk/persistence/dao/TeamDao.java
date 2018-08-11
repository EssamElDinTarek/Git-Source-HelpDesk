package com.sbm.helpdesk.persistence.dao;

import java.util.List;

import com.sbm.helpdesk.common.dto.WidgetDTO;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.entity.*;

public interface TeamDao extends GenericDao<Team> {

	public List<WidgetDTO> getProjectTeamsandMembersCount(long projectId) throws RespositoryException;
}
