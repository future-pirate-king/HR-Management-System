app.component('addAnnouncementComponent', {
  bindings: {},
  templateUrl:
    './src/components/add-announcement-component/addAnnouncement.component.html',
  controller: addAnnouncementController
});

function addAnnouncementController(announcementService, $mdToast) {
  var $ctrl = this;
  $ctrl.announcement = {
    title: '',
    body: '',
    date: new Date().getTime()
  };

  $ctrl.announcementList = [];

  this.$onInit = function() {
    announcementService
      .getAllAnnouncements()
      .then(res => ($ctrl.announcementList = res.data));
  };

  $ctrl.addAnnouncement = function() {
    announcementService
      .addAnnouncement(
        $ctrl.announcement.title,
        $ctrl.announcement.body,
        $ctrl.announcement.date
      )
      .then(res => {
        if (res.data) {
          $mdToast.show(
            $mdToast
              .simple()
              .textContent('Announcement Added successfully.')
              .position('top right')
              .hideDelay(3000)
          );
        }
      });
  };
}
