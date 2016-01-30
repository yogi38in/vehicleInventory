package com.yogi.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LandingController {

	
    @RequestMapping("/master/masterLayout")
    public  String getMasterPartialPage() {
        return "master/masterLayout";
    }
    
    @RequestMapping("/railwaystations/layout")
    public  String getRailwayStationPage() {
        return "railwaystations/layout";
    }

    /*@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.POST)
	public String defaultPage() {

    	return "master/masterLayout";

	}*/
}