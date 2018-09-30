package com.project.hrmanagement.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.project.hrmanagement.model.Leave;

@Repository
public class LeaveDao implements ILeaveDao{
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Leave addLeave(Leave leave) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(leave);
		
		return leave;
		
	}

	@Override
	public Leave getLeave(Integer leaveId) {
		Session session = sessionFactory.getCurrentSession();
		Leave l1 = (Leave) session.get(Leave.class, leaveId);
		return l1;
		
	}

	@Override
	public List<Leave> getAllLeaves() {
		Session session=sessionFactory.getCurrentSession();
		 @SuppressWarnings("unchecked")
		List<Leave> leaveList=session.createQuery("from Leave").list();
		 return leaveList;
		
	}

}
