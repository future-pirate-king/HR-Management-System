package com.project.hrmanagement.service;

import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.LoginCredential;

public interface IEmployeeLoginService {

	public boolean authenticate(LoginCredential logincredential);
	public Employee getEmployee(Integer empId);
	

}
