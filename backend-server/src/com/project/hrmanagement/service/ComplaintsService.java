package com.project.hrmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.hrmanagement.Dao.IComplaintsDao;
import com.project.hrmanagement.model.Complaints;

@Service
public class ComplaintsService implements IComplaintsService {

	private IComplaintsDao complaintsDao;

	public IComplaintsDao getComplaintsDao() {
		return complaintsDao;
	}

	@Autowired
	public void setComplaintsDao(IComplaintsDao complaintsDao) {
		this.complaintsDao = complaintsDao;
	}

	@Override
	@Transactional
	public Complaints addComplaints(Complaints complaints) {
		return this.complaintsDao.addComplaints(complaints);
	}

	@Override
	@Transactional
	public List<Complaints> listAllComplaints() {

		return this.complaintsDao.listAllComplaints();
	}

	@Override
	@Transactional
	public Complaints removeComplaints(Integer complaintsId) {
		complaintsDao.removeComplaints(complaintsId);
		return null;
	}

}
