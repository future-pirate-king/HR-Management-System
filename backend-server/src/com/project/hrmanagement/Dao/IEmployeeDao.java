package com.project.hrmanagement.Dao;

import java.util.List;

import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.LoginCredential;

public interface IEmployeeDao {
	public Employee addEmployee(Employee employee);
	public Employee getEmployee(Integer empId);
	public List<Employee> getAllEmployee();
	public Employee updateEmployee(Employee employee);
	public Employee removeEmployee(Integer empId);
}
