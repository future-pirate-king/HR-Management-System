app.component('complaintListComponent', {
  bindings: {},
  templateUrl:
    './src/components/complaint-list-component/complaintList.component.html',
  controller: complaintListController
});

function complaintListController(complaintService, $stateParams) {
  var $ctrl = this;
  $ctrl.complaintList = [];

  this.$onInit = function() {
    complaintService.getAllComplaints().then(res => {
      $ctrl.complaintList = res.data;
    });
  };
}
