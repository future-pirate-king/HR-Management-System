app.component('complaintComponent', {
  bindings: {},
  templateUrl: './src/components/complaint-component/complaint.component.html',
  controller: complaintController
});

function complaintController(complaintService, $stateParams, $mdToast) {
  var $ctrl = this;

  $ctrl.complaint = {
    complaintsType: 'Service',
    complaintDescription: ''
  };

  $ctrl.addComplaint = () => {
    complaintService
      .addComplaint($ctrl.complaint, $stateParams.empId)
      .then(res => {
        $mdToast.show(
          $mdToast
            .simple()
            .textContent('Complaint Added successfully.')
            .position('bottom left')
            .hideDelay(3000)
        );
        $ctrl.complaint.complaintsType = 'Service';
        $ctrl.complaint.complaintDescription = '';
      });
  };
}
