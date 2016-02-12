<%@page import="com.yogi.master.model.Vehicles"%>
<%@page import="java.util.List"%>
<%@page import="com.yogi.master.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<script>


</script>
<html>
<body >
<!-- <input type="text" value="Toggle First = {{box12}}" ng-click="box12=!box12">
	 <div class="div1" data-slide-toggle="box12" data-slide-toggle-duration="100" ng-show="true">
            <p>This is section #1</p>
        </div> -->
        
<div class="form-style-2">
	
	
	<div class="form-style-2-heading" ng-click="toggle_visibility('vehicletoggle');"> Vehicle information</div>
	
	
	
	<div id="vehicletoggle" style="display:none;" class="masterdata">
	<div class="form-style-2-subheading">Enter Vehicle Details</div>
		
		
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
	
	
	
	<div class="form-style-2-subheading">Vehicle Details List</div>
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
	<div class="form-style-2-heading" ng-click="toggle_visibility('ratetoggle');"> Rate information</div>
	
	
	<div id="ratetoggle" style="display:none;" class="masterdata">
		<div class="form-style-2-subheading">Enter Rate Details</div>
		<label for="field1" ng-hide=true><span style="width:200px">Assignment Id <span class="required">*</span></span>
		 	<input type="text" class="input-field" ng-model="rate.rate_id" placeholder="Rate Id" /></label> 
		 <label for="field1" ><span style="width:200px">Rate Name <span class="required">*</span></span>
		 	<input type="text" class="input-field" ng-model="rate.rate_name" placeholder="Rate Name" /></label> 
		<label for="field2"><span style="width:200px">Energy Source <span class="required">*</span></span>
			<select class="select-field" name="singleSelect" ng-model="rate.energy_source_name" placeholder="Energy Source">
			      <option value="P" selected>Petrol</option>
			      <option value="D">Diesel</option>
			      <option value="C">CNG</option>
			</select> </label>
		<label for="field2"><span style="width:200px">Rate Charged <span class="required">*</span></span>
		   <input type="text" class="input-field" ng-model="rate.rate_charged" placeholder="Rate Charged" /></label> 
		
		
		<label for="field5">
		  
		<label>
		  
		<span style="width:200px">&nbsp;</span>
		<input type="submit" value="Submit" ng-disabled="!rate.rate_name" ng-hide="editModeRate" ng-click="addNewRate(rate)"/>
		<button type="button" class="btn btn-primary" ng-disabled="!rate.rate_name" ng-show="editModeRate" ng-click="updateRate(rate)">Save Rate</button>
		</label>
	
	<div class="form-style-2-subheading">Rate Details List</div>
<div class="alert alert-info" ng-show="rates.length == 0">
    No rates found
</div>

<table class="table table-bordered table-striped" ng-show="rates.length > 0" style="width:902px">
    <thead>
        <tr>
            <th style="text-align: center;"><span>Rate Name</span></th>
            <th style="text-align: center;">Energy Source</th>
            <th style="text-align: center;">Rate Charged</th>
            <th style="text-align: center;">Edit</th>
            <th style="text-align: center;">Remove</th>
        </tr>
    </thead>
    <tbody>
        <tr ng-repeat="rate in rates | orderBy:predicate">
            <td style="text-align: center;">{{rate.rate_name}}</td>
            <td>{{rate.energy_source_name}}</td>
            <td>{{rate.rate_charged}}</td>
            <td>
                <button class="btn btn-mini btn-danger" ng-click="removeRate(rate.rate_id)">Remove</button>
            </td>
            <td>
                <button class="btn btn-mini btn-success" ng-click="editRate(rate)">Edit</button>
            </td>
        </tr>
    </tbody>
</table>
<button class="btn btn-danger" ng-show="rates.length > 1" ng-click="removeAllRates()">Remove All Rates</button>
</div>
<table>
	<tr></tr>
	<tr></tr>
	<tr></tr>
</table>

</div>

