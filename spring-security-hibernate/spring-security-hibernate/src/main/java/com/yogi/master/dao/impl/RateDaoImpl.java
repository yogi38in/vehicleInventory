package com.yogi.master.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.master.dao.RateDao;
import com.yogi.master.model.Rate;

@Repository
public class RateDaoImpl implements RateDao {

	@Autowired
	private SessionFactory sessionFactory;
	


	@SuppressWarnings("unchecked")
	@Override
	public List<Rate> findAllRates() {
		List<Rate> rates = new ArrayList<Rate>();

		rates = sessionFactory.getCurrentSession().createQuery("from Rate").list();
		
		return rates;
	}


	@Override
	public void addRate(Rate rate) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(rate);
	}


	@Override
	public void deleteRateById(Long id) {
		sessionFactory.getCurrentSession().createQuery("delete from Rate where rate_id=?").setParameter(0, id.intValue()).executeUpdate();
		
	}


	@Override
	public void deleteAll() {
		sessionFactory.getCurrentSession().createQuery("delete from Rate").executeUpdate();
		
	}

}