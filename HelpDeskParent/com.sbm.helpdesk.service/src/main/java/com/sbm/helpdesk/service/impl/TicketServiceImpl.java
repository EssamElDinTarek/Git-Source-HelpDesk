package com.sbm.helpdesk.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.print.attribute.standard.Severity;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.common.mailer.*;
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
	private StepDao stepDao;
	
	@Autowired
	private StatusDao statusDao;
	
	@Autowired
	private UserDao userDao;
	
	@Resource
	private AttachmentService attachmentService;
	
	@Resource
	BehavioralDetailsService behavioralDetailsService;
	
	@Resource
	InformationalDetailsService informationalDetailsService;

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
			//Hduser hduser = userDao.findByEmail(ticket.getHduser().getEmailAddress());
			//Step step = stepDao.findById(1L);
			//Status status = statusDao.findById(1L);
			//Project project = projectDao.findById(ticket.getProject().getProjectId());
			//TicketSeverity severity = severityDao.findById(ticket.getTicketSeverity().getSeverityId());
			//TicketPriority priority = priorityDao.findById(ticket.getTicketPriority().getPrioprtiyId());
			//Workflow workflow = workflowDao.findById(ticket.getWorkflow().getFlowId());
			/*if(hduser == null || step == null || status == null || project == null || severity == null ||  priority == null ||  workflow == null  ) {
				throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
			}*/
			ticket.setTicketnumber(ticketNumber);
			ticket.setStatus(statusDao.findById(1L));
			ticket.setStep(stepDao.findById(1L));
			ticket.setHduser(userDao.findById(ticket.getHduser().getUserId()));
			ticket.setProject( projectDao.findById(ticket.getProject().getProjectId()));
			ticket.setTicketSeverity(severityDao.findById(ticket.getTicketSeverity().getSeverityId()));
			ticket.setTicketPriority(priorityDao.findById(ticket.getTicketPriority().getPrioprtiyId()));
			ticket.setWorkflow(workflowDao.findById(ticket.getWorkflow().getFlowId()));
			ticket = ticketDao.persist(ticket);
			ticket.setCreationdate(new Date());
			attachmentService.saveAttachment(ticket.getHduser(), files, ticket);
			//result = stepTicketForward(ticket.getTicketId());
			result = convertToDTO(ticket, ticketdto);
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}catch (Exception e1) {
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
			Ticket oldTicket = ticketDao.findById(ticket.getTicketId());
			ticket.setTicketSeverity(severityDao.findById(ticket.getTicketSeverity().getSeverityId()));
			ticket.setTicketPriority(priorityDao.findById(ticket.getTicketPriority().getPrioprtiyId()));
			ticket.setWorkflow(workflowDao.findById(ticket.getWorkflow().getFlowId()));
			ticket.setStatus(statusDao.findById(ticket.getStatus().getStatusId()));
			ticket.setHduser(userDao.findById(ticket.getHduser().getUserId()));
			ticket.setStep(stepDao.findById(ticket.getStep().getStepId()));
			ticket.setUpdateDate(new Date());
			result = ticketDao.update(ticket);
			createInformationalDetailsHistory(oldTicket, ticket);
		
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}catch (Exception e1) {
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
			//String folderPath = IntegrationServicesConstant.ATTACHMENT_PATH+ticket.getTicketnumber()+"_attachment/";
			attachmentService.saveAttachment(null, files, ticket);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}catch (Exception e1) {
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
	public List<TicketDTO> getByWorkflowIDAndUserName(long workflowId, String userEmail) throws BusinessException {
		List<TicketDTO> result;
		try {
			List<Ticket> ticketList = ticketDao.getByWorkflowIDAndUserName(workflowId, userEmail);
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
	public MainTicketChartDTO getSeverityPriorityStatusByUserName(String userEmail) throws BusinessException {
		MainTicketChartDTO result;
		try {
			result = ticketDao.getSeverityPriorityStatusByUserName(userEmail);
			
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
	public List<WidgetDTO> getDashBoardCountByProjectIDAndUserName(Long projectId, String userEmail) throws BusinessException {
		List<WidgetDTO> result;
		try {
			result =  ticketDao.getDashBoardCountByProjectIDAndUserName(projectId, userEmail);
			
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
	public List<WidgetDTO> getWeekChartStatusesNumber(Long projectId) throws BusinessException {
		List<WidgetDTO> result;
		try {
			result =  ticketDao.getWeekChartStatusesNumber(projectId);
			
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
	
	
	
	@Override
	@Transactional
	public TicketDTO stepTicketForward(long ticketId) throws BusinessException {
		TicketDTO result = new TicketDTO();
		try {
			Ticket ticket = ticketDao.findById(ticketId);
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
			
			
			//Forwarding to Last Step
			if( (stepIndex + 1) == (workflowSteps.size()) ) {
				ticket.setStatus(statusDao.findById(Long.parseLong(ServicesEnums.TICKET_STATUS_COMPLETED.getStringValue())));
			}else {
				//Forwarding From First Step to Second Step or Forwarding to any middle Steps
				ticket.setStatus(statusDao.findById(Long.parseLong(ServicesEnums.TICKET_STATUS_INPROGRESS.getStringValue())));
				ticket.setStep(stepDao.findById(workflowSteps.get(stepIndex + 1).getStep().getStepId()));
			}
			
			ticket = ticketDao.update(ticket);
			behavioralDetailsService.
        	createBehavioralDetails(createBehavioralDetailsHistory(ticket,ServicesEnums.BEHAVIOR_VALUE_FORWARD.getStringValue()));
			
			result = convertToDTO(ticket, result);
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}catch (BusinessException e) {
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
	public TicketDTO stepTicketBackward(long ticketId) throws BusinessException {
		TicketDTO result = new TicketDTO();
		try {
			Ticket ticket = ticketDao.findById(ticketId);
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
			/*if(stepIndex == 1) {
				ticket.setStatus(statusDao.findById(Long.parseLong(ServicesEnums.TICKET_STATUS_CREATED.getStringValue())));
			}else {
			//Forwarding to middle Steps or Backward From Last Step
			ticket.setStatus(statusDao.findById(Long.parseLong(ServicesEnums.TICKET_STATUS_INPROGRESS.getStringValue())));
			}*/
			ticket.setStep(stepDao.findById(workflowSteps.get(stepIndex - 1).getStep().getStepId()));
			ticket = ticketDao.update(ticket);
	         behavioralDetailsService.
        	createBehavioralDetails(createBehavioralDetailsHistory(ticket,ServicesEnums.BEHAVIOR_VALUE_BACKWARD.getStringValue()));
	         List<String> to = new ArrayList<String>();
			 to.add(ticket.getHduser().getEmailAddress());
	       //  Mailer.send(to, "Ticket Move Backword", "Ticket Move Backword");
			result = convertToDTO(ticket, result);
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}catch (BusinessException e) {
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
	
	public BehavioralDetails createBehavioralDetailsHistory(Ticket ticket, String value) {
		BehavioralDetails behavioralDetails = new BehavioralDetails();
		behavioralDetails.setBehaviorName(ServicesEnums.BEHAVIOR_NAME_ACTION.getStringValue());
		behavioralDetails.setBehaviorValue(value);
		behavioralDetails.setId(ticket.getTicketId());
		behavioralDetails.setStepId(ticket.getStep());
		behavioralDetails.setTicketId(ticket);
		behavioralDetails.setActionBy(ticket.getHduser());
		behavioralDetails.setActionAt(new Date());
		return behavioralDetails;
	}
	
	public InformationalDetails createInformationalDetailsHistory(Ticket ticket, String colName, String oldValue, String newValue) {
		InformationalDetails informationalDetails = new InformationalDetails();
		informationalDetails.setColName(colName);
		informationalDetails.setOldValue(oldValue);
		informationalDetails.setNewValue(newValue);
		informationalDetails.setStepId(ticket.getStep());
		informationalDetails.setTicketId(ticket);
		informationalDetails.setUpdatedBy(ticket.getHduser());
		informationalDetails.setUpdatedAt(new Date());
		return informationalDetails;
	}
	
	public void createInformationalDetailsHistory(Ticket oldTicket, Ticket result) throws BusinessException {
		if(!oldTicket.getTitle().equals(result.getTitle()))
			informationalDetailsService.createInformationalDetails(
		createInformationalDetailsHistory(result, ServicesEnums.INFORMATIONAL_COLNAME_TITLE.getStringValue(),oldTicket.getTitle(), result.getTitle()));
		
		if(!oldTicket.getDescription().equals(result.getDescription()))
			informationalDetailsService.createInformationalDetails(
		createInformationalDetailsHistory(result, ServicesEnums.INFORMATIONAL_COLNAME_DESCRIPTION.getStringValue(),oldTicket.getDescription(), result.getDescription()));
		
		if(oldTicket.getTicketSeverity().getSeverityId() != result.getTicketSeverity().getSeverityId())
			informationalDetailsService.createInformationalDetails(
		createInformationalDetailsHistory(result, ServicesEnums.INFORMATIONAL_COLNAME_SEVERIRTY.getStringValue(),oldTicket.getTicketSeverity().getSeverityName(), result.getTicketSeverity().getSeverityName()));
	
		if(oldTicket.getTicketPriority().getPrioprtiyId() != result.getTicketPriority().getPrioprtiyId())
			informationalDetailsService.createInformationalDetails(
			createInformationalDetailsHistory(result, ServicesEnums.INFORMATIONAL_COLNAME_PRIORITY.getStringValue(),oldTicket.getTicketPriority().getPriorityLevel(), result.getTicketPriority().getPriorityLevel()));
	
		if(oldTicket.getStatus().getStatusId() != result.getStatus().getStatusId())
			informationalDetailsService.createInformationalDetails(
			createInformationalDetailsHistory(result, ServicesEnums.INFORMATIONAL_COLNAME_STATUS.getStringValue(),oldTicket.getStatus().getStatus(), result.getStatus().getStatus()));
	}
}
