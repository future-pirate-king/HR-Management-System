app.component('announcementListComponent', {
    bindings: {
        announcementList: '=',
        delete: '<'
    },
    templateUrl: './src/components/announcement-list-component/announcementList.component.html',
    controller: announcementListController
});

function announcementListController(announcementService) {
    var $ctrl = this;

    $ctrl.deleteAnnouncement = function (id) {
        announcementService.removeAnnouncement(id);
    }
}