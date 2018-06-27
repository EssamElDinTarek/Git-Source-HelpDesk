package com.sbm.helpdesk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRIVILEGE database table.
 * 
 */
@Entity
@Table(name="PRIVILEGE")
@NamedQuery(name="Privilege.findAll", query="SELECT p FROM Privilege p")
public class Privilege extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRIVILEGE_PRIVILEGEID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRIVILEGE_PRIVILEGEID_GENERATOR")
	@Column(name="PRIVILEGE_ID", unique=true, nullable=false, precision=22)
	private long privilegeId;

	@Column(name="PRIVILEGE_NAME", nullable=false, length=200)
	private String privilegeName;

	//bi-directional many-to-one association to Hdgroup
	@OneToMany(mappedBy="privilege")
	private List<Hdgroup> hdgroups;

	public Privilege( ) {
		}
	public Privilege(long privilegeId) {
		this.privilegeId = privilegeId;
		}

	public long getPrivilegeId() {
		return this.privilegeId;
	}

	public void setPrivilegeId(long privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getPrivilegeName() {
		return this.privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public List<Hdgroup> getHdgroups() {
		return this.hdgroups;
	}

	public void setHdgroups(List<Hdgroup> hdgroups) {
		this.hdgroups = hdgroups;
	}

	public Hdgroup addHdgroup(Hdgroup hdgroup) {
		getHdgroups().add(hdgroup);
		hdgroup.setPrivilege(this);

		return hdgroup;
	}

	public Hdgroup removeHdgroup(Hdgroup hdgroup) {
		getHdgroups().remove(hdgroup);
		hdgroup.setPrivilege(null);

		return hdgroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (privilegeId ^ (privilegeId >>> 32));
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
		Privilege other = (Privilege) obj;
		if (privilegeId != other.privilegeId)
			return false;
		return true;
	}

}