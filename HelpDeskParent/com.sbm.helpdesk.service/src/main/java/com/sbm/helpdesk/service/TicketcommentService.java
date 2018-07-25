package com.sbm.helpdesk.service;

import java.util.List;

import javax.transaction.Transactional;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.dto.*;

@Transactional
public interface TicketcommentService {
	
	public TicketcommentDTO addTicketcomment(TicketcommentDTO ticketcommentDTO)throws BusinessException ;
	public List<TicketcommentDTO> getTicketcommentByTicId(long ticId) throws BusinessException;
	public String deleteTicketcomment(Long id) throws BusinessException ;
}
