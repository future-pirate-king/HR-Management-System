package com.project.hrmanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrmanagement.model.Feedback;
import com.project.hrmanagement.service.IFeedbackService;



//---------working-------//
//add feedback  (needs changes as to accept data from json obj)
//list feedback  (needs changes as to accept data from json obj)





@RestController
public class FeedbackController {
	
	
	private IFeedbackService feedbackService;

	@RequestMapping(value="/addFeedback", method=RequestMethod.POST, consumes = "application/json")
	public Feedback addFeedback(@RequestBody Feedback feedback) {	
		
		/*Feedback fs = new Feedback("as","SAda", "asda");*/
	
	return this.feedbackService.addFeedback(feedback);
		}
	
	@RequestMapping("/listAllFeedback")
	public List<Feedback> listAllFeedback() {	
	return this.feedbackService.listAllFeedback();

		}
	
	@RequestMapping("/searchFeedback")
	public Feedback getFeedback(@RequestParam("feedbackId") Integer feedbackId) {
	if (feedbackId != null) {
		Feedback feedback = feedbackService.searchFeedback(feedbackId);
	if (feedback != null) {	
	return feedback;
	}
		
}
	return null;
	}
	
	@RequestMapping("removeFeedback")
	public String remove(@RequestParam("feedbackId") Integer feedbackId) {
	if (feedbackId != null) {		
	Feedback feedback = feedbackService.removeFeedback(feedbackId);			
	if (feedback != null) {				
	String st = "sucess";			
	return st;
		}
	}	
	return "feedback with requested ID does not exist";
		}

	public IFeedbackService getFeedbackService() {
		return feedbackService;
	}
	
	@Autowired
	public void setFeedbackService(IFeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}

	

}
