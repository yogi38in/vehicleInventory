package com.yogi.master.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.master.dao.VehicleMaintenanceUpdateDao;
import com.yogi.master.model.AssignmentFuelUpdate;
import com.yogi.master.model.VehicleAssignment;
import com.yogi.master.model.VehicleMaintenanceUpdate;

@Repository
public class VehicleMaintenanceUpdateDaoImpl implements VehicleMaintenanceUpdateDao {

	@Autowired
	private SessionFactory sessionFactory;
	


	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleMaintenanceUpdate> findAllVehicleMaintenanceUpdates() {
		List<VehicleMaintenanceUpdate> assignmentFuelUpdates = new ArrayList<VehicleMaintenanceUpdate>();

		assignmentFuelUpdates = sessionFactory.getCurrentSession().createQuery("from VehicleMaintenanceUpdate").list();
		
		for(VehicleMaintenanceUpdate vehicleMaintenanceUpdate:assignmentFuelUpdates){
			if(vehicleMaintenanceUpdate!=null && vehicleMaintenanceUpdate.getVehicle()!=null && vehicleMaintenanceUpdate.getVehicle().getVehicleAssignments()!=null){
				vehicleMaintenanceUpdate.getVehicle().setVehicleAssignments(null);
			}
			
		}
		
		return assignmentFuelUpdates;
	}

	@Override
	public List<VehicleMaintenanceUpdate> findAllVehicleMaintenanceUpdates(
			Long vehicleId, String reportMonth, String reportYear) {
		List<VehicleMaintenanceUpdate> assignmentFuelUpdates = new ArrayList<VehicleMaintenanceUpdate>();

		assignmentFuelUpdates = sessionFactory.getCurrentSession().createQuery("from VehicleMaintenanceUpdate where vehicle_id=? and month(maintenance_date)=? and year(maintenance_date)=?").setParameter(0, vehicleId.intValue()).setParameter(1, Integer.valueOf(reportMonth)).setParameter(2, Integer.valueOf(reportYear)).list();
		
		for(VehicleMaintenanceUpdate vehicleMaintenanceUpdate:assignmentFuelUpdates){
			if(vehicleMaintenanceUpdate!=null && vehicleMaintenanceUpdate.getVehicle()!=null && vehicleMaintenanceUpdate.getVehicle().getVehicleAssignments()!=null){
				vehicleMaintenanceUpdate.getVehicle().setVehicleAssignments(null);
			}
			
		}
		
		return assignmentFuelUpdates;
	}

	@Override
	public void addVehicleMaintenanceUpdate(VehicleMaintenanceUpdate assignmentFuelUpdate) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(assignmentFuelUpdate);
	}


	@Override
	public void deleteVehicleMaintenanceUpdateById(Long id) {
		sessionFactory.getCurrentSession().createQuery("delete from VehicleMaintenanceUpdate where vehicle_maintenance_update_id=?").setParameter(0, id.intValue()).executeUpdate();
	}


	@Override
	public void deleteAll() {
		sessionFactory.getCurrentSession().createQuery("delete from VehicleMaintenanceUpdate").executeUpdate();
		
	}

}