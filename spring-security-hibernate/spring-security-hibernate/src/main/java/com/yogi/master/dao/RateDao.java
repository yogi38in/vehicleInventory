package com.yogi.master.dao;

import java.util.List;

import com.yogi.master.model.Rate;

public interface RateDao {

	
    List<Rate> findAllRates();
    
    void addRate(Rate rate);
    
    void deleteRateById(Long id);
	
	void deleteAll();
	
}