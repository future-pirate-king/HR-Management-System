package com.project.hrmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hrmanagement.Dao.IEmployeeDao;
import com.project.hrmanagement.Dao.IEmployeeLoginDao;
import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.LoginCredential;

@Service
public class EmployeeLoginService implements IEmployeeLoginService {

	IEmployeeLoginDao EmployeeLoginDao;

	private IEmployeeDao empDao;

	public IEmployeeDao getEmpDao() {
		return empDao;
	}

	@Autowired
	public void setEmpDao(IEmployeeDao empDao) {
		this.empDao = empDao;
	}

	public IEmployeeLoginDao getEmployeeLoginDao() {
		return EmployeeLoginDao;
	}

	@Autowired
	public void setEmployeeLoginDao(IEmployeeLoginDao employeeLoginDao) {
		EmployeeLoginDao = employeeLoginDao;
	}

	@Override
	public boolean authenticate(LoginCredential logincredential) {

		return this.empDao.authenticate(logincredential);
	}

	@Override
	public Employee getEmployee(Integer empId) {

		return this.empDao.getEmployee(empId);
	}

}
