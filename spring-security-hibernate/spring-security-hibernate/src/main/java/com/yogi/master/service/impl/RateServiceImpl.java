package com.yogi.master.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yogi.master.dao.RateDao;
import com.yogi.master.model.Rate;
import com.yogi.master.service.RateService;

@Service("rateService")
public class RateServiceImpl implements RateService{

	
	
	@Autowired
	private RateDao rateDao;

	@Transactional(readOnly=true)
	@Override
	public List<Rate> loadAllRates() {
		return rateDao.findAllRates();
	}

	@Transactional(readOnly=false)
	@Override
	public void addRate(Rate rate) {
		
		rateDao.addRate(rate);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteRateById(Long id) {
		rateDao.deleteRateById(id);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteAll() {
		rateDao.deleteAll();
	}

}
