app.component('feedbackListComponent', {
  bindings: {},
  templateUrl:
    './src/components/feedback-list-component/feedbackList.component.html',
  controller: complaintListController
});

function complaintListController(feedbackService, $stateParams) {
  var $ctrl = this;
  $ctrl.feedbackList = [];

  this.$onInit = function() {
    feedbackService.getAllFeedback().then(res => {
      $ctrl.feedbackList = res.data;
      console.log(res.data);
    });
  };
}
