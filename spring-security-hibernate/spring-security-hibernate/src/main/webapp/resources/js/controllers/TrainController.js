'use strict';

/**
 * TrainController
 * @constructor
 */
var TrainController = function($scope, $http) {
	

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchVehicleList = function() {
        $http.get('vehicle/getVehicleList.json').success(function(vehicleList){
            $scope.vehicles = vehicleList;
        });
    };
    
    $scope.fetchVehicleList();
    
    var months = ["January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    
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
    
    var vehicleReportRequest = {'vehicleId':1, 'reportMonth':'1', 'reportYear':'2016'};
    
    $scope.getVehicleReport = function(requestparam) {
        
       
        
        $http.get('vehicle/getVehicleReport.json/'+ requestparam.vehicle.vehicleId+'/'+requestparam.reportMonth+'/'+requestparam.reportYear).success(function(vehicleReport) {
        	console.log(months[requestparam.reportMonth]);
        	$scope.requestparam.reportMonthName = months[requestparam.reportMonth] + '-' + requestparam.reportYear;
        	
        	$scope.vehicleReportList = vehicleReport;
            
        }).error(function() {
            $scope.setError('Could not add a new vehicle');
        });
    };

    $scope.predicate = 'id';
};

