package com.yogi.master.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yogi.users.dao.UserDao;
import com.yogi.master.dao.VehicleDao;
import com.yogi.master.model.Vehicles;
import com.yogi.master.service.VehicleService;

@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService{

	
	
	@Autowired
	private VehicleDao vehicleDao;

	@Autowired
	private UserDao userDao;

	@Transactional(readOnly=true)
	@Override
	public Vehicles loadVehiclesByVehicleNumber(String vehicleNumber) {
		return vehicleDao.findByVehicleNumber(vehicleNumber);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Vehicles> loadAllVehicles() {
		return vehicleDao.findAllVehicles();
	}

	@Transactional(readOnly=false)
	@Override
	public void addVehicle(Vehicles vehicle) {
		com.yogi.users.model.User user = userDao.findByUserName("yogesh");
		vehicle.setUser(user);
		
		vehicleDao.addVehicle(vehicle);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteVehicleById(Long id) {
		// TODO Auto-generated method stub
		vehicleDao.deleteVehicleById(id);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		vehicleDao.deleteAll();
	}

}
