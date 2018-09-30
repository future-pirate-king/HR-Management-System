package com.project.hrmanagement.service;

import java.util.List;

import com.project.hrmanagement.model.Complaints;

public interface IComplaintsService {
	public Complaints addComplaints(Complaints complaints);
	
	public List<Complaints> listAllComplaints() ;
	
	public Complaints removeComplaints(Integer complaintsId) ;
}
