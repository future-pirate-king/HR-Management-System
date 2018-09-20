package com.project.hrmanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HR_LOGIN_CREDENTIAL")
public class LoginCredential  {

	@Id
	@Column(name="emp_id")
	private Integer empId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="last_login")
	private Date lastLogin;
	
	public LoginCredential() {
		// TODO Auto-generated constructor stub
	}
	

	public LoginCredential(Integer empId, String password, Date lastLogin) {
		super();
		this.empId = empId;
		this.password = password;
		this.lastLogin = lastLogin;
	}
	



	public LoginCredential(Integer empId, String password) {
		super();
		this.empId = empId;
		this.password = password;
	}


	@Override
	public String toString() {
		return "LoginCredential [empId=" + empId + ", password=" + password + ", lastLogin=" + lastLogin + "]";
	}


	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
}
