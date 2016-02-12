package com.yogi.master.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.master.dao.VehicleAssignmentDao;
import com.yogi.master.model.VehicleAssignment;

@Repository
public class VehicleAssignmentDaoImpl implements VehicleAssignmentDao {

	@Autowired
	private SessionFactory sessionFactory;
	


	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleAssignment> findAllVehicleAssignments() {
		List<VehicleAssignment> vehicleAssignments = new ArrayList<VehicleAssignment>();

		vehicleAssignments = sessionFactory.getCurrentSession().createQuery("from VehicleAssignment").list();
		
		for(VehicleAssignment vehicleAssignment:vehicleAssignments){
			if(vehicleAssignment!=null && vehicleAssignment.getVehicle()!=null && vehicleAssignment.getVehicle().getVehicleAssignments()!=null){
				vehicleAssignment.getVehicle().setVehicleAssignments(null);
			}
			
		}
		
		return vehicleAssignments;
	}


	@Override
	public void addVehicleAssignment(VehicleAssignment vehicleAssignment) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(vehicleAssignment);
	}


	@Override
	public void deleteVehicleAssignmentById(Long id) {
		sessionFactory.getCurrentSession().createQuery("delete from VehicleAssignment where vehicle_assignment_id=?").setParameter(0, id.intValue()).executeUpdate();
	}


	@Override
	public void deleteAll() {
		sessionFactory.getCurrentSession().createQuery("delete from VehicleAssignment").executeUpdate();
		
	}

}