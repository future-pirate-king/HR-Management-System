app.component('announcementListComponent', {
  bindings: {
    announcementList: '=',
    delete: '<'
  },
  templateUrl:
    './src/components/announcement-list-component/announcementList.component.html',
  controller: announcementListController
});

function announcementListController(announcementService, $mdToast) {
  var $ctrl = this;

  $ctrl.deleteAnnouncement = function(id) {
    announcementService.removeAnnouncement(id).then(res => {
      if (res.data) {
        $mdToast.show(
          $mdToast
            .simple()
            .textContent('Announcement deleted successfully.')
            .position('top right')
            .hideDelay(3000)
        );
      }
    });
  };
}
