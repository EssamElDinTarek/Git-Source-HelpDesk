package com.sbm.helpdesk.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.common.mailer.Mailer;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;
import com.sbm.helpdesk.common.dto.*;

@Service
public class NotificationServiceImpl {
	
	Mailer mailer = new Mailer();
	
	public void sendEmailNotification(Ticket ticket) {
		mailer.send(new String[]{ticket.getHduser().getEmailAddress()}, ticket.getTicketnumber(), ticket.getDescription() );
	}

}
