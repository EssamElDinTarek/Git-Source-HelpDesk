package com.sbm.helpdesk.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbm.helpdesk.common.constant.IntegrationServicesConstant;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.common.enums.servicesEnums.ServicesEnums;

@Service
public class TicketServiceImpl extends BasicServiceImpl<TicketDTO, Ticket> implements TicketService {

	@Autowired
	private TicketDao ticketDao;

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private WorkflowDao workflowDao;

	@Autowired
	private TicketSeverityDao severityDao;

	@Autowired
	private TicketPriorityDao priorityDao;
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	@Autowired
	private StepDao stepDao;
	
	@Autowired
	private StatusDao statusDao;
	
	@Resource
	private AttachmentService attachmentService;

	private Ticket ticket = new Ticket();

	public TicketServiceImpl() {
	}

	@Override
	@Transactional
	public TicketDTO addTicket(MultipartFile[] files, String ticketString) throws BusinessException {
		TicketDTO result = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			TicketDTO ticketdto = mapper.readValue(ticketString, new TypeReference<TicketDTO>() {});
			ticket = convertToEntity(ticket, ticketdto);
			Date date = new Date();
			Timestamp ts = new Timestamp(date.getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String ticketNumber = "Tic_" + sdf.format(ts) + String.format("%03d", new Random().nextInt(1000));
			ticket.setTicketnumber(ticketNumber);
			ticket.setStatus(statusDao.findById(1L));
			ticket.setStep(stepDao.findById(1L));
			ticket.setProject(projectDao.findById(ticket.getProject().getProjectId()));
			ticket.setTicketSeverity(severityDao.findById(ticket.getTicketSeverity().getSeverityId()));
			ticket.setTicketPriority(priorityDao.findById(ticket.getTicketPriority().getPrioprtiyId()));
			ticket.setWorkflow(workflowDao.findById(ticket.getWorkflow().getFlowId()));
			ticket = ticketDao.persist(ticket);
			attachmentService.saveAttachment(null, files, ticket);
			ticket = changeStepAndStatus(ticket);
			result = convertToDTO(ticket, ticketdto);
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}

	@Override
	@Transactional
	public Ticket updateTicket(Ticket ticket) throws BusinessException {
		Ticket result = null;
		try {
			
			ticket.setTicketSeverity(severityDao.findById(ticket.getTicketSeverity().getSeverityId()));
			ticket.setTicketPriority(priorityDao.findById(ticket.getTicketPriority().getPrioprtiyId()));
			ticket.setWorkflow(workflowDao.findById(ticket.getWorkflow().getFlowId()));
			result = ticketDao.update(ticket);
			
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}

	@Override
	@Transactional
	public TicketDTO updateTicket(MultipartFile[] files, String ticketString) throws BusinessException {
		TicketDTO result = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			TicketDTO ticketdto = mapper.readValue(ticketString, new TypeReference<TicketDTO>() {});
			ticket = convertToEntity(ticket, ticketdto);
			ticket = updateTicket(ticket);
			result = convertToDTO(ticket, ticketdto);
			String folderPath = IntegrationServicesConstant.ATTACHMENT_PATH+ticket.getTicketnumber()+"_attachment/";
			attachmentService.saveAttachment(null, files, ticket);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}

	
	@Override
	@Transactional
	public TicketDTO getByTicketNumber(String ticketnumber) throws BusinessException {
		TicketDTO result = null;
		try {
			TicketDTO ticketDTO = new TicketDTO();
			ticket = ticketDao.getByTicketNumber(ticketnumber);
			result = convertToDTO(ticket, ticketDTO);
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}

	@Override
	@Transactional
	public TicketDTO getByTicketId(Long ticketId) throws BusinessException {
		TicketDTO result;
		try {
			TicketDTO ticketDTO = new TicketDTO();
			ticket = ticketDao.findById(ticketId);
			result = convertToDTO(ticket, ticketDTO);
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}

	@Override
	@Transactional
	public List<TicketDTO> getTicketByProjectName(String projectName) throws BusinessException {
		List<TicketDTO> result;
		try {
			List<Ticket> ticketList = ticketDao.getByProjectName(projectName);
			result = ticketList.stream().map(item -> convertToDTO(item, new TicketDTO())).collect(Collectors.toList());
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}

	@Override
	@Transactional
	public List<TicketDTO> getByProjectIDAndUserName(long projectId, String userEmail) throws BusinessException {
		List<TicketDTO> result;
		try {
			List<Ticket> ticketList = ticketDao.getByProjectIDAndUserName(projectId, userEmail);
			result = ticketList.stream().map(item -> convertToDTO(item, new TicketDTO())).collect(Collectors.toList());
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}

	@Override
	@Transactional
	public String deleteTicket(Long id) throws BusinessException {
		String result = "";
		try {
			Ticket ticket = ticketDao.findById(id);
			ticket.setDeleted(1);
			result = "Sucess";
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}

	@Override
	@Transactional
	public List<HistoryDetailsDTO> getHistoryByTicketId(long ticketId) throws BusinessException {
		List<HistoryDetailsDTO> result;
		try {
			List<HistoryDetailsDTO> HistoryDetails = ticketDao.getHistoryByTicketId(ticketId);
			result = HistoryDetails;
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}
	
	@Transactional
	public Ticket changeStepAndStatus(Ticket ticket) throws RespositoryException, BusinessException{
		Iterator workflowstepsit = ticket.getWorkflow().getWorkflowSteps().iterator();
		Step step = null;
		//BigDecimal x =new BigDecimal(2);
		while (workflowstepsit.hasNext()) {
			WorkflowStep workflowstep = (WorkflowStep) workflowstepsit.next();
			//BigDecimal y = workflowstep.getStepOrder() ;
			if (workflowstep.getStepOrder().intValue() == 2) {
				step = workflowstep.getStep();
				break;
			}

		}
		ticket.setStatus(statusDao.findById(2L));
		ticket.setStep(stepDao.findById(step.getStepId()));
		ticket = updateTicket(ticket);
		return ticket;
	}
	
	@Override
	@Transactional
	public Ticket stepTicketForward(Ticket ticket) throws BusinessException {
		Ticket result = null;
		try {
			Integer stepIndex = null;
			List<WorkflowStep> workflowSteps = orderWorkFlowStepsList(ticket.getWorkflow().getWorkflowSteps());
			for(int i = 0 ; i < workflowSteps.size(); i++) {
			if(workflowSteps.get(i).getStep().getStepId() == ticket.getStep().getStepId()) {
				stepIndex = i;
				break;
			}
			}
			
			//Ticket Step doesn't exist in the assigned workFlow
			if (stepIndex == null)
				throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);	
			
			//Ticket Already Completed (Completed status = 3)
			if(ticket.getStatus().getStatusId() == 3)
				throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
			
			//Forwarding to Last Step
			if( (stepIndex + 1) == workflowSteps.size()) {
				ticket.setStatus(statusDao.findById(ServicesEnums.TICKET_STATUS_COMPLETED.getStringValue()));
			}else {
				//Forwarding From First Step to Second Step or Forwarding to any middle Steps
				ticket.setStatus(statusDao.findById(ServicesEnums.TICKET_STATUS_INPROGRESS.getStringValue()));
				ticket.setStep(workflowSteps.get(stepIndex + 1).getStep());
			}
			
			result = ticketDao.update(ticket);
			
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}
	
	@Override
	@Transactional
	public Ticket stepTicketBackward(Ticket ticket) throws BusinessException {
		Ticket result = null;
		try {
			Integer stepIndex = null;
			List<WorkflowStep> workflowSteps = orderWorkFlowStepsList(ticket.getWorkflow().getWorkflowSteps());
			for(int i = 0 ; i < workflowSteps.size(); i++) {
			if(workflowSteps.get(i).getStep().getStepId() == ticket.getStep().getStepId()) {
				stepIndex = i;
				break;
			}
			}
			
			//Ticket Step doesn't exist in the assigned workFlow
			if (stepIndex == null)
				throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);	
			
			//Error , Already in First Step
			if(stepIndex == 0)
				throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
			
			//Backward to First Step
			if(stepIndex == 1)
				ticket.setStatus(statusDao.findById(ServicesEnums.TICKET_STATUS_CREATED.getStringValue()));
			
			//Forwarding to middle Steps or Backward From Last Step
			ticket.setStatus(statusDao.findById(ServicesEnums.TICKET_STATUS_INPROGRESS.getStringValue()));
			ticket.setStep(workflowSteps.get(stepIndex - 1).getStep());
			result = ticketDao.update(ticket);
			
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}
	
	public List<WorkflowStep> orderWorkFlowStepsList(List<WorkflowStep> workflowSteps){
		HashMap<Integer, Integer> orderAndIndex = new HashMap<Integer, Integer>();
		List<WorkflowStep> sortedWorkflowStepsList = new ArrayList<WorkflowStep>();
		
		for(int i = 0 ; i < workflowSteps.size(); i++)
			orderAndIndex.put(workflowSteps.get(i).getStepOrder().intValue(),i);
		
	      TreeMap<Integer, Integer> sorted = new TreeMap<Integer, Integer>();
	        sorted.putAll(orderAndIndex);
	 
	        for (Map.Entry<Integer, Integer> entry : sorted.entrySet())
	        	sortedWorkflowStepsList.add(workflowSteps.get(entry.getValue()));
	        
	        return sortedWorkflowStepsList;
		
	}
}
