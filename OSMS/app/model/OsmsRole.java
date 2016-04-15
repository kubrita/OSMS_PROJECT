package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the osms_role database table.
 * 
 */
@Entity
@Table(name="osms_role")
@NamedQuery(name="OsmsRole.findAll", query="SELECT o FROM OsmsRole o")
public class OsmsRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String role;

	//bi-directional many-to-many association to OsmsUser
	@ManyToMany(mappedBy="osmsRoles")
	private List<OsmsUser> osmsUsers;

	public OsmsRole() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<OsmsUser> getOsmsUsers() {
		return this.osmsUsers;
	}

	public void setOsmsUsers(List<OsmsUser> osmsUsers) {
		this.osmsUsers = osmsUsers;
	}

}