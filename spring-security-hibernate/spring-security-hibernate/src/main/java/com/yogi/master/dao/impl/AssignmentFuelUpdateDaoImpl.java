package com.yogi.master.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.master.dao.AssignmentFuelUpdateDao;
import com.yogi.master.model.AssignmentFuelUpdate;

@Repository
public class AssignmentFuelUpdateDaoImpl implements AssignmentFuelUpdateDao {

	@Autowired
	private SessionFactory sessionFactory;
	


	@SuppressWarnings("unchecked")
	@Override
	public List<AssignmentFuelUpdate> findAllAssignmentFuelUpdates() {
		List<AssignmentFuelUpdate> assignmentFuelUpdates = new ArrayList<AssignmentFuelUpdate>();

		assignmentFuelUpdates = sessionFactory.getCurrentSession().createQuery("from AssignmentFuelUpdate").list();
		
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