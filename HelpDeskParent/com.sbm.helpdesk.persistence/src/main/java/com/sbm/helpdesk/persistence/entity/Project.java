package com.sbm.helpdesk.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the PROJECT database table.
 * 
 */
@Entity
@Table(name="PROJECT")
@NamedQueries({
	@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p"),
	@NamedQuery(name="Project.findProjectByName", query="SELECT p FROM Project p where name=:arg1"),
	@NamedQuery(name="Project.findProjectById", query="SELECT p FROM Project p where projectId=:projectId"),
	@NamedQuery(name="Project.findProjectByPortfolioId", query="SELECT p FROM Project p where portfolio.portfolioId=:portfolioId")
})

public class Project extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROJECT_PROJECTID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECT_PROJECTID_GENERATOR")
	@Column(name="PROJECT_ID", unique=true, nullable=false, precision=22)
	private long projectId;

	@Column(length=255)
	private String name;

	@Column(name="IS_DELETED",nullable=false)
	private long deleted;
	
	//bi-directional many-to-one association to Portfolio
	@ManyToOne
	@JoinColumn(name="PORTFOLIO_ID")
	private Portfolio portfolio;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy = "project")
	private List<Ticket> tickets;
	
	//bi-directional many-to-many association to Users
	@ManyToMany(mappedBy="projects")
	private List<Hduser> hdusers = new ArrayList<>();

	public Project() {
	}

	public long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Portfolio getPortfolio() {
		return this.portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setProject(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setProject(null);

		return ticket;
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
		result = prime * result + (int) (projectId ^ (projectId >>> 32));
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
		Project other = (Project) obj;
		if (projectId != other.projectId)
			return false;
		return true;
	}

	public List<Hduser> getHdusers() {
		return hdusers;
	}

	public void setHdusers(List<Hduser> hdusers) {
		this.hdusers = hdusers;
	}

}