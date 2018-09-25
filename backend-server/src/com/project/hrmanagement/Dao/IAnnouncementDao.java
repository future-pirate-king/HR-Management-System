package com.project.hrmanagement.Dao;

import java.util.List;

import com.project.hrmanagement.model.Announcement;



public interface IAnnouncementDao {
	
	// add
			public Announcement addAnnouncement(Announcement announcement) ;

			
			// list all
			public List<Announcement> listAllAnnouncement() ;
			
			
			
			

			// remove
			public Announcement removeAnnouncement(Long announcementId) ;


}
