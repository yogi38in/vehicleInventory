'use strict';

/**
 * CarController
 * @constructor
 */
var CarController = function($scope, $http) {
    
	
	$scope.box1 = $scope.box2 = $scope.box3 = true;
	
	$scope.fetchVehicleList = function() {
        $http.get('vehicle/getVehicleList.json').success(function(vehicleList){
            $scope.vehicles = vehicleList;
        });
    };

    $scope.toggle_visibility = function(id) {
        var e = document.getElementById(id);
        var myClasses = document.querySelectorAll('.masterdata'),
        i = 0,
        l = myClasses.length;
        var isCurrentDisplay = e.style.display;
        for (i; i < l; i++) {
           myClasses[i].style.display = 'none';
        }
        if (isCurrentDisplay == 'none') {
        	e.style.display = 'block';
        }else{
        	e.style.display == 'none'
        }

    };

    $scope.addNewVehicle = function(vehicle) {
        $scope.resetError();

        $http.post('vehicle/addVehicle', vehicle).success(function() {
            $scope.fetchVehicleList();
            $scope.vehicle.vehicle_name = '';
            $scope.vehicle.vehicle_number = '';
            $scope.vehicle.vehicle_model = '';
            $scope.vehicle.vehicle_make = '';
            $scope.vehicle.user_id = '';
            $scope.vehicle.vehicleId = '';
        }).error(function() {
            $scope.setError('Could not add a new vehicle');
        });
    };
    
    $scope.updateVehicle = function(vehicle) {
        $scope.resetError();

        $http.post('vehicle/addVehicle', vehicle).success(function() {
            $scope.fetchVehicleList();
            $scope.vehicle.vehicle_name = '';
            $scope.vehicle.vehicle_number = '';
            $scope.vehicle.vehicle_model = '';
            $scope.vehicle.vehicle_make = '';
            $scope.vehicle.user_id = '';
            $scope.vehicle.vehicleId = '';
        }).error(function() {
            $scope.setError('Could not add a update vehicle');
        });
    };
    

    $scope.removeVehicle = function(id) {
        $scope.resetError();

        $http.delete('vehicle/removeVehicle/' + id).success(function() {
            $scope.fetchVehicleList();
        }).error(function() {
            $scope.setError('Could not remove vehicle');
        });
        if(!$scope.vehicle.vehicle_name==undefined){
        	$scope.vehicle.vehicle_name = '';
            $scope.vehicle.vehicle_number = '';
            $scope.vehicle.vehicle_model = '';
            $scope.vehicle.vehicle_make = '';
            $scope.vehicle.user_id = '';
            $scope.vehicle.vehicleId = '';
        }
        
    };

    $scope.removeAllVehicles = function() {
        $scope.resetError();

        $http.delete('vehicle/removeAllVehicles').success(function() {
            $scope.fetchVehicleList();
        }).error(function() {
            $scope.setError('Could not remove all vehicles');
        });

    };

    $scope.editVehicle = function(vehicle) {
        $scope.resetError();
        $scope.vehicle = vehicle;
        $scope.editMode = true;
    };
    
    

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };
    $scope.fetchVehicleList();

    $scope.predicate = 'id';

    $scope.assignment = {};
    $scope.editMode = false;

    $scope.fetchAssignmentList = function() {
        $http.get('assignment/getAssignmentList.json').success(function(assignmentList){
            $scope.assignments = assignmentList;
        });
    };

    $scope.addNewAssignment = function(assignment) {
        $scope.resetError();

        $http.post('assignment/addAssignment', assignment).success(function() {
            $scope.fetchAssignmentList();
            $scope.assignment.assignment_name = '';
            $scope.assignment.assignment_start_date = '';
            $scope.assignment.assignment_contact = '';
        }).error(function() {
            $scope.setError('Could not add a new assignment');
        });
    };
    
    $scope.editAssignment = function(assignment) {
        $scope.resetError();
        $scope.assignment = assignment;
        $scope.editMode = true;
    };
    
    $scope.updateAssignment = function(assignment) {
        $scope.resetError();

        $http.post('assignment/addAssignment', assignment).success(function() {
            $scope.fetchAssignmentList();
            $scope.assignment.assignment_name = '';
            $scope.assignment.assignment_start_date = '';
            $scope.assignment.assignment_contact = '';
        }).error(function() {
            $scope.setError('Could not add a update assignment');
        });
    };
    

    $scope.removeAssignment = function(id) {
        $scope.resetError();

        $http.delete('assignment/removeAssignment/' + id).success(function() {
            $scope.fetchAssignmentList();
        }).error(function() {
            $scope.setError('Could not remove assignment');
        });
        if(!$scope.assignment.assignment_name==undefined){
        	$scope.assignment.assignment_name = '';
            $scope.assignment.assignment_start_date = '';
            $scope.assignment.assignment_contact = '';
        }
        
    };

    $scope.removeAllAssignments = function() {
        $scope.resetError();

        $http.delete('assignment/removeAllAssignments').success(function() {
            $scope.fetchAssignmentList();
        }).error(function() {
            $scope.setError('Could not remove all assignments');
        });

    };
   
    $scope.fetchAssignmentList();
    
};