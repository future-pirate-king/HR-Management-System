app.component('complaintComponent', {
  bindings: {},
  templateUrl: './src/components/complaint-component/complaint.component.html',
  controller: complaintController
});

function complaintController() {
  var $ctrl = this;

  $ctrl.hello = 'hello';
}
