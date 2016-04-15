package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the osms_user database table.
 * 
 */
@Entity
@Table(name="osms_user")
@NamedQuery(name="OsmsUser.findAll", query="SELECT o FROM OsmsUser o")
public class OsmsUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String address;

	private Integer age;

	private String email;

	private Integer gender;

	@Column(name="middle_name")
	private String middleName;

	private String name;

	private String password;

	@Column(name="phone_number")
	private String phoneNumber;

	private String surname;

	//bi-directional many-to-many association to OsmsRole
	@ManyToMany
	@JoinTable(
		name="osms_user_role"
		, joinColumns={
			@JoinColumn(name="userid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="roleid")
			}
		)
	private List<OsmsRole> osmsRoles;

	//bi-directional many-to-one association to OsmsUserRole
	@OneToMany(mappedBy="osmsUser")
	private List<OsmsUserRole> osmsUserRoles;

	public OsmsUser() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<OsmsRole> getOsmsRoles() {
		return this.osmsRoles;
	}

	public void setOsmsRoles(List<OsmsRole> osmsRoles) {
		this.osmsRoles = osmsRoles;
	}

	public List<OsmsUserRole> getOsmsUserRoles() {
		return this.osmsUserRoles;
	}

	public void setOsmsUserRoles(List<OsmsUserRole> osmsUserRoles) {
		this.osmsUserRoles = osmsUserRoles;
	}

	public OsmsUserRole addOsmsUserRole(OsmsUserRole osmsUserRole) {
		getOsmsUserRoles().add(osmsUserRole);
		osmsUserRole.setOsmsUser(this);

		return osmsUserRole;
	}

	public OsmsUserRole removeOsmsUserRole(OsmsUserRole osmsUserRole) {
		getOsmsUserRoles().remove(osmsUserRole);
		osmsUserRole.setOsmsUser(null);

		return osmsUserRole;
	}

}