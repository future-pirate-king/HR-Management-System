app.service('announcementService', function($http) {
  this.addAnnouncement = function(title, body, date) {
    return $http.post('http://localhost:9000/test-server/addAnnouncement', {
      announcementTitle: title,
      announcementBody: body,
      announcementDate: date
    });
  };

  this.getAllAnnouncements = function() {
    return $http.get('http://localhost:9000/test-server/listAllAnnouncement');
  };

  this.removeAnnouncement = function(id) {
    return $http.delete(
      'http://localhost:9000/test-server/removeAnnouncement?announcementId=' +
        id
    );
  };
});