<div class="form-style-2">
	<div class="form-style-2-heading" ng-click="toggle_visibility('assignmenttoggle');"> Assignment information</div>
	
	<div id="assignmenttoggle" style="display:none;" class="masterdata">
		<div class="form-style-2-subheading">Enter Assignment Details</div>
		<label for="field1" ng-hide=true><span style="width:200px">Assignment Id <span class="required">*</span></span>
		 	<input type="text" class="input-field" ng-model="assignment.assignment_id" placeholder="Assignment Id" /></label> 
		 <label for="field1" ><span style="width:200px">Assignment Name <span class="required">*</span></span>
		 	<input type="text" class="input-field" ng-model="assignment.assignment_name" placeholder="Assignment Name" /></label> 
		<label for="field2"><span style="width:200px">Assignment Start Date <span class="required">*</span></span>
			<input type="text" class="input-field" ng-model="assignment.assignment_start_date" placeholder="Assignment Start Date" /></label> 
		<label for="field2"><span style="width:200px">Assignment Contact <span class="required">*</span></span>
		   <input type="text" class="input-field" ng-model="assignment.assignment_contact" placeholder="Assignment Contact" /></label> 
		<label for="field1" ><span style="width:200px">Rate Charged <span class="required">*</span></span>
		      <select  class="select-field" ng-model="assignment.rate" ng-options="rate as rate.rate_name  for rate in rates">
    			<option selected>--</option></select>
		 </label>
		<label for="field5">
		  
		<label>
		  
		<span style="width:200px">&nbsp;</span>
		<input type="submit" value="Submit" ng-disabled="!assignment.assignment_contact || !assignment.assignment_name" ng-hide="editModeAssignment" ng-click="addNewAssignment(assignment)"/>
		<button type="button" class="btn btn-primary" ng-disabled="!assignment.assignment_contact || !assignment.assignment_name" ng-show="editModeAssignment" ng-click="updateAssignment(assignment)">Save Assignment</button>
		</label>
	
	<div class="form-style-2-subheading">Assignment Details List</div>
<div class="alert alert-info" ng-show="assignments.length == 0">
    No assignments found
</div>

<table class="table table-bordered table-striped" ng-show="assignments.length > 0" style="width:902px">
    <thead>
        <tr>
            <th style="text-align: center;"><span>Assignment Name</span></th>
            <th style="text-align: center;">Assignment Start date</th>
            <th style="text-align: center;">Assignment Contact</th>
            <th style="text-align: center;">Assignment Rate</th>
            <th style="text-align: center;">Edit</th>
            <th style="text-align: center;">Remove</th>
        </tr>
    </thead>
    <tbody>
        <tr ng-repeat="assignment in assignments | orderBy:predicate">
            <td style="text-align: center;">{{assignment.assignment_name}}</td>
            <td>{{assignment.assignment_start_date}}</td>
            <td>{{assignment.assignment_contact}}</td>
            <td>{{assignment.rate.rate_charged}}</td>
            <td>
                <button class="btn btn-mini btn-danger" ng-click="removeAssignment(assignment.assignment_id)">Remove</button>
            </td>
            <td>
                <button class="btn btn-mini btn-success" ng-click="editAssignment(assignment)">Edit</button>
            </td>
        </tr>
    </tbody>
</table>
<button class="btn btn-danger" ng-show="vehicles.length > 1" ng-click="removeAllAssignments()">Remove All Assignments</button>
</div>
<table>
	<tr></tr>
	<tr></tr>
	<tr></tr>
</table>

</div>

