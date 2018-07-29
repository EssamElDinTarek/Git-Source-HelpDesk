package com.sbm.helpdesk.service;

import java.util.List;

import javax.transaction.Transactional;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.dto.BehavioralDetailsDTO;
import com.sbm.helpdesk.persistence.entity.BehavioralDetails;

@Transactional
public interface BehavioralDetailsService {

	public void createBehavioralDetails(BehavioralDetails behavioralDetails) throws BusinessException;
	public List<BehavioralDetailsDTO> getBehavioralDetailsByTicketId(long ticketId) throws BusinessException;
}
