package com.project.hrmanagement.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.project.hrmanagement.model.Complaints;

@Repository
public class ComplaintsDao implements IComplaintsDao {
	private SessionFactory sessionFactory;

	public SessionFactory getFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Complaints addComplaints(Complaints complaints) {
		Session session = sessionFactory.getCurrentSession();
		session.save(complaints);

		return complaints;

	}

	@Override
	public List<Complaints> listAllComplaints() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Complaints> complaintsList = session.createQuery("from Complaints").list();
		return complaintsList;

	}

	@Override
	public Complaints removeComplaints(Integer complaintId) {
		Session session = sessionFactory.getCurrentSession();
		Complaints c1 = (Complaints) session.load(Complaints.class, complaintId);
		Complaints c2 = (Complaints) session.get(Complaints.class, complaintId);
		if (c2 != null) {
			session.delete(c1);

		}

		return null;
	}

}
