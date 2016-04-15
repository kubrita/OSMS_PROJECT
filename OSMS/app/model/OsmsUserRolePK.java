package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the osms_user_role database table.
 * 
 */
@Embeddable
public class OsmsUserRolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer userid;

	@Column(insertable=false, updatable=false)
	private Integer roleid;

	public OsmsUserRolePK() {
	}
	public Integer getUserid() {
		return this.userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getRoleid() {
		return this.roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OsmsUserRolePK)) {
			return false;
		}
		OsmsUserRolePK castOther = (OsmsUserRolePK)other;
		return 
			this.userid.equals(castOther.userid)
			&& this.roleid.equals(castOther.roleid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userid.hashCode();
		hash = hash * prime + this.roleid.hashCode();
		
		return hash;
	}
}