package com.project.hrmanagement.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.hrmanagement.Dao.IAnnouncementDao;

import com.project.hrmanagement.model.Announcement;

@Service
public class AnnouncementService implements IAnnouncementService {
	
	
	private IAnnouncementDao announcementDao;
	

	public IAnnouncementDao getAnnouncementDao() {
		return announcementDao;
	}
	
	@Autowired
	public void setAnnouncementDao(IAnnouncementDao announcementDao) {
		this.announcementDao = announcementDao;
	}

	@Override
	@Transactional
	public Announcement addAnnouncement(Announcement announcement) {
	 
	return this.announcementDao.addAnnouncement(announcement);
	}

	

	@Override
	@Transactional
	public List<Announcement> listAllAnnouncement() {
		
		return this.announcementDao.listAllAnnouncement();
	}

	

	@Override
	@Transactional
	public Announcement removeAnnouncement(Long announcementId) {
		announcementDao.removeAnnouncement(announcementId);
		return null;
		
	}
}