<div class="form-style-2">
	<div class="form-style-2-heading" ng-click="toggle_visibility('vehicleAssignmenttoggle');"> VehicleAssignment information</div>
	
	
	<div id="vehicleAssignmenttoggle" style="display:none;" class="masterdata">
		<div class="form-style-2-subheading">Enter VehicleAssignment Details</div>
		<label for="field1" ng-hide=true><span style="width:200px">VehicleAssignment Id <span class="required">*</span></span>
		 	<input type="text" class="input-field" ng-model="vehicleAssignment.vehicle_assignment_id" placeholder="VehicleAssignment Id" /></label> 
		 <label for="field1" ><span style="width:200px">Vehicle Assignment Name <span class="required">*</span></span>
		 <select  class="select-field" ng-model="vehicleAssignment.assignment"
    ng-options="assignment as assignment.assignment_name  for assignment in assignments">
    <option>--</option>
		</select>

		 </label> 
		 
		 <label for="field1" ><span style="width:200px">Vehicle <span class="required">*</span></span>
		      
		      <select  class="select-field" ng-model="vehicleAssignment.vehicle"
    ng-options="vehicle as vehicle.vehicle_name  for vehicle in vehicles">
    <option>--</option></select>
		 </label>
		 
		 <label for="field1" ><span style="width:200px">Rate Charged <span class="required">*</span></span>
		      
		      <select  class="select-field" ng-model="vehicleAssignment.rate"
    ng-options="rate as rate.rate_name  for rate in rates">
    <option>--</option></select>
		 </label>
		 
		 <label for="field1" ><span style="width:200px">Start Date <span class="required">*</span></span>
			 <!-- <ng-datepicker  first-week-day-sunday="true" class="input-field" ng-model="vehicleAssignment.assignment_start_date" placeholder="Start Date"></ng-datepicker> -->
		 <input type="date" class="input-field" ng-model="vehicleAssignment.assignment_start_date" placeholder="Start date" min="2016-01-01"  required />
		 </label>
		 <!-- <input type="text" datepicker ng-model="vehicleAssignment.assignment_start_date" /> -->
		 <label for="field1" ><span style="width:200px">End Date <span class="required">*</span></span>
			 <!-- <ng-datepicker  first-week-day-sunday="true" class="input-field"  placeholder="End Date"></ng-datepicker> -->
		<input type="date"  class="input-field"  ng-model="vehicleAssignment.assignment_end_date" placeholder="End Date" min="2016-01-01" required />
		</label>
		
    	<label for="field5">
		  
		<label>
		  
		<span style="width:200px">&nbsp;</span>
		<input type="submit" value="Submit" ng-disabled="!vehicleAssignment.assignment" ng-hide="editModeVehicleAssignment" ng-click="addNewVehicleAssignment(vehicleAssignment)"/>
		<button type="button" class="btn btn-primary" ng-disabled="!vehicleAssignment.assignment" ng-show="editModeVehicleAssignment" ng-click="updateVehicleAssignment(vehicleAssignment)">Save VehicleAssignment</button>
		</label>
	
	<div class="form-style-2-subheading">VehicleAssignment Details List</div>
<div class="alert alert-info" ng-show="vehicleAssignments.length == 0">
    No vehicleAssignments found
</div>

<table class="table table-bordered table-striped" ng-show="vehicleAssignments.length > 0" style="width:902px">
    <thead>
        <tr>
            <th style="text-align: center;"><span>Vehicle Assignment Name</span></th>
            <th style="text-align: center;">Vehicle Name</th>
            <th style="text-align: center;">Rate Charged</th>
            <th style="text-align: center;">Edit</th>
            <th style="text-align: center;">Remove</th>
        </tr>
    </thead>
    <tbody>
        <tr ng-repeat="vehicleAssignment in vehicleAssignments | orderBy:predicate">
            <td style="text-align: center;">{{vehicleAssignment.assignment.assignment_name}}</td>
            <td>{{vehicleAssignment.vehicle.vehicle_name}}</td>
            <td>{{vehicleAssignment.rate.rate_name}}</td>
            <td>
                <button class="btn btn-mini btn-danger" ng-click="removeVehicleAssignment(vehicleAssignment.vehicle_assignment_id)">Remove</button>
            </td>
            <td>
                <button class="btn btn-mini btn-success" ng-click="editVehicleAssignment(vehicleAssignment)">Edit</button>
            </td>
        </tr>
    </tbody>
</table>
<button class="btn btn-danger" ng-show="vehicleAssignments.length > 1" ng-click="removeAllVehicleAssignments()">Remove All VehicleAssignments</button>
</div>
<table>
	<tr></tr>
	<tr></tr>
	<tr></tr>
</table>

</div>


</body>
</html>