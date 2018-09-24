package com.project.hrmanagement.Dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hrmanagement.model.TimeSheet;

@Repository
public class EmployeeTimeSheetDao implements IEmployeeTimeSheetDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public TimeSheet addTimeSheet(TimeSheet timeSheet) {

		return null;
	}

	@Override
	@Transactional
	public TimeSheet editTimeSheet(TimeSheet timeSheet) {
		Session session = sessionFactory.getCurrentSession();
		session.save(timeSheet);

		return timeSheet;
	}

	@Override
	public void deleteTimeSheet() {
		// TODO Auto-generated method stub

	}


}
