app.component('hrHomeComponent', {
    bindings: {},
    templateUrl: './src/components/hr-home-component/hr-home.component.html',
    controller: hrHomeController,
});

function hrHomeController(employeeService, $stateParams, $state) {
    var $ctrl = this;

    $ctrl.mode = 'hr';
    this.$onInit = function () {
        $state.go(
            'hr_home.employee',
            { empId: $stateParams.empId },
            { notify: false, location: 'replace' }
        );
    };
}