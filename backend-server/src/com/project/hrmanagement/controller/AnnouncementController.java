package com.project.hrmanagement.controller;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrmanagement.model.Announcement;
import com.project.hrmanagement.service.IAnnouncementService;


//---------working-----------------//
//add announcement (needs changes as to accept data from json obj)
//list all  (needs changes as to accept data from json obj)





@RestController
public class AnnouncementController {
	
	
	private IAnnouncementService announcementService;
	
	
	@RequestMapping(value="/addAnnouncement", method= RequestMethod.POST)
	public Announcement addAnnouncement(@RequestBody Announcement announcement) {
		
		
		return this.announcementService.addAnnouncement(announcement);
		 		
	}
	
	@RequestMapping("/listAllAnnouncement")
	public List<Announcement> listAllAnnouncement() {	
	return this.announcementService.listAllAnnouncement();

		}
	
	
	@RequestMapping("removeAnnouncement")
	public boolean remove(@RequestParam("announcementId") Long announcementId) {
		if (announcementId != null) {
			Announcement a = announcementService.removeAnnouncement(announcementId);
			if (a != null) {
				
				return true;
			}
		}
		return false;
	}

	public IAnnouncementService getAnnouncementService() {
		return announcementService;
	}
	
	@Autowired
	public void setAnnouncementService(IAnnouncementService announcementService) {
		this.announcementService = announcementService;
	}
	
	
	
}
