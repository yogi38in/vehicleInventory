package com.yogi.master.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.master.dao.AssignmentFuelUpdateDao;
import com.yogi.master.model.AssignmentFuelUpdate;
import com.yogi.master.model.VehicleAssignment;
import com.yogi.master.model.VehicleMaintenanceUpdate;

@Repository
public class AssignmentFuelUpdateDaoImpl implements AssignmentFuelUpdateDao {

	@Autowired
	private SessionFactory sessionFactory;
	


	@SuppressWarnings("unchecked")
	@Override
	public List<AssignmentFuelUpdate> findAllAssignmentFuelUpdates() {
		List<AssignmentFuelUpdate> assignmentFuelUpdates = new ArrayList<AssignmentFuelUpdate>();

		assignmentFuelUpdates = sessionFactory.getCurrentSession().createQuery("from AssignmentFuelUpdate").list();
		
		for(AssignmentFuelUpdate assignmentFuelUpdate:assignmentFuelUpdates){
			if(assignmentFuelUpdate!=null && assignmentFuelUpdate.getVehicle()!=null && assignmentFuelUpdate.getVehicle().getVehicleAssignments()!=null){
				assignmentFuelUpdate.getVehicle().setVehicleAssignments(null);
			}
			
		}
		
		
		
		return assignmentFuelUpdates;
	}
	
	@Override
	public List<AssignmentFuelUpdate> findAllAssignmentFuelUpdates(
			Long vehicleId, String reportMonth, String reportYear) {
		List<AssignmentFuelUpdate> assignmentFuelUpdates = new ArrayList<AssignmentFuelUpdate>();

		assignmentFuelUpdates = sessionFactory.getCurrentSession().createQuery("from AssignmentFuelUpdate where vehicle_id=? and month(entry_date)=? and year(entry_date)=?").setParameter(0, vehicleId.intValue()).setParameter(1, Integer.valueOf(reportMonth)).setParameter(2, Integer.valueOf(reportYear)).list();
		
		return assignmentFuelUpdates;
	}


	@Override
	public void addAssignmentFuelUpdate(AssignmentFuelUpdate assignmentFuelUpdate) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(assignmentFuelUpdate);
	}


	@Override
	public void deleteAssignmentFuelUpdateById(Long id) {
		sessionFactory.getCurrentSession().createQuery("delete from AssignmentFuelUpdate where assignment_fuel_update_id=?").setParameter(0, id.intValue()).executeUpdate();
	}


	@Override
	public void deleteAll() {
		sessionFactory.getCurrentSession().createQuery("delete from AssignmentFuelUpdate").executeUpdate();
		
	}


	

}