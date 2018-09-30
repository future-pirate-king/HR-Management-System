package com.project.hrmanagement.Dao;

import java.util.Date;
import java.util.List;

import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.LoginCredential;

public interface IEmployeeLoginDao {
	
	
	public boolean authenticate(LoginCredential logincredential);
	public List<String> getLastLogin(Integer empId);
	public Boolean resetPassword(String newPass, Integer empId);
	public Boolean OtpGenerator();
	public String getEmployeeMail(Integer empId);
	public Boolean OtpVerifier();

}
