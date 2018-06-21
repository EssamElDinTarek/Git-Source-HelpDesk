package com.sbm.helpdesk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PERMISSION database table.
 * 
 */
@Entity
@Table(name="PERMISSION")
@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERMISSION_ID_GENERATOR" , sequenceName="permission_seq" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERMISSION_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false, precision=9)
	private BigDecimal code;

	@Column(name="NAME_AR", length=50)
	private String nameAr;

	@Column(name="NAME_EN", length=50)
	private String nameEn;

	//bi-directional many-to-one association to Menu
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MENU_ID", nullable=false)
	private Menu menu;

	//bi-directional many-to-many association to Group
	@ManyToMany
	@JoinTable(
		name="USER_GROUP_PERMISSION"
		, joinColumns={
			@JoinColumn(name="PERMISSION_ID", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="GROUP_ID", nullable=false)
			}
		)
	private List<Group> groups;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="permissions")
	private List<User> users;

	public Permission() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCode() {
		return this.code;
	}

	public void setCode(BigDecimal code) {
		this.code = code;
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

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Group> getGroups() {
		return this.groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}