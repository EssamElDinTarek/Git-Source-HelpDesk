package com.sbm.helpdesk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the "GROUP" database table.
 * 
 */
@Entity
@Table(name="\"GROUP\"")
@NamedQuery(name="Group.findAll", query="SELECT g FROM Group g")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GROUP_ID_GENERATOR" , sequenceName = "group_seq" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GROUP_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false, length=200)
	private String description;

	@Column(name="IS_ACTIVE", nullable=false, precision=1)
	private BigDecimal isActive;

	@Column(name="NAME_AR", length=50)
	private String nameAr;

	@Column(name="NAME_EN", nullable=false, length=50)
	private String nameEn;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="groups")
	private List<User> users;

	//bi-directional many-to-many association to Permission
	@ManyToMany(mappedBy="groups")
	private List<Permission> permissions;

	public Group() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getIsActive() {
		return this.isActive;
	}

	public void setIsActive(BigDecimal isActive) {
		this.isActive = isActive;
	}

	public String getNameAr() {
		return this.nameAr;
	}

	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Permission> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

}