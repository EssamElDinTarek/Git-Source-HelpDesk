package com.sbm.helpdesk.persistence.dao;


import java.util.*;

import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.entity.*;
import com.sbm.helpdesk.common.dto.*;

public interface TicketDao extends GenericDao<Ticket> {

	
	public Ticket getByTicketNumber(String ticketnumber) throws RespositoryException;
	public List<Ticket> getByProjectName(String projectName) throws RespositoryException;
	public List<Ticket> getByProjectIDAndUserName(long projectId,String userEmail) throws RespositoryException;
	List<HistoryDetailsDTO> getHistoryByTicketId(long ticketId) throws RespositoryException;
	public MainTicketChartDTO getSeverityPriorityStatusByUserName(String userEmail) throws RespositoryException ;
	public List<Ticket> getByWorkflowIDAndUserName(long workflowId,String userEmail) throws RespositoryException;
	public List<WidgetDTO> getDashBoardCountByProjectIDAndUserName(long projectId,String userEmail) throws RespositoryException;
	public List<WidgetDTO> getWeekChartStatusesNumber(long projectId) throws RespositoryException;
}
