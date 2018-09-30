app.service('complaintService', function($http) {
  this.addComplaint = (complaint, empId) => {
    return $http.post('http://localhost:9000/test-server/addComplaints', {
      complaintType: complaint.complaintsType,
      complaintDescription: complaint.complaintDescription,
      complaintStatus: false,
      empId: empId
    });
  };

  this.getAllComplaints = () => {
    return $http.get('http://localhost:9000/test-server/listAllComplaints');
  };
});
