package com.yogi.vehicle.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.users.model.User;
import com.yogi.vehicle.model.Vehicles;

@Repository
public class VehicleDaoImpl implements VehicleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public Vehicles findByVehicleNumber(String vehicleNumber) {

		List<Vehicles> vehicles = new ArrayList<Vehicles>();

		vehicles = sessionFactory.getCurrentSession().createQuery("from Vehicles where vehicle_number=?").setParameter(0, vehicleNumber)
				.list();


		Session session = this.sessionFactory.getCurrentSession();
        session.persist(vehicles.get(0));
        
		if (vehicles.size() > 0) {
			return vehicles.get(0);
		} else {
			return null;
		}

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicles> findAllVehicles() {
		List<Vehicles> vehicles = new ArrayList<Vehicles>();

		vehicles = sessionFactory.getCurrentSession().createQuery("from Vehicles").list();
		
		return vehicles;
	}


	@Override
	public void addVehicle(Vehicles vehicle) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(vehicle);
	}


	@Override
	public void deleteVehicleById(Long id) {
		sessionFactory.getCurrentSession().createQuery("delete from Vehicles where vehicle_id=?").setParameter(0, id).executeUpdate();
		
	}


	@Override
	public void deleteAll() {
		sessionFactory.getCurrentSession().createQuery("delete from Vehicles").executeUpdate();
		
	}

}