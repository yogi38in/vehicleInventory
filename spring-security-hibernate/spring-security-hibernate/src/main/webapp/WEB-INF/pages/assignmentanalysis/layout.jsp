
<%@page import="java.util.List"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>


<div class="form-style-3" >
		<table>
			<tr>
				<td colspan="2"><span>Assignment Name <span class="required">*</span></span></td>
				<td colspan="2"><select  class="select-field" ng-model="requestparam.vehicle" 
    			ng-options="vehicle as vehicle.vehicle_name  for vehicle in vehicles" >
    			<option value=''>- Choose Assignment -</option></select></td>
				<td colspan="2"><span>Report Month/ Year <span class="required">*</span></span></td>
				<td colspan="2"><select class="select-field" name="singleSelect" ng-model="requestparam.reportMonth" >
			      <option value="1" selected="selected">Jan</option>
			      <option value="2">Feb</option>
			      <option value="3">Mar</option>
			</select>
			<select class="select-field" name="singleSelect" ng-model="requestparam.reportYear" >
			      <option value="2016" selected="selected">2016</option>
			      <option value="2017">2017</option>
			      <option value="2018">2018</option>
			</select></td>
				
			</tr>
		
		</table>		
		
		
		  
		<label>
		  
		<span>&nbsp;</span>
		<input type="submit" value="Submit" ng-click="getVehicleReport(requestparam)"/>
		</label>
		
		<div id="vehicleReportDtls" ng-show="vehicleReportList.vehicleFuelUpdateDTOs.length > 0">
		<table>
			<tr>
				<td ><span>Vehicle Name <span class="required">*</span></span></td>
				<td ><input type="text" class="input-field" ng-model="requestparam.vehicle.vehicle_name" /></td>
				<td ><span>Report Month/ Year <span class="required">*</span></span></td>
				<td ><input type="text" class="input-field" ng-model="requestparam.reportMonthName" /></td>
			</tr>
			
			<tr>
				<td ><span>Vehicle Total Km Covered <span class="required">*</span></span></td>
				<td ><input type="text" class="input-field" ng-model="vehicleReportList.totalKmsCovered" /></td>
				<td ><span>Vehicle Rate Charged <span class="required">*</span></span></td>
				<td ><input type="text" class="input-field" ng-model="vehicleReportList.totalRateCharged" /></td>
				
			</tr>
			
			<tr>
				<td ><span>Vehicle Income <span class="required">*</span></span></td>
				<td ><input type="text" class="input-field" ng-model="(vehicleReportList.totalKmsCovered * vehicleReportList.totalRateCharged) | number:2" /></td>
				
			</tr>
			
			<tr>
				<td ><span>Vehicle Total Maintenance Cost <span class="required">*</span></span></td>
				<td ><input type="text" class="input-field" ng-model="vehicleReportList.totalMaintenanceCost" /></td>
			</tr>
			
			<tr>
				<td ><span>Vehicle Total Fuel Used <span class="required">*</span></span></td>
				<td ><input type="text" class="input-field" ng-model="vehicleReportList.totalFuelUsed | number:2" /></td>
				<td ><span>Vehicle Loss on Fuel <span class="required">*</span></span></td>
				<td ><input type="text" class="input-field" ng-model="(vehicleReportList.totalFuelUsed * vehicleReportList.avgFuelRate) | number:2" /></td>
			</tr>
			
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td ><span>Vehicle Profit <span class="required">*</span></span></td>
				<td style="color:red;"><blink> {{(vehicleReportList.totalKmsCovered * vehicleReportList.totalRateCharged)| number:2}} - {{(vehicleReportList.totalFuelUsed * vehicleReportList.avgFuelRate)| number:2}} - {{(vehicleReportList.totalMaintenanceCost)| number:2}} = 
				{{((vehicleReportList.totalKmsCovered * vehicleReportList.totalRateCharged) - (vehicleReportList.totalFuelUsed * vehicleReportList.avgFuelRate) - (vehicleReportList.totalMaintenanceCost)) | number:2}}</blink></td>
			</tr>
		
		</table>
		</div>
		
</div>
<div class="form-style-2">	
	<div class="form-style-2-heading">List of Fuel and Km Reading</div>

<div class="alert alert-info" ng-show="vehicleReportList.vehicleFuelUpdateDTOs.length == 0">
    No fuel updates found
</div>


<table class="table table-bordered table-striped" ng-show="vehicleReportList.vehicleFuelUpdateDTOs.length > 0" style="width:1200px; height:200px" scrollable=true>
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
        </tr>
    </thead>
    <tbody>
        <tr ng-repeat="vehicleFuelUpdateDTO in vehicleReportList.vehicleFuelUpdateDTOs | orderBy:predicate">
            <td style="text-align: center;">{{vehicleFuelUpdateDTO.assignment_name}}</td>
            <td>{{requestparam.vehicle.vehicle_name}}</td>
            <td>{{vehicleFuelUpdateDTO.fuel_quantity}}</td>
            <td>{{vehicleFuelUpdateDTO.entry_type}}</td>
            <td>{{vehicleFuelUpdateDTO.fuel_rate}}</td>
            <td>{{vehicleFuelUpdateDTO.fuel_bill_amt}}</td>
            <td>{{vehicleFuelUpdateDTO.vehicle_km_reading}}</td>
            <td>{{vehicleFuelUpdateDTO.receipt_no}}</td>
            <td>{{vehicleFuelUpdateDTO.entry_date | date:'dd-MMM-yyyy'}}</td>
        </tr>
    </tbody>
</table>

<div class="form-style-2-heading">List of Vehicle Maintenance</div>

<div class="alert alert-info" ng-show="vehicleReportList.vehicleMaintenanceUpdateDTOs.length == 0">
    No maintenance updates found
</div>


<table class="table table-bordered table-striped" ng-show="vehicleReportList.vehicleMaintenanceUpdateDTOs.length > 0" style="width:1200px">
    <thead>
        <tr>
            <th style="text-align: center;">Vehicle Name</th>
            <th style="text-align: center;">Maintenance Date</th>
            <th style="text-align: center;">Maintenance Amount</th>
            <th style="text-align: center;">Receipt No</th>
            <th style="text-align: center;">Maintenance Desc</th>
        </tr>
    </thead>
    <tbody>
        <tr ng-repeat="vehicleMaintenanceUpdateDTO in vehicleReportList.vehicleMaintenanceUpdateDTOs | orderBy:predicate">
            <td style="text-align: center;">{{requestparam.vehicle.vehicle_name}}</td>
            <td>{{vehicleMaintenanceUpdateDTO.maintenance_date | date:'dd-MMM-yyyy'}}</td>
            <td>{{vehicleMaintenanceUpdateDTO.maintenance_amt}}</td>
            <td>{{vehicleMaintenanceUpdateDTO.receipt_no}}</td>
            <td>{{vehicleMaintenanceUpdateDTO.maintenance_desc}}</td>
        </tr>
    </tbody>
</table>

<table>
	<tr></tr>
	<tr></tr>
	<tr></tr>
</table>
</div>



<!-- </div> -->


</body>
</html>