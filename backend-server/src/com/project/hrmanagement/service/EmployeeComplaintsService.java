/*package com.project.hrmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hrmanagement.Dao.EmployeeComplaintsDao;
import com.project.hrmanagement.Dao.IEmployeeComplaintsDao;
import com.project.hrmanagement.model.Complaints;

@Service
public class EmployeeComplaintsService implements IEmployeeComplaintsService{

	private IEmployeeComplaintsDao employeeComplaintsDao ;
	
	
	

	public IEmployeeComplaintsDao getEmployeeComplaintsDao() {
		return employeeComplaintsDao;
	}



	

	@Autowired
	public void setEmployeeComplaintsDao(IEmployeeComplaintsDao employeeComplaintsDao) {
		this.employeeComplaintsDao = employeeComplaintsDao;
	}




	@Override
	public Complaints addComplaints(Complaints complaints) {
		return this.employeeComplaintsDao.addComplaints(complaints);
	}

}
*/