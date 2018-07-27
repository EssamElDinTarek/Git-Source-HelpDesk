package com.sbm.helpdesk.common.dto;

import java.util.Set;


public class TeamDTO extends BaseDTO  {

	private static final long serialVersionUID = 6104011990509049339L;
	
	private long recId;
	private String description;
	private String teamName;
	private Set<HduserDTO> hdusers;
	public long getRecId() {
		return recId;
	}
	public void setRecId(long recId) {
		this.recId = recId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Set<HduserDTO> getHdusers() {
		return hdusers;
	}
	public void setHdusers(Set<HduserDTO> hdusers) {
		this.hdusers = hdusers;
	}
	
	
}
