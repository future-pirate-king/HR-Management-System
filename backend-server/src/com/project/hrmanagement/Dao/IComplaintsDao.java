package com.project.hrmanagement.Dao;

import java.util.List;

import com.project.hrmanagement.model.Complaints;

public interface IComplaintsDao {

	public Complaints addComplaints(Complaints complaints);
	
   public List<Complaints> listAllComplaints() ;
	
	public Complaints removeComplaints(Integer complaintId) ;
}
