<%@page import="com.yogi.vehicle.model.Vehicles"%>
<%@page import="java.util.List"%>
<%@page import="com.yogi.vehicle.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<script>


</script>
<html>
    
<!-- <input type="text" value="Toggle First = {{box12}}" ng-click="box12=!box12">
	 <div class="div1" data-slide-toggle="box12" data-slide-toggle-duration="100" ng-show="true">
            <p>This is section #1</p>
        </div> -->
        
<div class="form-style-2">
	
	
	<div class="form-style-2-heading" ng-click="toggle_visibility('vehicletoggle');">Provide Vehicle information</div>
	
	
	<div id="vehicletoggle" style="display:none;" class="masterdata">
	
		<form action="" method="post">
		
		<label for="field1" ng-hide=true><span>Vehicle Id <span class="required">*</span></span>
		 	<input type="text" class="input-field" ng-model="vehicle.vehicleId" placeholder="Vehicle Id" /></label> 
		 <label for="field1" ><span>Vehicle Name <span class="required">*</span></span>
		 	<input type="text" class="input-field" ng-model="vehicle.vehicle_name" placeholder="Vehicle Name" /></label> 
		<label for="field2"><span>Vehicle No. <span class="required">*</span></span>
			<input type="text" class="input-field" ng-model="vehicle.vehicle_number" placeholder="Vehicle Number" /></label> 
		<label for="field2"><span>Vehicle Make <span class="required">*</span></span>
		   <input type="text" class="input-field" ng-model="vehicle.vehicle_make" placeholder="Vehicle Make" /></label> 
		<label for="field2"><span>Vehicle Model <span class="required">*</span></span>
		   <input type="text" class="input-field" ng-model="vehicle.vehicle_model" placeholder="Vehicle Model" /></label> 
		<label for="field2"><span>Vehicle Owner</span>
			<select class="select-field" name="singleSelect" ng-model="vehicle.user_id" placeholder="Vehicle Owner">
			      <option value="1" selected>Yogesh Jadhav</option>
			      <option value="2">Shantaram Jadhav</option>
			      <option value="3">Tejashri Jadhav</option>
			</select>
		</label> 
		<label for="field5">
		  
		<label>
		  
		<span>&nbsp;</span>
		<input type="submit" value="Submit" ng-disabled="!vehicle.vehicle_number || !vehicle.vehicle_name" ng-hide="editMode" ng-click="addNewVehicle(vehicle)"/>
		<button type="button" class="btn btn-primary" ng-disabled="!vehicle.vehicle_number || !vehicle.vehicle_name" ng-show="editMode" ng-click="updateVehicle(vehicle)">Save Vehicle</button>
		</label>
	</form>
	
	
	<div class="form-style-2-heading">Vehicle List</div>
<div class="alert alert-info" ng-show="vehicles.length == 0">
    No vehicles found
</div>

<table class="table table-bordered table-striped" ng-show="vehicles.length > 0" style="width:902px">
    <thead>
        <tr>
            <th style="text-align: center;"><span>Vehicle Name</span></th>
            <th style="text-align: center;">Vehicle No.</th>
            <th style="text-align: center;">Vehicle Make</th>
            <th style="text-align: center;">Vehicle Model</th>
            <th style="text-align: center;">Vehicle Owner</th>
            <th style="text-align: center;">Edit</th>
            <th style="text-align: center;">Remove</th>
        </tr>
    </thead>
    <tbody>
        <tr ng-repeat="vehicle in vehicles | orderBy:predicate">
            <td style="text-align: center;">{{vehicle.vehicle_name}}</td>
            <td>{{vehicle.vehicle_number}}</td>
            <td>{{vehicle.vehicle_make}}</td>
            <td>{{vehicle.vehicle_model}}</td>
            <td>{{vehicle.user.username}}</td>
            <td>
                <button class="btn btn-mini btn-danger" ng-click="removeVehicle(vehicle.vehicleId)">Remove</button>
            </td>
            <td>
                <button class="btn btn-mini btn-success" ng-click="editVehicle(vehicle)">Edit</button>
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
</div>

<div class="form-style-2">
	<div class="form-style-2-heading" ng-click="toggle_visibility('assignmenttoggle');">Provide Assignment information</div>
	
	<div id="assignmenttoggle" style="display:none;" class="masterdata">
	<form action="" method="post">
		
		<label for="field1" ng-hide=true><span style="width:200px">Assignment Id <span class="required">*</span></span>
		 	<input type="text" class="input-field" ng-model="assignment.assignment_id" placeholder="Assignment Id" /></label> 
		 <label for="field1" ><span style="width:200px">Assignment Name <span class="required">*</span></span>
		 	<input type="text" class="input-field" ng-model="assignment.assignment_name" placeholder="Assignment Name" /></label> 
		<label for="field2"><span style="width:200px">Assignment Start Date <span class="required">*</span></span>
			<input type="text" class="input-field" ng-model="assignment.assignment_start_date" placeholder="Assignment Start Date" /></label> 
		<label for="field2"><span style="width:200px">Assignment Contact <span class="required">*</span></span>
		   <input type="text" class="input-field" ng-model="assignment.assignment_contact" placeholder="Assignment Contact" /></label> 
		<label for="field5">
		  
		<label>
		  
		<span style="width:200px">&nbsp;</span>
		<input type="submit" value="Submit" ng-disabled="!assignment.assignment_contact || !assignment.assignment_name" ng-hide="editMode" ng-click="addNewAssignment(assignment)"/>
		<button type="button" class="btn btn-primary" ng-disabled="!assignment.assignment_contact || !assignment.assignment_name" ng-show="editMode" ng-click="updateAssignment(assignment)">Save Assignment</button>
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
            <th style="text-align: center;">Assignment Start date</th>
            <th style="text-align: center;">Assignment Contact</th>
            <th style="text-align: center;">Edit</th>
            <th style="text-align: center;">Remove</th>
        </tr>
    </thead>
    <tbody>
        <tr ng-repeat="assignment in assignments | orderBy:predicate">
            <td style="text-align: center;">{{assignment.assignment_name}}</td>
            <td>{{assignment.assignment_start_date}}</td>
            <td>{{assignment.assignment_contact}}</td>
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
</div>
<table>
	<tr></tr>
	<tr></tr>
	<tr></tr>
</table>

</div>


</body>
</html>