package com.project.hrmanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrmanagement.model.Feedback;
import com.project.hrmanagement.service.IFeedbackService;



//---------working-------//
//add feedback  (needs changes as to accept data from json obj)
//list feedback  (needs changes as to accept data from json obj)





@RestController
public class FeedbackController {
	
	@Autowired
	private IFeedbackService feedbackService;

	@RequestMapping("/addFeedback")
	
	public Feedback addFeedback() {	
		//Integer emp_Id = 35;
		Feedback f1 = new Feedback((long)151,"nikita",(int)1);
	return this.feedbackService.addFeedback(f1);
		}
	
	@RequestMapping("/listAllFeedback")
	public List<Feedback> listAllFeedback() {	
	return this.feedbackService.listAllFeedback();

		}
	
	@RequestMapping("/searchFeedback")
	public Feedback getFeedback(@RequestParam("feedbackId") Long feedbackId) {
	if (feedbackId != null) {
		Feedback feedback = feedbackService.searchFeedback(feedbackId);
	if (feedback != null) {	
	return feedback;
	}
		
}
	return null;
	}
	
	@RequestMapping("removeFeedback")
	public String remove(@RequestParam("feedbackId") Long feedbackId) {
	if (feedbackId != null) {		
	Feedback feedback = feedbackService.removeFeedback(feedbackId);			
	if (feedback != null) {				
	String st = "sucess";			
	return st;
		}
	}	
	return "feedback with requested ID does not exist";
		}

	

}
