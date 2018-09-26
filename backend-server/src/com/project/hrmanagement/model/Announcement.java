package com.project.hrmanagement.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HR_ANNOUNCEMENT")
public class Announcement implements Serializable{
	
	/*CREATE TABLE HR_ANNOUNCEMENT(
		    announcement_id VARCHAR2(100) PRIMARY KEY,
		    announcement_date TIMESTAMP,
		    announcement_title VARCHAR2(100) NOT NULL,
		    announcement_body VARCHAR2(250) NOT NULL,
		    announcement_status VARCHAR2(10)
		)
*/
	
	
	private static final long serialVersionUID = 4564361269569373653L;
	
	@Id
	@Column(name="announcement_id")
	@SequenceGenerator(name="id", initialValue=0000, allocationSize=100)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id")
	private Long announcementId;
	//(strategy = GenerationType.SEQUENCE, generator= "HR_ANNOUNCEMENT_GEN")
	//@SequenceGenerator(name="HR_ANNOUNCEMENT_GEN", sequenceName="HR_ANNOUNCEMENT_SEQ",allocationSize=1)
	
	@Column(name="announcement_date")
	private Date announcementDate;
	
	@Column(name="announcement_title")
	private String announcementTitle;
	
	@Column(name="announcement_body")
	private String announcementBody;
	
	@Column(name="announcement_status")
	private String announcementStatus;

	
	
	
	public Announcement() {
		
		
	}

	public Announcement(Date announcementDate, String announcementTitle, String announcementBody,
			String announcementStatus) {
		super();
		
		this.announcementDate = announcementDate;
		this.announcementTitle = announcementTitle;
		this.announcementBody = announcementBody;
		this.announcementStatus = announcementStatus;
	}

	public Long getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(Long announcementId) {
		this.announcementId = announcementId;
	}

	public Date getAnnouncementDate() {
		return announcementDate;
	}

	public void setAnnouncementDate(Date announcementDate) {
		this.announcementDate = announcementDate;
	}

	public String getAnnouncementTitle() {
		return announcementTitle;
	}

	public void setAnnouncementTitle(String announcementTitle) {
		this.announcementTitle = announcementTitle;
	}

	public String getAnnouncementBody() {
		return announcementBody;
	}

	public void setAnnouncementBody(String announcementBody) {
		this.announcementBody = announcementBody;
	}

	public String getAnnouncementStatus() {
		return announcementStatus;
	}

	public void setAnnouncementStatus(String announcementStatus) {
		this.announcementStatus = announcementStatus;
	}

	@Override
	public String toString() {
		return "Announcement [announcementId=" + announcementId + ", announcementDate=" + announcementDate
				+ ", announcementTitle=" + announcementTitle + ", announcementBody=" + announcementBody
				+ ", announcementStatus=" + announcementStatus + "]";
	}
	
	


}
