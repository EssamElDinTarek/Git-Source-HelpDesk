package com.sbm.helpdesk.common.dto;

public class PortfolioDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long portfolioId;
	private String name;
	//private HduserDTO hduser;
	
	public long getPortfolioId() {
		return portfolioId;
	}
	public void setPortfolioId(long portfolioId) {
		this.portfolioId = portfolioId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
