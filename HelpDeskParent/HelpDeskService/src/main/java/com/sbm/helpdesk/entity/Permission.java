package com.sbm.helpdesk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PERMISSIONS database table.
 * 
 */
@Entity
@Table(name="PERMISSIONS")
@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")
public class Permission extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERMISSIONS_PERMISSIONID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERMISSIONS_PERMISSIONID_GENERATOR")
	@Column(name="PERMISSION_ID", unique=true, nullable=false, precision=22)
	private long permissionId;

	@Column(length=200)
	private String description;

	@Column(name="PERMISSION_NAME", length=200)
	private String permissionName;

	//bi-directional many-to-many association to Hdrole
	   @JoinTable(name = "ROLE_PERMISSIONS", joinColumns = {
		        @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "PERMISSION_ID")}, inverseJoinColumns = {
		        @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")})
		    @ManyToMany
	private List<Hdrole> hdroles;

	public Permission() {
	}

	public long getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(long permissionId) {
		this.permissionId = permissionId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPermissionName() {
		return this.permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public List<Hdrole> getHdroles() {
		return this.hdroles;
	}

	public void setHdroles(List<Hdrole> hdroles) {
		this.hdroles = hdroles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (permissionId ^ (permissionId >>> 32));
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
		Permission other = (Permission) obj;
		if (permissionId != other.permissionId)
			return false;
		return true;
	}

}