app.component('addEmployeeComponent', {
    bindings: {},
    templateUrl: './src/components/add-employee-component/addEmployee.component.html',
    controller: addEmployeeController,
});

function addEmployeeController(employeeService, $mdToast) {
    var $ctrl = this;
    $ctrl.employee = {
        firstName: 'sam',
        middleName: 'gnana',
        "employeeAddress": {
            "street": 'kurla',
            "city": 'mumbai',
            "state": 'Maharashtra',
            "zipcode": '400024',
            "country": 'India'

        },
        lastName: 'david',
        bloodGroup: 'B+',
        gender: 'Male',
        email: 'sam@gmail.com',
        mobileNo: '56433213135',
        cadre: 'GET',
        dateOfJoining: new Date(),
        bdate: new Date('24-FEB-1996'),
        deptName: 'Development',
        reportingTo: 'Kapil'
    }

    $ctrl.addEmployee = (event) => {
        event.preventDefault();
        $ctrl.isloading = true;
        employeeService.addEmployee($ctrl.employee)
            .then((res) => {
                console.log(res);
                $mdToast.show(
                    $mdToast
                        .simple()
                        .textContent('Employee Added Successfully.')
                        .position('top right')
                        .hideDelay(3000)
                );
                $ctrl.isloading = false
            })
            .catch(err => {
                console.log(err);
                $ctrl.isloading = false
            });
    }
}