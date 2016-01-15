package com.yogi.assignment.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.assignment.model.Assignment;

@Repository
public class AssignmentDaoImpl implements AssignmentDao {

	@Autowired
	private SessionFactory sessionFactory;
	


	@SuppressWarnings("unchecked")
	@Override
	public List<Assignment> findAllAssignments() {
		List<Assignment> assignments = new ArrayList<Assignment>();

		assignments = sessionFactory.getCurrentSession().createQuery("from Assignment").list();
		
		return assignments;
	}


	@Override
	public void addAssignment(Assignment assignment) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(assignment);
	}


	@Override
	public void deleteAssignmentById(Long id) {
		sessionFactory.getCurrentSession().createQuery("delete from Assignment where assignment_id=?").setParameter(0, id).executeUpdate();
		
	}


	@Override
	public void deleteAll() {
		sessionFactory.getCurrentSession().createQuery("delete from Assignment").executeUpdate();
		
	}

}