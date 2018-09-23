app.component('calenderComponent', {
    bindings: {},
    templateUrl: './src/components/calender-component/calender.component.html',
    controller: calenderController
});

function calenderController() {
    var $ctrl = this;
    $ctrl.days = ['mon', 'tue', 'wed', 'thu', 'fri', 'sat', 'sun']

    $ctrl.CALENDAR = function () {
        $ctrl.wrap, $ctrl.label,
            $ctrl.months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];

        $ctrl.init = function (newWrap) {

        }

        $ctrl.switchMonth = function (next, month, year) {

        }

        $ctrl.createCal = function (year, month) {

        }
        $ctrl.createCal.cache = {};
        return {
            init: init,
            switchMonth: switchMonth,
            createCal: createCal
        };
    };
}