app.component('feedbackComponent', {
  bindings: {},
  templateUrl: './src/components/feedback-component/feedback.component.html',
  controller: feedbackController
});

function feedbackController($scope, feedbackService, $stateParams) {
  $scope.rating = 0;
  $scope.ratings = [{
    current: 3,
    max: 5
  }];

  $scope.feedback = {
    feedbackRating: '',
    feedbackCategory: '',
    feedbackDescription: '',
  };

  $scope.getSelectedRating = function (rating) {
    return rating;
  }



  $scope.sendFeedback = function () {
    $scope.feedback.feedbackRating = $scope.ratings[0].current + "/" + $scope.ratings[0].max;
    feedbackService.sendFeedback($scope.feedback, $stateParams.empId)
      .then(res => console.log(res))
  }
}

app.directive('starRating', function () {
  return {
    restrict: 'A',
    template: '<ul class="rating">' +
      '<li ng-repeat="star in stars" ng-class="star" ng-click="toggle($index)">' +
      '\u2605' +
      '</li>' +
      '</ul>',
    scope: {
      ratingValue: '=',
      max: '=',
      onRatingSelected: '&'
    },
    link: function (scope, elem, attrs) {

      var updateStars = function () {
        scope.stars = [];
        for (var i = 0; i < scope.max; i++) {
          scope.stars.push({
            filled: i < scope.ratingValue
          });
        }
      };

      scope.toggle = function (index) {
        scope.ratingValue = index + 1;
        scope.onRatingSelected({
          rating: index + 1
        });
      };

      scope.$watch('ratingValue', function (oldVal, newVal) {
        if (newVal) {
          updateStars();
        }
      });
    }
  }
})