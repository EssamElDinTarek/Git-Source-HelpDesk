package com.sbm.helpdesk.service;

import java.util.List;

import javax.transaction.Transactional;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.dto.InformationalDetailsDTO;
import com.sbm.helpdesk.persistence.entity.InformationalDetails;

@Transactional
public interface InformationalDetailsService {

	public void createInformationalDetails(InformationalDetails informationalDetails) throws BusinessException;
	public List<InformationalDetailsDTO> getInformationalDetailsByTicketId(long ticketId) throws BusinessException;
}
