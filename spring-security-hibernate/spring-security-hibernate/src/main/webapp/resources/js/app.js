'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['ngRoute','jkuri.datepicker', 'AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives']);

/*App.filter('date', function($filter)
		{
		    return function(input)
		    {
		        if(input == null){ return ""; }
		        var _date = $filter('date')(new Date(input), 'dd/MM/yyyy');
		        return _date.toUpperCase();
		    };
		});*/

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    
	$routeProvider.when('/welcome', {
	        templateUrl: 'master/masterLayout',
	        controller: MasterController
	    });
	 
	$routeProvider.when('/master', {
        templateUrl: 'master/masterLayout',
        controller: MasterController
    });

    $routeProvider.when('/trains', {
        templateUrl: 'trains/layout',
        controller: TrainController
    });
    
    $routeProvider.when('/railwaystations', {
        templateUrl: 'railwaystations/layout',
        controller: RailwayStationController
    });

    $routeProvider.otherwise({redirectTo: '/master'});
}]);

