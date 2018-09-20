package com.project.hrmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hrmanagement.Dao.IEmployeeDao;
import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.LoginCredential;

@Service
public class EmployeeService implements IEmployeeService {
	
	
	private IEmployeeDao empDao;

	public IEmployeeDao getEmpDao() {
		return empDao;
	}

	@Autowired
	public void setEmpDao(IEmployeeDao empDao) {
		this.empDao = empDao;
	}

	@Override
	public Employee authenticate(LoginCredential logincredential) {
		
		return this.empDao.authenticate(logincredential);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		return this.empDao.addEmployee(employee);
	}

	@Override
	public Employee getEmployee(Integer empId) {
		
		return this.empDao.getEmployee(empId);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return this.empDao.getAllEmployee();
	}

	@Override
	public Employee updateEmployee(Integer empId, Employee employee) {
		
		return this.empDao.updateEmployee(empId, employee);
	}

	@Override
	public Employee removeEmployee(Integer empId) {
		
		return this.empDao.removeEmployee(empId);
	}

}
