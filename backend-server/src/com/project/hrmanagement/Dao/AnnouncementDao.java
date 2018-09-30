package com.project.hrmanagement.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hrmanagement.model.Announcement;



@Repository
public class AnnouncementDao implements IAnnouncementDao {
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

		// add
			@Override
			public Announcement addAnnouncement(Announcement announcement) {
				Session session = sessionFactory.getCurrentSession();
				session.save(announcement);
				
				return announcement;
				
			}

			
		
			
			
			// list all
			@Override
			public List<Announcement> listAllAnnouncement(){
				Session session=sessionFactory.getCurrentSession();
				 @SuppressWarnings("unchecked")
				List<Announcement> announcementList=session.createQuery("from Announcement").list();
				 return announcementList;
				
			}
			
		
			
			// remove
			@Override
			public Announcement removeAnnouncement(Long announcementId) {
				Session session= sessionFactory.getCurrentSession();
				Announcement a1 =(Announcement) session.load(Announcement.class, announcementId);
				Announcement a2=(Announcement) session.get(Announcement.class, announcementId);
				if(a2!=null) {
				session.delete(a1);
				
				}
				session.close();
				return null;
			}

}

