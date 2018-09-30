app.service('feedbackService', function ($http) {
    this.sendFeedback = function (feedback, empId) {
        return $http.post('http://localhost:9000/backend-server/addFeedback', {
            feedbackRating: feedback.feedbackRating,//feedback.feedbackRating,
            feedbackCategory: feedback.feedbackCategory,
            feedbackDescription: feedback.feedbackDescription,
            empId: empId
        })
    }

    this.getAllFeedback = () => {
        return $http.get('http://localhost:9000/backend-server/listAllFeedback')
    }
})