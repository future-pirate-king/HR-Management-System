package com.project.hrmanagement.Dao;

import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.LoginCredential;

public interface IEmployeeLoginDao {
	
	
	public boolean authenticate(LoginCredential logincredential);
	public Employee getEmployee(Integer empId);

}
