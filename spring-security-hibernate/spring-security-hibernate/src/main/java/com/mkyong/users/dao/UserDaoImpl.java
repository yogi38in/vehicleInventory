package com.mkyong.users.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.users.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession().createQuery("from User where username=?").setParameter(0, username)
				.list();

		Session session = this.sessionFactory.getCurrentSession();
        session.persist(users.get(0));
        
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

}