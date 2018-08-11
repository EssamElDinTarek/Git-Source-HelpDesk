package com.sbm.helpdesk.persistence.dao;

import java.util.List;

import com.sbm.helpdesk.common.dto.PortfolioDBDetailsDTO;
import com.sbm.helpdesk.common.dto.WidgetDTO;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.entity.*;

public interface PortfolioDao extends GenericDao<Portfolio> {

	public List<WidgetDTO> getWeekChartPortfolioProjectNumber() throws RespositoryException;
	public List<PortfolioDBDetailsDTO> getDashBoardportfolio() throws RespositoryException;
}
