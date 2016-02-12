
<%@page import="java.util.List"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>


<div class="form-style-2">
	<div class="form-style-2-heading" ng-click="toggle_visibility('vehicletoggle');"> Assignment Fuel Update information</div>
	
<div id="vehicletoggle" style="display:none;" class="masterdata">		
<div class="form-style-2-subheading" >Enter Assignment Fuel Details</div>
		<label for="field1" ng-hide=true><span>Vehicle Fuel Update Id <span class="required">*</span></span>
		 	<input type="text" class="input-field" ng-model="assignmentFuelUpdate.assignment_fuel_update_id" placeholder="Assignment Fuel Update Id" /></label> 
		 <label for="field1" ><span>Assignment Name <span class="required">*</span></span>
		 
		 <select  class="select-field" ng-model="assignmentFuelUpdate.assignment" placeholder="Assignment Name"
    ng-options="assignment as assignment.assignment_name  for assignment in assignments">
    <option value=''>- Choose Assignment -</option>
		</select>
		 
		 
		 	</label> 
		<label for="field2"><span>Vehicle Name <span class="required">*</span></span>
			<select  class="select-field" ng-model="assignmentFuelUpdate.vehicle"
    ng-options="vehicle as vehicle.vehicle_name  for vehicle in vehicles" placeholder="Vehicle Name">
    <option value=''>- Choose Vehicle -</option></select>
    </label> 
		<label for="field2"><span>Fuel Quantity <span class="required">*</span></span>
		   <input type="text" class="input-field" ng-model="assignmentFuelUpdate.fuel_quantity" placeholder="Fuel Filled Quantity" /></label> 
		<label for="field2"><span>Fuel Type <span class="required">*</span></span>
		   <select class="select-field" name="singleSelect" ng-model="assignmentFuelUpdate.entry_type" placeholder="Fuel Type">
			      <option value="P" selected="selected">Petrol</option>
			      <option value="D">Diesel</option>
			      <option value="C">CNG</option>
			</select>
		</label> 
		<label for="field2"><span>Fuel Rate <span class="required">*</span></span>
		   <input type="text" class="input-field" ng-model="assignmentFuelUpdate.fuel_rate" placeholder="Fuel Filled Rate" /></label> 
		<label for="field2"><span>Fuel Amount <span class="required">*</span></span>
		   <input type="text" class="input-field" ng-model="assignmentFuelUpdate.fuel_bill_amt" placeholder="Fuel Filled Amount" /></label> 
		<label for="field2"><span>Vehicle Km Reading <span class="required">*</span></span>
		   <input type="text" class="input-field" ng-model="assignmentFuelUpdate.vehicle_km_reading" placeholder="Vehicle Km Reading" /></label> 
		
		<label for="field2"><span>Receipt No. <span class="required">*</span></span>
		   <input type="text" class="input-field" ng-model="assignmentFuelUpdate.receipt_no" placeholder="Receipt No" /></label>   
		   
		<label for="field2"><span>Fuel Filled Date <span class="required">*</span></span>
		   <input type="date" class="input-field" ng-model="assignmentFuelUpdate.entry_date" placeholder="Fuel Filled Date" /></label> 
		
		<label for="field5"></label>
		  
		<label>
		  
		<span>&nbsp;</span>
		<input type="submit" value="Submit" ng-disabled="!assignmentFuelUpdate.vehicle" ng-hide="editModeAssignmentFuelUpdate" ng-click="addNewAssignmentFuelUpdate(assignmentFuelUpdate)"/>
		<button type="button" class="btn btn-primary" ng-disabled="!assignmentFuelUpdate.vehicle" ng-show="editModeAssignmentFuelUpdate" ng-click="updateAssignmentFuelUpdate(assignmentFuelUpdate)">Save Fuel Updates</button>
		</label>
	
	<div class="form-style-2-subheading">Assignment Fuel Update List</div>
<div class="alert alert-info" ng-show="assignments.length == 0">
    No assignments found
</div>

<table class="table table-bordered table-striped" ng-show="assignmentFuelUpdates.length > 0" style="width:902px">
    <thead>
        <tr>
            <th style="text-align: center;"><span>Assignment Name</span></th>
            <th style="text-align: center;">Vehicle Name</th>
            <th style="text-align: center;">Fuel Quantity</th>
            <th style="text-align: center;">Fuel Type</th>
            <th style="text-align: center;">Fuel Rate</th>
            <th style="text-align: center;">Fuel Amount</th>
            <th style="text-align: center;">Vehicle Km Reading</th>
            <th style="text-align: center;">Receipt No</th>
            <th style="text-align: center;">Fuel Filled Date</th>
            <th style="text-align: center;">Edit</th>
            <th style="text-align: center;">Remove</th>
        </tr>
    </thead>
    <tbody>
        <tr ng-repeat="assignmentFuelUpdate in assignmentFuelUpdates | orderBy:predicate">
            <td style="text-align: center;">{{assignmentFuelUpdate.assignment.assignment_name}}</td>
            <td>{{assignmentFuelUpdate.vehicle.vehicle_name}}</td>
            <td>{{assignmentFuelUpdate.fuel_quantity}}</td>
            <td>{{assignmentFuelUpdate.entry_type}}</td>
            <td>{{assignmentFuelUpdate.fuel_rate}}</td>
            <td>{{assignmentFuelUpdate.fuel_bill_amt}}</td>
            <td>{{assignmentFuelUpdate.vehicle_km_reading}}</td>
            <td>{{assignmentFuelUpdate.receipt_no}}</td>
            <td>{{assignmentFuelUpdate.entry_date | date:'dd-MMM-yyyy'}}</td>
            <td>
                <button class="btn btn-mini btn-danger" ng-click="removeAssignmentFuelUpdate(assignmentFuelUpdate.assignment_fuel_update_id)">Remove</button>
            </td>
            <td>
                <button class="btn btn-mini btn-success" ng-click="editAssignmentFuelUpdate(assignmentFuelUpdate)">Edit</button>
            </td>
        </tr>
    </tbody>
