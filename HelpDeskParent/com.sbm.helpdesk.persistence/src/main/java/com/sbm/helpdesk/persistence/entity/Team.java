package com.sbm.helpdesk.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TEAM database table.
 * 
 */
@Entity
@Table(name="TEAM")
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TEAM_RECID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEAM_RECID_GENERATOR")
	@Column(name="REC_ID", unique=true, nullable=false, precision=22)
	private long recId;

	@Column(length=200)
	private String description;

	@Column(name="TEAM_NAME", length=200)
	private String teamName;

	@Column(name="IS_DELETED",nullable=false)
	private long deleted;
	
	//bi-directional many-to-one association to Hduser
	@OneToMany(mappedBy="team")
	private List<Hduser> hdusers;

	@OneToMany(mappedBy="team")
	private List<Step> steps;
	public Team() {
	}

	public long getRecId() {
		return this.recId;
	}

	public void setRecId(long recId) {
		this.recId = recId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Hduser> getHdusers() {
		return this.hdusers;
	}

	public void setHdusers(List<Hduser> hdusers) {
		this.hdusers = hdusers;
	}

	public Hduser addHduser(Hduser hduser) {
		getHdusers().add(hduser);
		hduser.setTeam(this);

		return hduser;
	}

	public Hduser removeHduser(Hduser hduser) {
		getHdusers().remove(hduser);
		hduser.setTeam(null);

		return hduser;
	}
	

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
	
	

	public long getDeleted() {
		return deleted;
	}

	public void setDeleted(long deleted) {
		this.deleted = deleted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (recId ^ (recId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (recId != other.recId)
			return false;
		return true;
	}

}