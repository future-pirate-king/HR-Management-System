package com.project.hrmanagement.controller;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrmanagement.model.Announcement;
import com.project.hrmanagement.service.IAnnouncementService;


//---------working-----------------//
//add announcement (needs changes as to accept data from json obj)
//list all  (needs changes as to accept data from json obj)





@RestController
@RequestMapping("/Announcement")
public class AnnouncementController {
	
	@Autowired
	private IAnnouncementService announcementService;
	
	@RequestMapping("/addAnnouncement")
	public Announcement addAnnouncement() {
		@SuppressWarnings("deprecation")
		Announcement a1 =new Announcement(new Date("16-AUG-2017"),"important announcement","holiday","unread");
		return this.announcementService.addAnnouncement(a1);
		 		
	}
	
	@RequestMapping("/listAllAnnouncement")
	public List<Announcement> listAllAnnouncements() {	
	return this.announcementService.listAllAnnouncement();

		}
	
	
	@RequestMapping("removeAnnouncement")
	public String remove(@RequestParam("announcementId") Long announcementId) {
		if (announcementId != null) {
			Announcement a = announcementService.removeAnnouncement(announcementId);
			if (a != null) {
				String st = "sucess";
				return st;
			}
		}
		return "announcement with requested ID does not exist";
	}
}
