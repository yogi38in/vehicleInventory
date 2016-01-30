'use strict';

/**
 * RailwayStationController
 * @constructor
 */
var RailwayStationController = function($scope, $filter, $http) {
  
	
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
    
    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };
    
    
	$scope.assignmentFuelUpdate = {};
    $scope.editModeAssignmentFuelUpdate = false;
    
	$scope.fetchAssignmentFuelUpdateList = function() {
        $http.get('assignmentFuelUpdate/getAssignmentFuelUpdateList.json').success(function(assignmentFuelUpdateList){
            $scope.assignmentFuelUpdates = assignmentFuelUpdateList;
        });
    };
    
   
    $scope.addNewAssignmentFuelUpdate = function(assignmentFuelUpdate) {
        $scope.resetError();

        $http.post('assignmentFuelUpdate/addAssignmentFuelUpdate', assignmentFuelUpdate).success(function() {
            $scope.fetchAssignmentFuelUpdateList();
            $scope.assignmentFuelUpdate.vehicle = '';
            $scope.assignmentFuelUpdate.assignment = '';
            $scope.assignmentFuelUpdate.fuel_quantity = '';
            $scope.assignmentFuelUpdate.fuel_rate = '';
            $scope.assignmentFuelUpdate.fuel_bill_amt = '';
            $scope.assignmentFuelUpdate.vehicle_km_reading = '';
            $scope.assignmentFuelUpdate.entry_type = '';
            $scope.assignmentFuelUpdate.receipt_no = '';
        }).error(function() {
            $scope.setError('Could not add a new assignmentFuelUpdate');
        });
    };
    
    $scope.editAssignmentFuelUpdate = function(assignmentFuelUpdate) {
        $scope.resetError();
        $scope.assignmentFuelUpdate = assignmentFuelUpdate;
        $scope.editModeAssignmentFuelUpdate = true;
        
        for (var i = 0, len = $scope.vehicles.length; i < len; i++) {
      	  if ($scope.vehicles[i].vehicleId == assignmentFuelUpdate.vehicle.vehicleId) { // Your own property here: 
      	    $scope.assignmentFuelUpdate.vehicle = $scope.vehicles[i];
      	    break;
      	  }
      	}
      
     
      for (var i = 0, len = $scope.assignments.length; i < len; i++) {
      	  if ($scope.assignments[i].assignment_id == assignmentFuelUpdate.assignment.assignment_id) { // Your own property here: 
      	    $scope.assignmentFuelUpdate.assignment = $scope.assignments[i];
      	    break;
      	  }
      }
    };
    
    $scope.updateAssignmentFuelUpdate = function(assignmentFuelUpdate) {
        $scope.resetError();

        $http.post('assignmentFuelUpdate/addAssignmentFuelUpdate', assignmentFuelUpdate).success(function() {
            $scope.fetchAssignmentFuelUpdateList();
            $scope.assignmentFuelUpdate.vehicle = '';
            $scope.assignmentFuelUpdate.assignment = '';
            $scope.assignmentFuelUpdate.fuel_quantity = '';
            $scope.assignmentFuelUpdate.fuel_rate = '';
            $scope.assignmentFuelUpdate.fuel_bill_amt = '';
            $scope.assignmentFuelUpdate.vehicle_km_reading = '';
            $scope.assignmentFuelUpdate.entry_type = '';
            $scope.assignmentFuelUpdate.receipt_no = '';
            $scope.editModeAssignmentFuelUpdate = false;
        }).error(function() {
            $scope.setError('Could not add a update assignmentFuelUpdate');
        });
    };
    

    $scope.removeAssignmentFuelUpdate = function(id) {
        $scope.resetError();

        $http.delete('assignmentFuelUpdate/removeAssignmentFuelUpdate/' + id).success(function() {
            $scope.fetchAssignmentFuelUpdateList();
        }).error(function() {
            $scope.setError('Could not remove assignmentFuelUpdate');
        });
        if(!$scope.assignmentFuelUpdate.vehicle==undefined){
        	 $scope.assignmentFuelUpdate.vehicle = '';
             $scope.assignmentFuelUpdate.assignment = '';
             $scope.assignmentFuelUpdate.fuel_quantity = '';
             $scope.assignmentFuelUpdate.fuel_rate = '';
             $scope.assignmentFuelUpdate.fuel_bill_amt = '';
             $scope.assignmentFuelUpdate.vehicle_km_reading = '';
             $scope.assignmentFuelUpdate.entry_type = '';
             $scope.assignmentFuelUpdate.receipt_no = '';
        }
        
    };

    $scope.removeAllAssignmentFuelUpdates = function() {
        $scope.resetError();

        $http.delete('assignmentFuelUpdate/removeAllAssignmentFuelUpdates').success(function() {
            $scope.fetchAssignmentFuelUpdateList();
        }).error(function() {
            $scope.setError('Could not remove all assignmentFuelUpdates');
        });

    };
   
    $scope.fetchAssignmentFuelUpdateList();
    
    $scope.assignment = {};
    
    $scope.fetchAssignmentList = function() {
        $http.get('assignment/getAssignmentList.json').success(function(assignmentList){
            $scope.assignments = assignmentList;
        });
    };
    
    $scope.fetchAssignmentList();
    
    $scope.fetchVehicleList = function() {
        $http.get('vehicle/getVehicleList.json').success(function(vehicleList){
            $scope.vehicles = vehicleList;
        });
    };
    
    $scope.fetchVehicleList();
    
    ////////////////////////////////// ADD Vehicle Maintenance //////////////////////////////////
    
    
    $scope.vehicleMaintenanceUpdate = {};
    $scope.editModeVehicleMaintenanceUpdate = false;
    
	$scope.fetchVehicleMaintenanceUpdateList = function() {
        $http.get('vehicleMaintenanceUpdate/getVehicleMaintenanceUpdateList.json').success(function(vehicleMaintenanceUpdateList){
            $scope.vehicleMaintenanceUpdates = vehicleMaintenanceUpdateList;
        });
    };
    
   
    $scope.addNewVehicleMaintenanceUpdate = function(vehicleMaintenanceUpdate) {
        $scope.resetError();

        $http.post('vehicleMaintenanceUpdate/addVehicleMaintenanceUpdate', vehicleMaintenanceUpdate).success(function() {
            $scope.fetchVehicleMaintenanceUpdateList();
            $scope.vehicleMaintenanceUpdate.vehicle = '';
            $scope.vehicleMaintenanceUpdate.maintenance_desc = '';
            $scope.vehicleMaintenanceUpdate.receipt_no = '';
            $scope.vehicleMaintenanceUpdate.maintenance_date = '';
            $scope.vehicleMaintenanceUpdate.maintenance_amt = '';
        }).error(function() {
            $scope.setError('Could not add a new vehicleMaintenanceUpdate');
        });
    };
    
    $scope.editVehicleMaintenanceUpdate = function(vehicleMaintenanceUpdate) {
        $scope.resetError();
        $scope.vehicleMaintenanceUpdate.maintenance_desc = vehicleMaintenanceUpdate.maintenance_desc;
        $scope.vehicleMaintenanceUpdate.receipt_no = vehicleMaintenanceUpdate.receipt_no;
        $scope.vehicleMaintenanceUpdate.maintenance_amt = vehicleMaintenanceUpdate.maintenance_amt;
        $scope.editModeVehicleMaintenanceUpdate = true;
        $scope.vehicleMaintenanceUpdate.maintenance_date = new Date($filter('date')(vehicleMaintenanceUpdate.maintenance_date, 'dd MMMM yyyy'));
        $scope.vehicleMaintenanceUpdate.vehicle_maintenance_update_id = vehicleMaintenanceUpdate.vehicle_maintenance_update_id;
        
        for (var i = 0, len = $scope.vehicles.length; i < len; i++) {
      	  if ($scope.vehicles[i].vehicleId == vehicleMaintenanceUpdate.vehicle.vehicleId) { // Your own property here: 
      	    $scope.vehicleMaintenanceUpdate.vehicle = $scope.vehicles[i];
      	    break;
      	  }
      	}
    };
    
    $scope.updateVehicleMaintenanceUpdate = function(vehicleMaintenanceUpdate) {
        $scope.resetError();

        $http.post('vehicleMaintenanceUpdate/addVehicleMaintenanceUpdate', vehicleMaintenanceUpdate).success(function() {
        	 $scope.fetchVehicleMaintenanceUpdateList();
             $scope.vehicleMaintenanceUpdate.vehicle = '';
             $scope.vehicleMaintenanceUpdate.maintenance_desc = '';
             $scope.vehicleMaintenanceUpdate.receipt_no = '';
             $scope.vehicleMaintenanceUpdate.maintenance_date = '';
             $scope.vehicleMaintenanceUpdate.maintenance_amt = '';
            $scope.editModeVehicleMaintenanceUpdate = false;
        }).error(function() {
            $scope.setError('Could not add a update vehicleMaintenanceUpdate');
        });
    };
    

    $scope.removeVehicleMaintenanceUpdate = function(id) {
        $scope.resetError();

        $http.delete('vehicleMaintenanceUpdate/removeVehicleMaintenanceUpdate/' + id).success(function() {
            $scope.fetchVehicleMaintenanceUpdateList();
        }).error(function() {
            $scope.setError('Could not remove vehicleMaintenanceUpdate');
        });
        if(!$scope.vehicleMaintenanceUpdate.vehicle==undefined){
        	 $scope.fetchVehicleMaintenanceUpdateList();
             $scope.vehicleMaintenanceUpdate.vehicle = '';
             $scope.vehicleMaintenanceUpdate.maintenance_desc = '';
             $scope.vehicleMaintenanceUpdate.receipt_no = '';
             $scope.vehicleMaintenanceUpdate.maintenance_date = '';
             $scope.vehicleMaintenanceUpdate.maintenance_amt = '';
        }
        
    };

    $scope.removeAllVehicleMaintenanceUpdates = function() {
        $scope.resetError();

        $http.delete('vehicleMaintenanceUpdate/removeAllVehicleMaintenanceUpdates').success(function() {
            $scope.fetchVehicleMaintenanceUpdateList();
        }).error(function() {
            $scope.setError('Could not remove all vehicleMaintenanceUpdates');
        });

    };
    
    $scope.fetchVehicleMaintenanceUpdateList();
};