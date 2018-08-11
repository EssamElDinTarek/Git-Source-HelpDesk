package com.sbm.helpdesk.persistence.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sbm.helpdesk.common.dto.PortfolioDBDetailsDTO;
import com.sbm.helpdesk.common.dto.ProjectDBDetailsDTO;
import com.sbm.helpdesk.common.dto.WidgetDTO;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;

@Repository
public class PortfolioDaoImpl extends GenericDaoImpl<Portfolio> implements PortfolioDao {

	@Override
	public List<WidgetDTO> getWeekChartPortfolioProjectNumber() throws RespositoryException {
		List<WidgetDTO> widgetDTOList = new ArrayList<WidgetDTO>();
		try {
			String sqlString = "select PORTFOLIO.NAME, count(*) from PROJECT, PORTFOLIO  where PROJECT.PORTFOLIO_ID  = PORTFOLIO.PORTFOLIO_ID GROUP BY PORTFOLIO.NAME";
			Query query = this.entityManager.createNativeQuery(sqlString);
			List<Object[]> list = (List<Object[]>) query.getResultList();
			for (Object[] a : list) {
				WidgetDTO widgetdto = new WidgetDTO();
				widgetdto.setName(a[0].toString());
				widgetdto.setValue(Long.parseLong(a[1].toString()));
				widgetDTOList.add(widgetdto);
			}
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return widgetDTOList;
	}
	@Override
	public List<PortfolioDBDetailsDTO> getDashBoardportfolio() throws RespositoryException {
		List<PortfolioDBDetailsDTO> portfolioDBlist = new ArrayList<PortfolioDBDetailsDTO>();
		try{
			String sqlString = "select  * from (select * from PORTFOLIO) , " + 
					"(Select PROJECT.PORTFOLIO_ID as tab1, count(*) as open from Project where PROJECT.PROJECT_STATUS_ID = 1 GROUP BY PROJECT.PROJECT_STATUS_ID,PROJECT.PORTFOLIO_ID), " + 
					"(Select PROJECT.PORTFOLIO_ID as tab2, count(*) as closed from Project where PROJECT.PROJECT_STATUS_ID = 2 GROUP BY PROJECT.PROJECT_STATUS_ID,PROJECT.PORTFOLIO_ID) " + 
					"where PORTFOLIO_ID = tab1 and PORTFOLIO_ID =tab2 ";
			Query query = this.entityManager.createNativeQuery(sqlString);
			List<Object[]> list =(List<Object[]>) query.getResultList();
			for (Object[] a : list) {
				PortfolioDBDetailsDTO portfolioDB = new PortfolioDBDetailsDTO();
				portfolioDB.setPortfolioId(Long.parseLong(a[0].toString()));
				portfolioDB.setName(a[1].toString());
				portfolioDB.setOpenProject(Long.parseLong(a[5].toString()));
				portfolioDB.setClosedProject(Long.parseLong(a[7].toString()));
				portfolioDBlist.add(portfolioDB);
				}
			
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return portfolioDBlist;
	}
}
