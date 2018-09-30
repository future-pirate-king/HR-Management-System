package com.project.hrmanagement.Dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.LoginCredential;

@Repository
public class EmployeeLoginDao implements IEmployeeLoginDao {

	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public boolean authenticate(LoginCredential loginCredential) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select empId,password from LoginCredential where empId=:e and password=:p");

		query.setParameter("e", loginCredential.getEmpId());
		query.setParameter("p", loginCredential.getPassword());

		List<String> empIdList = query.list();

		if (empIdList.isEmpty()) {
			return false;
		} else {
			Date today = Calendar.getInstance().getTime();
			Query query1 = session.createQuery("Update Employee set lastLogin = :llog where empId = :ep");
			query1.setParameter("ep", loginCredential.getEmpId());
			query1.setParameter("llog", today);
			query1.executeUpdate();
			return true;
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> getLastLogin(Integer empId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select lastLogin from LoginCredential where empId=:e");
		query.setParameter("e", empId);
		List<String> lastLogin = query.list();
		
		return lastLogin;
	}

	@Override
	public Boolean resetPassword(String newPass, Integer empId) {
		Session session = sessionFactory.getCurrentSession();
		Query query1 = session.createQuery("Update LoginCredential set password = :p where empId = :ep");
		query1.setParameter("ep", empId);
		query1.setParameter("p", newPass);
		query1.executeUpdate();
		
		
		
		return true;
	}

	@Override
	public Boolean OtpGenerator() {

		return null;
	}

	@Override
	public Boolean OtpVerifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmployeeMail(Integer empId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select email from Employee where empId=:e");

		query.setParameter("e", empId);
		List<String> empIdList = query.list();

		if (empIdList.isEmpty()) {
			return null;
		} else {
			return empIdList.get(0);
		}
	}

}
