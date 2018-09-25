package com.project.hrmanagement.service;

import java.util.List;

import com.project.hrmanagement.model.Announcement;

public interface IAnnouncementService {
	
				// add
				public Announcement addAnnouncement(Announcement announcement) ;

		

				// list all
				public List<Announcement> listAllAnnouncement() ;
				
				

				// remove
				public Announcement removeAnnouncement(Long announcementId) ;

}
