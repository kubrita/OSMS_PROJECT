package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the osms_user_role database table.
 * 
 */
@Entity
@Table(name="osms_user_role")
@NamedQuery(name="OsmsUserRole.findAll", query="SELECT o FROM OsmsUserRole o")
public class OsmsUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OsmsUserRolePK id;

	//bi-directional many-to-one association to OsmsUser
	@ManyToOne
	@JoinColumn(name="userid")
	private OsmsUser osmsUser;

	public OsmsUserRole() {
	}

	public OsmsUserRolePK getId() {
		return this.id;
	}

	public void setId(OsmsUserRolePK id) {
		this.id = id;
	}

	public OsmsUser getOsmsUser() {
		return this.osmsUser;
	}

	public void setOsmsUser(OsmsUser osmsUser) {
		this.osmsUser = osmsUser;
	}

}