package com.project.hrmanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="HR_LOGIN_CREDENTIAL")
public class LoginCredential {
	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen",strategy="foreign",
	parameters=@Parameter(name="property",value="employee"))
	@Column(name="emp_id")
	private Integer empId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="last_login")
	private Date lastLogin;
	
	@JsonIgnore
	@OneToOne
	@PrimaryKeyJoinColumn
	private Employee employee;
	

	
	public LoginCredential() {
		
	}
	

	public LoginCredential(Integer empId, String password) {
		super();
		this.empId = empId;
		this.password = password;
	}


	public LoginCredential(String password) {
		super();
		this.password = password;
	}


	public LoginCredential(String password, Date lastLogin) {
		super();
		this.password = password;
		this.lastLogin = lastLogin;
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


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
