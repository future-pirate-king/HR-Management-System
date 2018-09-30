app.component('complaintComponent', {
  bindings: {},
  templateUrl: './src/components/complaint-component/complaint.component.html',
  controller: complaintController
});

function complaintController(complaintService, $stateParams) {
  var $ctrl = this;

  $ctrl.complaint = {
    complaintsType: '',
    complaintDescription: ''
  };

  this.$onInit = async () => console.log(await complaintService.getAllComplaints())

  $ctrl.addComplaint = () => {
    console.log($ctrl.complaint);
    complaintService.addComplaint($ctrl.complaint, $stateParams.empId)
      .then(res => console.log(res))
  };
}
