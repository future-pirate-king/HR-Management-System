package com.project.hrmanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.hrmanagement.Dao.IFeedbackDao;
import com.project.hrmanagement.model.Feedback;


@Service
public class FeedbackService implements IFeedbackService {
	private IFeedbackDao feedbackDao;

	public IFeedbackDao getFeedbackDao() {
		return feedbackDao;
	}

	@Autowired
	public void setFeedbackDao(IFeedbackDao feedbackDao) {
		this.feedbackDao = feedbackDao;
	}

	@Override
	@Transactional
	public Feedback addFeedback(Feedback feedback) {
		return feedbackDao.addFeedback(feedback);
	}

	@Override
	@Transactional
	public List<Feedback> listAllFeedback() {
		return feedbackDao.listAllFeedback();
	}

	@Override
	@Transactional
	public Feedback searchFeedback(Long feedbackId) {
		return feedbackDao.searchFeedback(feedbackId);
	}

	@Override
	@Transactional
	public Feedback removeFeedback(Long feedbackId) {
		feedbackDao.removeFeedback(feedbackId);
		return null;
	}

}
