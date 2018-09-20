
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
public class EmployeeDao implements IEmployeeDao {
	
	
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
	public Employee authenticate(LoginCredential loginCredential) {
		
		//System.out.println(loginCredential.getEmpId() + ' ' + loginCredential.getPassword());

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select empId,password from LoginCredential where empId=:e and password=:p");

		query.setParameter("e", loginCredential.getEmpId());
		query.setParameter("p", loginCredential.getPassword());

		List<String> empIdList = query.list();
		
		Employee emp = (Employee) session.load(Employee.class, loginCredential.getEmpId());

		if (empIdList.isEmpty()) {
			return null;
		}
		return emp;
	

	}

	@Override
	@Transactional
	public Employee addEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
		return employee;
	}

	@Override
	@Transactional
	public Employee getEmployee(Integer empId) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.load(Employee.class, empId);
		return emp;
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		Session session = sessionFactory.getCurrentSession();
		List<Employee> empList = session.createQuery("from Employee").list();
		return empList;
	}

	@Override
	@Transactional
	public Employee updateEmployee(Integer empId, Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.load(Employee.class, empId);
		
		if(emp != null)
		{
			session.update(employee);
			return emp;
		}
		
		return null;
	}

	@Override
	@Transactional
	public Employee removeEmployee(Integer empId) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.load(Employee.class, empId);
		if(emp !=null) {
			session.delete(emp);
			return emp;
		} 
		
		return null;
	}}
