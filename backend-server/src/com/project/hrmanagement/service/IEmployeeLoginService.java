package com.project.hrmanagement.service;

import java.util.Date;
import java.util.List;

import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.LoginCredential;

public interface IEmployeeLoginService {

	public boolean authenticate(LoginCredential logincredential);
	public List<String> getLastLogin(Integer empId);
	public Boolean resetPassword(String newPass,Integer empId);
	public Boolean OtpGenerator();
	public Boolean OtpVerifier();
	public String getEmployeeMail(Integer empId);

}
