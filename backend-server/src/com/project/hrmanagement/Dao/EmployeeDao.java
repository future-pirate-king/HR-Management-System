
package com.project.hrmanagement.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public Employee addEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();

		LoginCredential loginCredential = new LoginCredential("Newuser");
		loginCredential.setEmployee(employee);
		session.save(employee);
		session.save(loginCredential);

		return employee;
	}

	@Override
	public Employee getEmployee(Integer empId) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.get(Employee.class, empId);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Employee> empList = session.createQuery("from Employee").list();
		return empList;
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.get(Employee.class, employee.getEmpId());
		if (emp != null) {
			session.update(emp);
			return emp;
		}

		return null;
	}

	@Override
	public Employee removeEmployee(Integer empId) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.get(Employee.class, empId);
		if (emp != null) {
			session.delete(emp);
			return emp;
		}

		return null;
	}
}
