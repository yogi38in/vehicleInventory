package com.yogi.master.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yogi.master.model.Rate;
import com.yogi.master.service.RateService;

@Controller
public class RateController {

	@Autowired
	RateService rateService;
	
	

	@RequestMapping(value = "/rate/getRateList.json")
	public @ResponseBody List<Rate> getRateList() {
		return rateService.loadAllRates();
	}
	
	@RequestMapping(value = "/rate/addRate", method = RequestMethod.POST)
    public @ResponseBody void addRate(@RequestBody Rate rate) {
		rateService.addRate(rate);
    }
	
	@RequestMapping(value = "/rate/removeRate/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removeRate(@PathVariable("id") Long id) {
		rateService.deleteRateById(id);
    }

    @RequestMapping(value = "/rate/removeAllRates", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllRates() {
    	rateService.deleteAll();
    }



}