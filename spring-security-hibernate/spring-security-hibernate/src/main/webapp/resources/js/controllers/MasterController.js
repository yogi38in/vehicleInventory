'use strict';

/**
 * MasterController
 * @constructor
 */

var MasterController = function($scope, $filter, $http) {
    
	
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
            $scope.editMode = false;
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
        if(!$scope.vehicle==undefined && !$scope.vehicle.vehicle_name==undefined){
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
    $scope.editModeAssignment = false;

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
            $scope.assignment.assignment_id = '';
            $scope.assignment.rate = '';
        }).error(function() {
            $scope.setError('Could not add a new assignment');
        });
    };
    
    $scope.editAssignment = function(assignment) {
        $scope.resetError();
        $scope.assignment = assignment;
        for (var i = 0, len = $scope.rates.length; i < len; i++) {
        	  if ($scope.rates[i].rate_id == assignment.rate.rate_id) { // Your own property here: 
        	    $scope.assignment.rate = $scope.rates[i];
        	    break;
        	  }
        	}
        $scope.editModeAssignment = true;
    };
    
    $scope.updateAssignment = function(assignment) {
        $scope.resetError();

        $http.post('assignment/addAssignment', assignment).success(function() {
            $scope.fetchAssignmentList();
            $scope.assignment.assignment_name = '';
            $scope.assignment.assignment_start_date = '';
            $scope.assignment.assignment_contact = '';
            $scope.assignment.assignment_id = '';
            $scope.editModeAssignment = false;
            $scope.assignment.rate = '';
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
            $scope.assignment.assignment_id = '';
            $scope.assignment.rate = '';
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
    
    //////////////RATES////////////////////////
    
    $scope.rate = {};
    $scope.editModeRate = false;

    $scope.fetchRateList = function() {
        $http.get('rate/getRateList.json').success(function(rateList){
            $scope.rates = rateList;
        });
    };

    $scope.addNewRate = function(rate) {
        $scope.resetError();

        $http.post('rate/addRate', rate).success(function() {
            $scope.fetchRateList();
            $scope.rate.rate_name = '';
            $scope.rate.energy_source_name = '';
            $scope.rate.rate_charged = '';
            $scope.rate.rate_id = '';
        }).error(function() {
            $scope.setError('Could not add a new rate');
        });
    };
    
    $scope.editRate = function(rate) {
        $scope.resetError();
        $scope.rate = rate;
        $scope.editModeRate = true;
    };
    
    $scope.updateRate = function(rate) {
        $scope.resetError();

        $http.post('rate/addRate', rate).success(function() {
            $scope.fetchRateList();
            $scope.rate.rate_name = '';
            $scope.rate.energy_source_name = '';
            $scope.rate.rate_charged = '';
            $scope.rate.rate_id = '';
            $scope.editModeRate = false;
        }).error(function() {
            $scope.setError('Could not add a update rate');
        });
    };
    

    $scope.removeRate = function(id) {
        $scope.resetError();

        $http.delete('rate/removeRate/' + id).success(function() {
            $scope.fetchRateList();
        }).error(function() {
            $scope.setError('Could not remove rate');
        });
        if(!$scope.rate.rate_name==undefined){
        	 $scope.rate.rate_name = '';
             $scope.rate.energy_source_name = '';
             $scope.rate.rate_charged = '';
             $scope.rate.rate_id = '';
        }
        
    };

    $scope.removeAllRates = function() {
        $scope.resetError();

        $http.delete('rate/removeAllRates').success(function() {
            $scope.fetchRateList();
        }).error(function() {
            $scope.setError('Could not remove all rates');
        });

    };
   
    $scope.fetchRateList();
    
    //////////////////Vehicle Assignment////////////////////
    
    $scope.vehicleAssignment = {};
    $scope.editModeVehicleAssignment = false;

    $scope.fetchVehicleAssignmentList = function() {
        $http.get('vehicleAssignment/getVehicleAssignmentList.json').success(function(vehicleAssignmentList){
            $scope.vehicleAssignments = vehicleAssignmentList;
        });
    };

    $scope.addNewVehicleAssignment = function(vehicleAssignment) {
        $scope.resetError();

        $http.post('vehicleAssignment/addVehicleAssignment', vehicleAssignment).success(function() {
            $scope.fetchVehicleAssignmentList();
            $scope.vehicleAssignment.vehicle = '';
            $scope.vehicleAssignment.rate = '';
            $scope.vehicleAssignment.assignment = '';
            $scope.vehicleAssignment.vehicle_assignment_id = '';
            $scope.vehicleAssignment.assignment_start_date = '';
            $scope.vehicleAssignment.assignment_end_date = '';
        }).error(function() {
            $scope.setError('Could not add a new vehicleAssignment');
        });
    };
    
    $scope.editVehicleAssignment = function(vehicleAssignment) {
        $scope.resetError();
        $scope.editModeVehicleAssignment = true;
        $scope.vehicleAssignment.vehicle_assignment_id = vehicleAssignment.vehicle_assignment_id ;
        $scope.vehicleAssignment.assignment_start_date = new Date($filter('date')(vehicleAssignment.assignment_start_date, 'dd MMMM yyyy'));// ;
        $scope.vehicleAssignment.assignment_end_date = new Date($filter('date')(vehicleAssignment.assignment_end_date, 'dd MMMM yyyy')) ;
        
        for (var i = 0, len = $scope.vehicles.length; i < len; i++) {
        	  if ($scope.vehicles[i].vehicleId == vehicleAssignment.vehicle.vehicleId) { // Your own property here: 
        	    $scope.vehicleAssignment.vehicle = $scope.vehicles[i];
        	    break;
        	  }
        	}
        
        for (var i = 0, len = $scope.rates.length; i < len; i++) {
      	  if ($scope.rates[i].rate_id == vehicleAssignment.rate.rate_id) { // Your own property here: 
      	    $scope.vehicleAssignment.rate = $scope.rates[i];
      	    break;
      	  }
      	}
        
        for (var i = 0, len = $scope.assignments.length; i < len; i++) {
        	  if ($scope.assignments[i].assignment_id == vehicleAssignment.assignment.assignment_id) { // Your own property here: 
        	    $scope.vehicleAssignment.assignment = $scope.assignments[i];
        	    break;
        	  }
        }
    };
    
    $scope.updateVehicleAssignment = function(vehicleAssignment) {
        $scope.resetError();

        $http.post('vehicleAssignment/addVehicleAssignment', vehicleAssignment).success(function() {
            $scope.fetchVehicleAssignmentList();
            $scope.vehicleAssignment.vehicle = '';
            $scope.vehicleAssignment.rate = '';
            $scope.vehicleAssignment.assignment = '';
            $scope.vehicleAssignment.vehicle_assignment_id = '';
            $scope.vehicleAssignment.assignment_start_date = '';
            $scope.vehicleAssignment.assignment_end_date = '';
            $scope.editModeVehicleAssignment = false;
        }).error(function() {
            $scope.setError('Could not add a update vehicleAssignment');
        });
    };
    

    $scope.removeVehicleAssignment = function(id) {
        $scope.resetError();

        $http.delete('vehicleAssignment/removeVehicleAssignment/' + id).success(function() {
            $scope.fetchVehicleAssignmentList();
        }).error(function() {
            $scope.setError('Could not remove vehicleAssignment');
        });
        if(!$scope.vehicleAssignment.vehicleAssignment_name==undefined){
        	$scope.vehicleAssignment.vehicle = '';
            $scope.vehicleAssignment.rate = '';
            $scope.vehicleAssignment.assignment = '';
            $scope.vehicleAssignment.vehicle_assignment_id = '';
            $scope.vehicleAssignment.assignment_start_date = '';
            $scope.vehicleAssignment.assignment_end_date = '';
        }
        
    };

    $scope.removeAllVehicleAssignments = function() {
        $scope.resetError();

        $http.delete('vehicleAssignment/removeAllVehicleAssignments').success(function() {
            $scope.fetchVehicleAssignmentList();
        }).error(function() {
            $scope.setError('Could not remove all vehicleAssignments');
        });

    };
   
    $scope.fetchVehicleAssignmentList();
    
    
};

