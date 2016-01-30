package com.yogi.master.service;

import java.util.List;

import com.yogi.master.model.Rate;

public interface RateService {

	
	List<Rate> loadAllRates();
	
	void addRate(Rate rate);
	
	void deleteRateById(Long id);
	
	void deleteAll();

	
}
