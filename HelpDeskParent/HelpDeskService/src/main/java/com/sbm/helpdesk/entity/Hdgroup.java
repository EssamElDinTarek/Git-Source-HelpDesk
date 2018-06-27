package com.sbm.helpdesk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HDGROUP database table.
 * 
 */
@Entity
@Table(name="HDGROUP")
@NamedQuery(name="Hdgroup.findAll", query="SELECT h FROM Hdgroup h")
public class Hdgroup extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HDGROUP_GROUPID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HDGROUP_GROUPID_GENERATOR")
	@Column(name="GROUP_ID", unique=true, nullable=false, precision=22)
	private long groupId;

	@Column(name="GROUP_NAME", length=200)
	private String groupName;

	 
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PRIVILEGE_ID")
	private Privilege privilege;


	//bi-directional many-to-one association to GroupSubcomponent
	@OneToMany(mappedBy="hdgroup")
	private List<GroupSubcomponent> groupSubcomponents;

	//bi-directional many-to-many association to Component
	 @ManyToMany(mappedBy = "hdgroups")
	private List<Component> components;

	//bi-directional many-to-many association to Hduser
	 @JoinTable(name = "USER_GROUP", joinColumns = {
		        @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")}, inverseJoinColumns = {
		        @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")})
		    @ManyToMany
	private List<Hduser> hdusers;

	

	public Hdgroup() {
	}

	public Hdgroup(String groupName) {
		this.groupName=groupName;
	}

	public long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

 

	public List<GroupSubcomponent> getGroupSubcomponents() {
		return this.groupSubcomponents;
	}

	public void setGroupSubcomponents(List<GroupSubcomponent> groupSubcomponents) {
		this.groupSubcomponents = groupSubcomponents;
	}

	public GroupSubcomponent addGroupSubcomponent(GroupSubcomponent groupSubcomponent) {
		getGroupSubcomponents().add(groupSubcomponent);
		groupSubcomponent.setHdgroup(this);

		return groupSubcomponent;
	}

	public GroupSubcomponent removeGroupSubcomponent(GroupSubcomponent groupSubcomponent) {
		getGroupSubcomponents().remove(groupSubcomponent);
		groupSubcomponent.setHdgroup(null);

		return groupSubcomponent;
	}

	public List<Component> getComponents() {
		return this.components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public List<Hduser> getHdusers() {
		return this.hdusers;
	}

	public void setHdusers(List<Hduser> hdusers) {
		this.hdusers = hdusers;
	}
	public Privilege getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (groupId ^ (groupId >>> 32));
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
		Hdgroup other = (Hdgroup) obj;
		if (groupId != other.groupId)
			return false;
		return true;
	}
}