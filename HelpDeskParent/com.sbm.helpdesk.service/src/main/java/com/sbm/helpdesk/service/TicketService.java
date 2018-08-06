package com.sbm.helpdesk.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.web.multipart.MultipartFile;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.entity.Ticket;
import com.sbm.helpdesk.common.dto.*;

@Transactional
public interface TicketService {
	
	public TicketDTO addTicket(MultipartFile[] files, String ticket) throws BusinessException;
	public TicketDTO updateTicket(MultipartFile[] files, String ticket) throws BusinessException;
	public Ticket updateTicket(Ticket ticket) throws BusinessException;
	
	public TicketDTO getByTicketNumber(String ticketnumber) throws BusinessException;
	public TicketDTO getByTicketId(Long ticketId) throws BusinessException;
	public List<TicketDTO> getTicketByProjectName(String projectName) throws BusinessException;
	public String deleteTicket(Long id) throws BusinessException;
	public List<TicketDTO> getByProjectIDAndUserName(long projectId,String userEmail) throws BusinessException;
	public List<TicketDTO> getByWorkflowIDAndUserName(long workflowId,String userEmail) throws BusinessException;
	public List<HistoryDetailsDTO> getHistoryByTicketId(long ticketId) throws BusinessException;
	public TicketDTO stepTicketForward(long ticketId) throws BusinessException;
	public TicketDTO stepTicketBackward(long ticketId) throws BusinessException;
	public MainTicketChartDTO getSeverityPriorityStatusByUserName(String userEmail) throws BusinessException;
}
