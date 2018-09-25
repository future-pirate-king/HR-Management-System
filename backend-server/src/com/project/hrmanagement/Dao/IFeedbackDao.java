package com.project.hrmanagement.Dao;

import java.util.List;

import com.project.hrmanagement.model.Feedback;



public interface IFeedbackDao {

	//add
		public Feedback addFeedback(Feedback feedback);
		
		//listAll
		public List<Feedback> listAllFeedback();
		
		//search
		public Feedback searchFeedback(Long feedbackId);
		
		
		//remove
		public Feedback removeFeedback(Long feedbackId);
		
		
}
