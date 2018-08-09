package com.sbm.helpdesk.persistence.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.sbm.helpdesk.common.dto.ProjectDBDetailsDTO;
import com.sbm.helpdesk.common.dto.WidgetDTO;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;

@Repository
public class ProjectDaoImpl extends GenericDaoImpl<Project> implements ProjectDao {

	
	@Override
	public Project getProjectByName(String projectName) throws RespositoryException {
		Project result = null;
		try{
			Query query = this.entityManager.createNamedQuery("Project.findProjectByName",Project.class);
			query.setParameter("arg1", projectName);
			result = (Project) query.getSingleResult();
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return result;
		
	}
	@Override
	public List<ProjectDBDetailsDTO> getDashBoardProject(long portfolioId) throws RespositoryException {
		List<ProjectDBDetailsDTO> projectDBList = new ArrayList<ProjectDBDetailsDTO>();
		try{
			String sqlString = "select  * from (select * from PROJECT, PROJECT_STATUS  where PROJECT.PROJECT_STATUS_ID = PROJECT_STATUS.STATUS_ID and PROJECT.PORTFOLIO_ID = 1) , " + 
					"(Select PROJECT.PROJECT_ID as tab1, count(*) as USERCOUNT from HDUSER, TEAM, Project where HDUSER.PROJECT_ID = Project.PROJECT_ID and HDUSER.TEAM_ID = TEAM.REC_ID GROUP BY PROJECT.PROJECT_ID) ,( " + 
					"select PROJECT.PROJECT_ID as tab2, count(*) as TICKETCOUNT from PROJECT, TICKET where PROJECT.PROJECT_ID = TICKET.PROJECT_ID  GROUP BY PROJECT.PROJECT_ID) where PROJECT_ID = tab1 and PROJECT_ID =tab2";
			Query query = this.entityManager.createNativeQuery(sqlString);
			
			List<Object[]> list =(List<Object[]>) query.getResultList();
			for (Object[] a : list) {
				ProjectDBDetailsDTO projectDB = new ProjectDBDetailsDTO();
				projectDB.setProjectId(Long.parseLong(a[0].toString()));
				projectDB.setName(a[1].toString());
				projectDB.setStatus(a[6].toString());
				projectDB.setUserCount(Long.parseLong(a[8].toString()));
				projectDB.setTicketCount(Long.parseLong(a[10].toString()));
				projectDBList.add(projectDB);
				}
			
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return projectDBList;
	}
	
	@Override
	public List<Project> getProjectsByPortfolioId(Long portfolioId) throws RespositoryException {
		List<Project> result = null;
		try{
			TypedQuery<Project> query = this.entityManager.createNamedQuery("Project.findProjectByPortfolioId",Project.class);
			query.setParameter("portfolioId", portfolioId);
			result = query.getResultList();
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return result;
		
	}
}
