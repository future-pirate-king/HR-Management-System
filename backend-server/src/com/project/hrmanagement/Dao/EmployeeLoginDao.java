package com.project.hrmanagement.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.LoginCredential;

@Repository
public class EmployeeLoginDao implements IEmployeeLoginDao {

	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public boolean authenticate(LoginCredential loginCredential) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select empId,password from LoginCredential where empId=:e and password=:p");

		query.setParameter("e", loginCredential.getEmpId());
		query.setParameter("p", loginCredential.getPassword());

		List<String> empIdList = query.list();

		if (empIdList.isEmpty()) {
			return false;
		}

		return true;

	}

	@Override
	@Transactional
	public Employee getEmployee(Integer empId) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.get(Employee.class, empId);
		return emp;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
