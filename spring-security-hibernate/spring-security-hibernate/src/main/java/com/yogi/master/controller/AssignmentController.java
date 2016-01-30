package com.yogi.master.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yogi.master.model.Assignment;
import com.yogi.master.service.AssignmentService;

@Controller
public class AssignmentController {

	@Autowired
	AssignmentService assignmentService;
	
	

	@RequestMapping(value = "/assignment/getAssignmentList.json")
	public @ResponseBody List<Assignment> getAssignmentList() {
		return assignmentService.loadAllAssignments();
	}
	
	@RequestMapping(value = "/assignment/addAssignment", method = RequestMethod.POST)
    public @ResponseBody void addAssignment(@RequestBody Assignment assignment) {
		assignmentService.addAssignment(assignment);
    }
	
	@RequestMapping(value = "/assignment/removeAssignment/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removeAssignment(@PathVariable("id") Long id) {
		assignmentService.deleteAssignmentById(id);
    }

    @RequestMapping(value = "/assignment/removeAllTrains", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllAssignments() {
    	assignmentService.deleteAll();
    }



}