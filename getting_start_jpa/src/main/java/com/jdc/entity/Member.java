package com.jdc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
		name = "MEMBER_TABLE"
//		indexes = {
//				//@Index(columnList = "role"),
//				@Index(columnList = "phone")
//				
//		},
//		uniqueConstraints = {
//				@UniqueConstraint(columnNames = {"email","phone"})
//		}
)
@SecondaryTables({
	@SecondaryTable(
			name = "LOGIN_INFO",
			indexes = {
					@Index(columnList = "role")
			}
			)
	,
	@SecondaryTable(
			name = "CONTACT_INFO",
			indexes = {
					@Index(columnList = "phone")
			},
			uniqueConstraints = {
					@UniqueConstraint(columnNames = {"email","phone"})
			}
			)
})

public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "mId")
	
	private int id;
	
	@Basic(optional = false)
	private String name;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Column(table = "LOGIN_INFO")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Embedded
	private Contact contact;
	
	@Column(table = "LOGIN_INFO")
	private String loginId;
	@Column(table = "LOGIN_INFO")
	private String password;

	public enum Role {
		Admin, Teacher, Student
	}

	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(String email, String phone, String address) {
		this.contact = new Contact();
		this.contact.setEmail(email);
		contact.setPhone(phone);
		contact.setAddress(address);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
