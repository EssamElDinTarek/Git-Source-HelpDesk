package com.sbm.helpdesk.persistence.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sbm.helpdesk.common.dto.WidgetDTO;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;

@Repository
public class TeamDaoImpl extends GenericDaoImpl<Team> implements TeamDao {

	
	@Override
	public List<WidgetDTO> getProjectTeamsandMembersCount(long projectId) throws RespositoryException {
		List<WidgetDTO> widgetDTOList = new ArrayList<WidgetDTO>();
		try{
			String sqlString = "select count(*), TEAM.TEAM_NAME FROM TEAM, PROJECT , HDUSER where PROJECT.PROJECT_ID = HDUSER.PROJECT_ID and HDUSER.TEAM_ID = TEAM.REC_ID and PROJECT.PROJECT_ID = ? GROUP BY TEAM.REC_ID,TEAM.TEAM_NAME ";
			Query query = this.entityManager.createNativeQuery(sqlString);
			query.setParameter(1, projectId);
			List<Object[]> list =(List<Object[]>) query.getResultList();
			for (Object[] a : list) {
				WidgetDTO widgetdto = new WidgetDTO();
				widgetdto.setName(a[1].toString());
				widgetdto.setValue(Long.parseLong(a[0].toString()));
				widgetDTOList.add(widgetdto);
				}
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return widgetDTOList;
		
	}
}
