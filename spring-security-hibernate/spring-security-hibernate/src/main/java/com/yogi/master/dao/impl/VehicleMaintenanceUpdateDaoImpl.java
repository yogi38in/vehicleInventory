package com.yogi.master.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.master.dao.VehicleMaintenanceUpdateDao;
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