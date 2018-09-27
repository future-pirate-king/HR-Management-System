app.component('employeeDetailsComponent', {
    bindings: {
        employee: '<'
    },
    templateUrl: './src/components/employee-details-component/employeeDetails.component.html',
    controller: employeeDetailsController
});

function employeeDetailsController(employeeService, $mdToast) {
    $ctrl = this;

    $ctrl.deleteEmployee = function () {
        employeeService.deleteEmployee($ctrl.employee.empId)
            .then(res => {
                console.log(res);
                $mdToast.show(
                    $mdToast
                        .simple()
                        .textContent(res.data)
                        .position('top right')
                        .hideDelay(3000)
                );
            })
            .catch(err => console.log(err));
    }
}