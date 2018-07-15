package com.sbm.helpdesk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HDROLE database table.
 * 
 */
@Entity
@Table(name="HDROLE")
@NamedQuery(name="Hdrole.findAll", query="SELECT h FROM Hdrole h")
public class Hdrole extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HDROLE_ROLEID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HDROLE_ROLEID_GENERATOR")
	@Column(name="ROLE_ID", unique=true, nullable=false, precision=22)
	private long roleId;

	@Column(name="ROLE_NAME", length=200)
	private String roleName;

	//bi-directional many-to-many association to Hduser
	  @JoinTable(name = "USER_ROLE", joinColumns = {
		        @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")}, inverseJoinColumns = {
		        @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")})
		    @ManyToMany
	private List<Hduser> hdusers;

	//bi-directional many-to-many association to Permission
	@ManyToMany(mappedBy="hdroles")
	private List<Permission> permissions;

	public Hdrole() {
	}

	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Hduser> getHdusers() {
		return this.hdusers;
	}

	public void setHdusers(List<Hduser> hdusers) {
		this.hdusers = hdusers;
	}

	public List<Permission> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (roleId ^ (roleId >>> 32));
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
		Hdrole other = (Hdrole) obj;
		if (roleId != other.roleId)
			return false;
		return true;
	}

}