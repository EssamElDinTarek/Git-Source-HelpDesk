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

	//bi-directional many-to-one association to GroupSubcomponent
	@OneToMany(mappedBy="subcomponent")
	private List<GroupSubcomponent> groupSubcomponents;

	//bi-directional many-to-one association to Component
	@ManyToOne
	@JoinColumn(name="COMPONENT_ID")
	private Component component;

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

	public List<GroupSubcomponent> getGroupSubcomponents() {
		return this.groupSubcomponents;
	}

	public void setGroupSubcomponents(List<GroupSubcomponent> groupSubcomponents) {
		this.groupSubcomponents = groupSubcomponents;
	}

	public GroupSubcomponent addGroupSubcomponent(GroupSubcomponent groupSubcomponent) {
		getGroupSubcomponents().add(groupSubcomponent);
		groupSubcomponent.setSubcomponent(this);

		return groupSubcomponent;
	}

	public GroupSubcomponent removeGroupSubcomponent(GroupSubcomponent groupSubcomponent) {
		getGroupSubcomponents().remove(groupSubcomponent);
		groupSubcomponent.setSubcomponent(null);

		return groupSubcomponent;
	}

	public Component getComponent() {
		return this.component;
	}

	public void setComponent(Component component) {
		this.component = component;
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