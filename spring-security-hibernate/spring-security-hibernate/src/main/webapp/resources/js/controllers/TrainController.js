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

    

    $scope.predicate = 'id';
};