</table>
<table>
	<tr></tr>
	<tr></tr>
	<tr></tr>
</table>
</div>


<div class="form-style-2-heading" ng-click="toggle_visibility('vehicleMaintenancetoggle');"> Vehicle Maintenance Update information</div>
	
<div id="vehicleMaintenancetoggle" style="display:none;" class="masterdata">	
<div class="form-style-2-subheading">Enter Vehicle Maintenance Details</div>	
		<label for="field1" ng-hide=true><span>Vehicle Maintenance Update Id <span class="required">*</span></span>
		 	<input type="text" class="input-field" ng-model="vehicleMaintenanceUpdate.vehicle_maintenance_update_id" placeholder="Vehicle Maintenance Update Id" />
		 </label> 
		 
		 
		<label for="field2"><span>Vehicle Name <span class="required">*</span></span>
			<select  class="select-field" ng-model="vehicleMaintenanceUpdate.vehicle"
    ng-options="vehicle as vehicle.vehicle_name  for vehicle in vehicles" placeholder="Vehicle Name">
    <option value=''>- Choose Vehicle -</option></select>
    </label> 
	
	<label for="field2"><span>Maintenance Date <span class="required">*</span></span>
		   <input type="date" class="input-field" ng-model="vehicleMaintenanceUpdate.maintenance_date" placeholder="Maintenance Date" min="2016-01-01"  required /></label>
		<label for="field2"><span>Maintenance Amount <span class="required">*</span></span>
		   <input type="text" class="input-field" ng-model="vehicleMaintenanceUpdate.maintenance_amt" placeholder="Maintenance Amount" /></label> 
		
		<label for="field2"><span>Receipt No. <span class="required">*</span></span>
		   <input type="text" class="input-field" ng-model="vehicleMaintenanceUpdate.receipt_no" placeholder="Receipt No" /></label>   

	<label for="field2"><span>Maintenance Desc <span class="required">*</span></span>
		   <input type="text" class="input-field" ng-model="vehicleMaintenanceUpdate.maintenance_desc" placeholder="Maintenance Description" />
	</label> 
		
		<label for="field5"></label>
		  
		<label>
		  
		<span>&nbsp;</span>
		<input type="submit" value="Submit" ng-disabled="!vehicleMaintenanceUpdate.vehicle" ng-hide="editModeVehicleMaintenanceUpdate" ng-click="addNewVehicleMaintenanceUpdate(vehicleMaintenanceUpdate)"/>
		<button type="button" class="btn btn-primary" ng-disabled="!vehicleMaintenanceUpdate.vehicle" ng-show="editModeVehicleMaintenanceUpdate" ng-click="updateVehicleMaintenanceUpdate(vehicleMaintenanceUpdate)">Save Fuel Updates</button>
		</label>
	
	<div class="form-style-2-subheading">Assignment Fuel Update List</div>
<div class="alert alert-info" ng-show="assignments.length == 0">
    No assignments found
</div>

<table class="table table-bordered table-striped" ng-show="vehicleMaintenanceUpdates.length > 0" style="width:902px">
    <thead>
        <tr>
            <th style="text-align: center;">Vehicle Name</th>
            <th style="text-align: center;">Maintenance Date</th>
            <th style="text-align: center;">Maintenance Amount</th>
            <th style="text-align: center;">Receipt No</th>
            <th style="text-align: center;">Maintenance Desc</th>
            <th style="text-align: center;">Edit</th>
            <th style="text-align: center;">Remove</th>
        </tr>
    </thead>
    <tbody>
        <tr ng-repeat="vehicleMaintenanceUpdate in vehicleMaintenanceUpdates | orderBy:predicate">
            <td style="text-align: center;">{{vehicleMaintenanceUpdate.vehicle.vehicle_name}}</td>
            <td>{{vehicleMaintenanceUpdate.maintenance_date | date:'dd-MMM-yyyy'}}</td>
            <td>{{vehicleMaintenanceUpdate.maintenance_amt}}</td>
            <td>{{vehicleMaintenanceUpdate.receipt_no}}</td>
            <td>{{vehicleMaintenanceUpdate.maintenance_desc}}</td>
            <td>
                <button class="btn btn-mini btn-danger" ng-click="removeVehicleMaintenanceUpdate(vehicleMaintenanceUpdate.vehicle_maintenance_update_id)">Remove</button>
            </td>
            <td>
                <button class="btn btn-mini btn-success" ng-click="editVehicleMaintenanceUpdate(vehicleMaintenanceUpdate)">Edit</button>
            </td>
        </tr>
    </tbody>
</table>
<table>
	<tr></tr>
	<tr></tr>
	<tr></tr>
</table>
</div>
</div>


</body>
</html>