package com.sbm.helpdesk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SUBCOMPONENT database table.
 * 
 */
@Entity
@Table(name="SUBCOMPONENT")
@NamedQuery(name="Subcomponent.findAll", query="SELECT s FROM Subcomponent s")
public class Subcomponent extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SUBCOMPONENT_SUBCOMPONENTID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SUBCOMPONENT_SUBCOMPONENTID_GENERATOR")
	@Column(name="SUBCOMPONENT_ID", unique=true, nullable=false, precision=22)
	private long subcomponentId;

	@Column(name="SUBCOMPONENT_NAME", length=200)
	private String subcomponentName;
	//bi-directional many-to-one association to Component
	@ManyToOne
	@JoinColumn(name="COMPONENT_ID")
	private Component component;

	//bi-directional many-to-many association to Hdgroup
	@ManyToMany
	@JoinTable(
		name="GROUP_SUBCOMPONENT"
		, joinColumns={
			@JoinColumn(name="SUBCOMPONENT_ID", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="GROUP_ID", nullable=false)
			}
		)
	private List<Hdgroup> hdgroups;

	public Subcomponent() {
	}

	public long getSubcomponentId() {
		return this.subcomponentId;
	}

	public void setSubcomponentId(long subcomponentId) {
		this.subcomponentId = subcomponentId;
	}

	public String getSubcomponentName() {
		return this.subcomponentName;
	}

	public void setSubcomponentName(String subcomponentName) {
		this.subcomponentName = subcomponentName;
	}

	public Component getComponent() {
		return this.component;
	}

	
	public void setComponent(Component component) {
		this.component = component;
	}
	public List<Hdgroup> getHdgroups() {
		return this.hdgroups;
	}

	public void setHdgroups(List<Hdgroup> hdgroups) {
		this.hdgroups = hdgroups;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (subcomponentId ^ (subcomponentId >>> 32));
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
		Subcomponent other = (Subcomponent) obj;
		if (subcomponentId != other.subcomponentId)
			return false;
		return true;
	}

}