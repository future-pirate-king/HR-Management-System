app.service('announcementService', function ($http) {
    this.addAnnouncement = function (title, body, date) {
        return $http.post('http://localhost:9000/backend-server/addAnnouncement', {
            announcementTitle: title,
            announcementBody: body,
            announcementDate: date
        })
    }

    this.getAllAnnouncements = function () {
        return $http.get('http://localhost:9000/backend-server/listAllAnnouncement');
    }

    this.removeAnnouncement = function (id) {
        return $http.delete('http://localhost:9000/backend-server/removeAnnouncement?announcementId=' + id);
    }
})