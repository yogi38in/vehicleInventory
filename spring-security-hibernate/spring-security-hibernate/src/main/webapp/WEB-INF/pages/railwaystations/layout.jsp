<%@page import="com.yogi.vehicle.model.Vehicles"%>
<%@page import="java.util.List"%>
<%@page import="com.yogi.vehicle.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>


<div class="form-style-2">
	<div class="form-style-2-heading">Provide Assignment information</div>
	<form action="" method="post">
		
		<label for="field1" ng-hide=true><span>Assignment Id <span class="required">*</span></span>
		 	<input type="text" class="input-field" ng-model="assignment.assignment_id" placeholder="Assignment Id" /></label> 
		 <label for="field1" ><span>Assignment Name <span class="required">*</span></span>
		 	<input type="text" class="input-field" ng-model="assignment.assignment_name" placeholder="Assignment Name" /></label> 
		<label for="field2"><span>Assignment Start Date <span class="required">*</span></span>
			<input type="text" class="input-field" ng-model="assignment.assignment_start_date" placeholder="Assignment Start Date" /></label> 
		<label for="field2"><span>Assignment Contact <span class="required">*</span></span>
		   <input type="text" class="input-field" ng-model="assignment.assignment_contact" placeholder="Assignment Contact" /></label> 
		<label for="field5">
		  
		<label>
		  
		<span>&nbsp;</span>
		<input type="submit" value="Submit" ng-disabled="!assignment.assignment_id || !assignment.assignment_name" ng-hide="editMode" ng-click="addNewAssignment(assignment)"/>
		<button type="button" class="btn btn-primary" ng-disabled="!assignment.assignment_id || !assignment.assignment_name" ng-show="editMode" ng-click="updateAssignment(assignment)">Save Assignment</button>
		</label>
	</form>
	
	<div class="form-style-2-heading">Assignment List</div>
<div class="alert alert-info" ng-show="assignments.length == 0">
    No assignments found
</div>

<table class="table table-bordered table-striped" ng-show="assignments.length > 0" style="width:902px">
    <thead>
        <tr>
            <th style="text-align: center;"><span>Assignment Name</span></th>
            <th style="text-align: center;">Assignment Contact</th>
            <th style="text-align: center;">Assignment Start date</th>
            <th style="text-align: center;">Edit</th>
            <th style="text-align: center;">Remove</th>
        </tr>
    </thead>
    <tbody>
        <tr ng-repeat="assignment in assignments | orderBy:predicate">
            <td style="text-align: center;">{{assignment.assignment_name}}</td>
            <td>{{assignment.assignment_contact}}</td>
            <td>{{assignment.assignment_start_date}}</td>
            <td>
                <button class="btn btn-mini btn-danger" ng-click="removeAssignment(assignment.assignment_id)">Remove</button>
            </td>
            <td>
                <button class="btn btn-mini btn-success" ng-click="editAssignment(assignment)">Edit</button>
            </td>
        </tr>
    </tbody>
</table>
<button class="btn btn-danger" ng-show="vehicles.length > 1" ng-click="removeAllVehicles()">Remove All Vehicles</button>
<table>
	<tr></tr>
	<tr></tr>
	<tr></tr>
</table>

</div>


</body>
</html>