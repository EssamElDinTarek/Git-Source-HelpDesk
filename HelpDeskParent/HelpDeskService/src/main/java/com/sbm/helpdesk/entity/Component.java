package com.sbm.helpdesk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the COMPONENT database table.
 * 
 */
@Entity
@Table(name="COMPONENT")
@NamedQuery(name="Component.findAll", query="SELECT c FROM Component c")
public class Component extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMPONENT_COMPONENTID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPONENT_COMPONENTID_GENERATOR")
	@Column(name="COMPONENT_ID", unique=true, nullable=false, precision=22)
	private long componentId;

	@Column(name="COMPONENT_NAME", length=200)
	private String componentName;

	//bi-directional many-to-many association to Hdgroup
	 @JoinTable(name = "GROUP_COMPONENT", joinColumns = {
		        @JoinColumn(name = "COMPONENT_ID", referencedColumnName = "COMPONENT_ID")}, inverseJoinColumns = {
		        @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")})
		    @ManyToMany
	private List<Hdgroup> hdgroups;

	//bi-directional many-to-one association to Subcomponent
	@OneToMany(mappedBy="component")
	private List<Subcomponent> subcomponents;

	public Component() {
	}

	public long getComponentId() {
		return this.componentId;
	}

	public void setComponentId(long componentId) {
		this.componentId = componentId;
	}

	public String getComponentName() {
		return this.componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public List<Hdgroup> getHdgroups() {
		return this.hdgroups;
	}

	public void setHdgroups(List<Hdgroup> hdgroups) {
		this.hdgroups = hdgroups;
	}

	public List<Subcomponent> getSubcomponents() {
		return this.subcomponents;
	}

	public void setSubcomponents(List<Subcomponent> subcomponents) {
		this.subcomponents = subcomponents;
	}

	public Subcomponent addSubcomponent(Subcomponent subcomponent) {
		getSubcomponents().add(subcomponent);
		subcomponent.setComponent(this);

		return subcomponent;
	}

	public Subcomponent removeSubcomponent(Subcomponent subcomponent) {
		getSubcomponents().remove(subcomponent);
		subcomponent.setComponent(null);

		return subcomponent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (componentId ^ (componentId >>> 32));
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
		Component other = (Component) obj;
		if (componentId != other.componentId)
			return false;
		return true;
	}

}