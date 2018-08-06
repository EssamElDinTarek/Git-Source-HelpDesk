package com.sbm.helpdesk.persistence.dao.impl;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.*;
import org.springframework.stereotype.Repository;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;
import com.sbm.helpdesk.common.dto.*;

@Repository
public class TicketDaoImpl extends GenericDaoImpl<Ticket> implements TicketDao {

	
	@Override
	public Ticket getByTicketNumber(String ticketnumber) throws RespositoryException {
		Ticket result = null;
		try{
			Query query = this.entityManager.createNamedQuery("Ticket.findByTicketNumber",Ticket.class);
			query.setParameter("arg1", ticketnumber);
			result = (Ticket) query.getSingleResult();
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return result;
		
	}
	@Override
	public List<Ticket> getByProjectName(String projectName) throws RespositoryException {
		List<Ticket> result;
		try{
			Query query = this.entityManager.createNamedQuery("Ticket.findByProjectName",Ticket.class);
			query.setParameter("arg1", projectName);
			result = query.getResultList();
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return result;
		
	}
	@Override
	public List<Ticket> getByProjectIDAndUserName(long projectId,String userEmail) throws RespositoryException {
		List<Ticket> result;
		try{
			String sqlString = "select TICKET.* FROM TICKET, PROJECT,TEAM, STEPS,HDUSER where"
					+ " TICKET.PROJECT_ID = PROJECT.PROJECT_ID and ticket.step_id = STEPS.STEP_ID and STEPS.TEAM_ID = TEAM.REC_ID "
					+ "and HDUSER.TEAM_ID =TEAM.REC_ID and PROJECT.PROJECT_ID = ? and  HDUSER.EMAIL_ADDRESS = ?";
			Query query = this.entityManager.createNativeQuery(sqlString,Ticket.class);
			query.setParameter(1, projectId);
			query.setParameter(2, userEmail);
			result = query.getResultList();
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return result;
		
	}
	@Override
	public List<Ticket> getByWorkflowIDAndUserName(long workflowId,String userEmail) throws RespositoryException {
		List<Ticket> result;
		try{
			String sqlString = "select TICKET.* FROM TICKET, PROJECT,TEAM, STEPS,HDUSER where"
					+ " TICKET.PROJECT_ID = PROJECT.PROJECT_ID and ticket.step_id = STEPS.STEP_ID and STEPS.TEAM_ID = TEAM.REC_ID "
					+ "and HDUSER.TEAM_ID =TEAM.REC_ID and TICKET.WORKFLOW_ID = ? and  HDUSER.EMAIL_ADDRESS = ?";
			Query query = this.entityManager.createNativeQuery(sqlString,Ticket.class);
			query.setParameter(1, workflowId);
			query.setParameter(2, userEmail);
			result = query.getResultList();
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return result;
		
	}
	@Override
	public MainTicketChartDTO getSeverityPriorityStatusByUserName(String userEmail) throws RespositoryException {
		List<WidgetDTO> resultStatus =new ArrayList<WidgetDTO>();
		List<WidgetDTO> resultSeverity =new ArrayList<WidgetDTO>();
		List<WidgetDTO> resultPriority =new ArrayList<WidgetDTO>();
		MainTicketChartDTO chartDTO = new MainTicketChartDTO();
		try{
			String sqlStatusString = "select count(*) , STATUS.STATUS  FROM TICKET , TEAM, STEPS , WORKFLOW_STEPS, HDUSER,STATUS where TICKET.STATUS_ID = STATUS.STATUS_ID and" + 
					"  STEPS.TEAM_ID = TEAM.REC_ID and WORKFLOW_STEPS.STEP_ID = STEPS.STEP_ID and TICKET.WORKFLOW_ID = WORKFLOW_STEPS.FLOW_ID " + 
					"and HDUSER.TEAM_ID =TEAM.REC_ID  and  HDUSER.EMAIL_ADDRESS = ?   GROUP BY STATUS.STATUS";
			String sqlSeverityString = "select count(*)  , TICKET_SEVERITY.SEVERITY_NAME  FROM TICKET , TEAM, STEPS , WORKFLOW_STEPS, HDUSER,TICKET_SEVERITY where   " + 
					"   STEPS.TEAM_ID = TEAM.REC_ID and WORKFLOW_STEPS.STEP_ID = STEPS.STEP_ID and TICKET.WORKFLOW_ID = WORKFLOW_STEPS.FLOW_ID " + 
					"and HDUSER.TEAM_ID =TEAM.REC_ID  and TICKET_SEVERITY.SEVERITY_ID= TICKET.SEVERITY_ID and HDUSER.EMAIL_ADDRESS = ?   GROUP BY  TICKET_SEVERITY.SEVERITY_NAME ";
			String sqlPriorityString = "select count(*) , TICKET_PRIORITY.PRIORITY_LEVEL  FROM TICKET , TEAM, STEPS , WORKFLOW_STEPS, HDUSER,TICKET_PRIORITY where  " + 
					"   STEPS.TEAM_ID = TEAM.REC_ID and WORKFLOW_STEPS.STEP_ID = STEPS.STEP_ID and TICKET.WORKFLOW_ID = WORKFLOW_STEPS.FLOW_ID " + 
					"and HDUSER.TEAM_ID =TEAM.REC_ID  and TICKET_PRIORITY.PRIOPRTIY_ID = TICKET.PRIORITY_ID and HDUSER.EMAIL_ADDRESS = ?   GROUP BY  TICKET_PRIORITY.PRIORITY_LEVEL ";
			
			Query querySeverity = this.entityManager.createNativeQuery(sqlSeverityString);
			querySeverity.setParameter(1, userEmail);
			Query queryPriority = this.entityManager.createNativeQuery(sqlPriorityString);
			queryPriority.setParameter(1, userEmail);
			Query queryStatus = this.entityManager.createNativeQuery(sqlStatusString);
			queryStatus.setParameter(1, userEmail);
			List<Object[]> statusList =(List<Object[]>) queryStatus.getResultList();
			List<Object[]> severityList =(List<Object[]>) querySeverity.getResultList();
			List<Object[]> priorityList =(List<Object[]>) queryPriority.getResultList();
			for (Object[] a : statusList) {
				WidgetDTO widgetdto = new WidgetDTO();
				widgetdto.setName(a[1].toString());
				widgetdto.setValue(Long.parseLong(a[0].toString()));
				resultStatus.add(widgetdto);
			}
			chartDTO.setStatus(resultStatus);
			for (Object[] a : severityList) {
				WidgetDTO widgetdto = new WidgetDTO();
				widgetdto.setName(a[1].toString());
				widgetdto.setValue(Long.parseLong(a[0].toString()));
				resultSeverity.add(widgetdto);
			}
			chartDTO.setSeverity(resultSeverity);
			for (Object[] a : priorityList) {
				WidgetDTO widgetdto = new WidgetDTO();
				widgetdto.setName(a[1].toString());
				widgetdto.setValue(Long.parseLong(a[0].toString()));
				resultPriority.add(widgetdto);
			}
			chartDTO.setPriority(resultPriority);
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return chartDTO;
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<HistoryDetailsDTO> getHistoryByTicketId(long ticketId) throws RespositoryException {
		List<HistoryDetailsDTO> historyDetails = new ArrayList<HistoryDetailsDTO>();
		try {
			String sql = "select 'Information' AS TYPE, COL_NAME, OLD_VALUE, NEW_VALUE, UPDATED_BY AS ACTION_BY, UPDATED_AT AS ACTION_AT, NULL AS BEHAVIOR_NAME, NULL AS BEHAVIOR_VALUE, NULL AS ID, TICKET_ID, STEP_ID FROM helpdesk.INFORMATIONAL_DETAILS " + 
					"UNION " + 
					"SELECT 'Behavior',NULL,NULL,NULL,ACTION_BY,ACTION_AT,BEHAVIOR_NAME,BEHAVIOR_VALUE,ID,TICKET_ID,STEP_ID FROM helpdesk.BEHAVIORAL_DETAILS WHERE TICKET_ID = ? ORDER BY ACTION_AT";
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter(1, ticketId);
	    	List<Object[]> details = query.getResultList();
	    	System.out.println("IN DAO: " + details.size());
	    	for (Object[] a : details) {
	    		HistoryDetailsDTO hD = new HistoryDetailsDTO();
	    		hD.setType((String)a[0]);
	    		hD.setColName((String)a[1]);
	    		hD.setOldValue((String)a[2]);
	    		hD.setNewValue((String)a[3]);
	    		hD.setActionBy((BigDecimal)a[4]);
	    		hD.setActionAt((Date)a[5]);
	    		hD.setBehaviorName((String)a[6]);
	    		hD.setBehaviorValue((String)a[7]);
	    		hD.setId((BigDecimal)a[8]);
	    		hD.setTicketId((BigDecimal)a[9]);
	    		hD.setStepId((BigDecimal)a[10]);
	    		historyDetails.add(hD);
	    	}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		   }
		return historyDetails;
	}
	
}
