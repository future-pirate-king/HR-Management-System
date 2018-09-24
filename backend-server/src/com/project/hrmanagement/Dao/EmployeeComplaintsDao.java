/*package com.project.hrmanagement.Dao;

import java.util.ArrayList;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.hrmanagement.model.Complaints;
import com.project.hrmanagement.model.Employee;
@Repository
public class EmployeeComplaintsDao implements IEmployeeComplaintsDao {
	private SessionFactory sessionFactory;
	
	

	public SessionFactory getFactory() {
		return sessionFactory;
	}


	@Autowired
	public void setFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	@Transactional
	public Complaints addComplaints(Complaints complaints) {
	Session session = sessionFactory.getCurrentSession();
	String s = "Your complaint has been logged successfully";
	System.out.println(s);
		Employee emp = new Employee();
	HashSet<Complaints> comps = new HashSet<Complaints>();
	System.out.println(complaints);
		emp.setComplaints(comps);
		
		
		session.save(complaints); 
		return complaints;
		
		
		
	}

}
*/