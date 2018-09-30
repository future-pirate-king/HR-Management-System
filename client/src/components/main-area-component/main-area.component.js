app.component('mainAreaComponent', {
  bindings: {},
  templateUrl: './src/components/main-area-component/main-area.component.html',
  controller: mainAreaController
});

function mainAreaController(announcementService) {

  var $ctrl = this;

  $ctrl.announcementList = [];

  this.$onInit = function () {
    announcementService.getAllAnnouncements()
      .then(res => $ctrl.announcementList = res.data);
  }
}
