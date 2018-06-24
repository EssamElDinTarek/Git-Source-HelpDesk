package com.sbm.helpdesk.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GROUP_SUBCOMPONENT database table.
 * 
 */
@Entity
@Table(name="GROUP_SUBCOMPONENT")
@NamedQuery(name="GroupSubcomponent.findAll", query="SELECT g FROM GroupSubcomponent g")
public class GroupSubcomponent extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GROUP_SUBCOMPONENT_GRSUID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GROUP_SUBCOMPONENT_GRSUID_GENERATOR")
	@Column(name="GR_SU_ID", unique=true, nullable=false, precision=22)
	private long grSuId;

	@Column(nullable=false, length=200)
	private String privilige;

	//bi-directional many-to-one association to Hdgroup
	@ManyToOne
	@JoinColumn(name="GROUP_ID", nullable=false)
	private Hdgroup hdgroup;

	//bi-directional many-to-one association to Subcomponent
	@ManyToOne
	@JoinColumn(name="SUBCOMPONENT_ID", nullable=false)
	private Subcomponent subcomponent;

	public GroupSubcomponent() {
	}

	public long getGrSuId() {
		return this.grSuId;
	}

	public void setGrSuId(long grSuId) {
		this.grSuId = grSuId;
	}

	public String getPrivilige() {
		return this.privilige;
	}

	public void setPrivilige(String privilige) {
		this.privilige = privilige;
	}

	public Hdgroup getHdgroup() {
		return this.hdgroup;
	}

	public void setHdgroup(Hdgroup hdgroup) {
		this.hdgroup = hdgroup;
	}

	public Subcomponent getSubcomponent() {
		return this.subcomponent;
	}

	public void setSubcomponent(Subcomponent subcomponent) {
		this.subcomponent = subcomponent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hdgroup == null) ? 0 : hdgroup.hashCode());
		result = prime * result + ((subcomponent == null) ? 0 : subcomponent.hashCode());
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
		GroupSubcomponent other = (GroupSubcomponent) obj;
		if (hdgroup == null) {
			if (other.hdgroup != null)
				return false;
		} else if (!hdgroup.equals(other.hdgroup))
			return false;
		if (subcomponent == null) {
			if (other.subcomponent != null)
				return false;
		} else if (!subcomponent.equals(other.subcomponent))
			return false;
		return true;
	}

}