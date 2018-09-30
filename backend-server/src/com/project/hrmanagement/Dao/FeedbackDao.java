package com.project.hrmanagement.Dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hrmanagement.model.Feedback;


@Repository
public class FeedbackDao implements IFeedbackDao {
private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Feedback addFeedback(Feedback feedback) {
		Session session = sessionFactory.getCurrentSession();
		session.save(feedback);
		
		
		return feedback;
		
	
	}

	@Override
	public List<Feedback> listAllFeedback() {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Feedback> feedbackList=session.createQuery("from Feedback").list();
		return feedbackList;
		
	}
	
	@Override
	public Feedback searchFeedback(Integer feedbackId) {
		Session session= sessionFactory.getCurrentSession();
		Feedback searchFeedback=(Feedback)session.get(Feedback.class, feedbackId);
		session.close();
		
		return searchFeedback;
		
	}

	@Override
	public Feedback removeFeedback(Integer feedbackId) {
		Session session= sessionFactory.getCurrentSession();
		Feedback f1 = (Feedback) session.load(Feedback.class, feedbackId);
		Feedback f2 = (Feedback) session.get(Feedback.class, feedbackId);
		if (f2 != null) {
			session.delete(f1);
			return f1;
		}
		return null;
	}
		
	}


