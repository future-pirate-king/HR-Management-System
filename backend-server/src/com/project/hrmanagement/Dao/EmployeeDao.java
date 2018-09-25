
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

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public boolean authenticate(LoginCredential loginCredential) {

		// System.out.println(loginCredential.getEmpId() + ' ' +
		// loginCredential.getPassword());

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
	public Employee addEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();

		LoginCredential loginCredential = new LoginCredential("Newuser");
		loginCredential.setEmployee(employee);
		session.save(employee);
		session.save(loginCredential);

		return employee;
	}

	@Override
	@Transactional
	public Employee getEmployee(Integer empId) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.get(Employee.class, empId);
		return emp;
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Employee> empList = session.createQuery("from Employee").list();
		return empList;
	}

	@Override
	@Transactional
	public Employee updateEmployee(Integer empId, Employee employee) {

		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.load(Employee.class, empId);

		if (emp != null) {
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
		Employee emp1 = (Employee) session.get(Employee.class, empId);
		if (emp1 != null) {
			session.delete(emp);
			return emp;
		}

		return null;
	}
}
