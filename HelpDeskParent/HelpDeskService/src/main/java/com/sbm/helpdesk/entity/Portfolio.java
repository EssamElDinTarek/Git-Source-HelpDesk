package com.sbm.helpdesk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PORTFOLIO database table.
 * 
 */
@Entity
@Table(name="PORTFOLIO")
@NamedQuery(name="Portfolio.findAll", query="SELECT p FROM Portfolio p")
public class Portfolio extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PORTFOLIO_PORTFOLIOID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PORTFOLIO_PORTFOLIOID_GENERATOR")
	@Column(name="PORTFOLIO_ID", unique=true, nullable=false, precision=22)
	private long portfolioId;

	@Column(length=255)
	private String name;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="portfolio")
	private List<Project> projects;

	public Portfolio() {
	}

	public long getPortfolioId() {
		return this.portfolioId;
	}

	public void setPortfolioId(long portfolioId) {
		this.portfolioId = portfolioId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setPortfolio(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setPortfolio(null);

		return project;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (portfolioId ^ (portfolioId >>> 32));
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
		Portfolio other = (Portfolio) obj;
		if (portfolioId != other.portfolioId)
			return false;
		return true;
	}

}