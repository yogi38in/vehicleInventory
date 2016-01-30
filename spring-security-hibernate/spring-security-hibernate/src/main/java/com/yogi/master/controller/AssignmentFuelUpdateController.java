package com.yogi.master.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yogi.master.model.AssignmentFuelUpdate;
import com.yogi.master.service.AssignmentFuelUpdateService;

@Controller
public class AssignmentFuelUpdateController {

	@Autowired
	AssignmentFuelUpdateService assignmentFuelUpdateService;
	
	

	@RequestMapping(value = "/assignmentFuelUpdate/getAssignmentFuelUpdateList.json")
	public @ResponseBody List<AssignmentFuelUpdate> getAssignmentFuelUpdateList() {
		return assignmentFuelUpdateService.loadAllAssignmentFuelUpdates();
	}
	
	@RequestMapping(value = "/assignmentFuelUpdate/addAssignmentFuelUpdate", method = RequestMethod.POST)
    public @ResponseBody void addAssignmentFuelUpdate(@RequestBody AssignmentFuelUpdate assignmentFuelUpdate) {
		assignmentFuelUpdateService.addAssignmentFuelUpdate(assignmentFuelUpdate);
    }
	
	@RequestMapping(value = "/assignmentFuelUpdate/removeAssignmentFuelUpdate/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removeAssignmentFuelUpdate(@PathVariable("id") Long id) {
		assignmentFuelUpdateService.deleteAssignmentFuelUpdateById(id);
    }

    @RequestMapping(value = "/assignmentFuelUpdate/removeAllAssignmentFuelUpdates", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllAssignmentFuelUpdates() {
    	assignmentFuelUpdateService.deleteAll();
    }



}