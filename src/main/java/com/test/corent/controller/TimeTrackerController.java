package com.test.corent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.corent.model.TimeTracker;
import com.test.corent.service.TimeTrackerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/MaaSRestAPI/TimeTrackerServer/api")
public class TimeTrackerController
{

@Autowired
private TimeTrackerService timetrackservice;

@PostMapping("/addTimeTracker")
public TimeTracker addTimeTracker(@RequestBody TimeTracker tt)
{
timetrackservice.save(tt);
return tt;
}

@GetMapping("/TimeTrackerList")
public List<TimeTracker> viewHomePage()
{
return timetrackservice.listAll();

}


@DeleteMapping("/deletetimetracker/{id}")
public String deleteProduct(@PathVariable(name = "id") int id) 
{
timetrackservice.delete(id);
return "Done";
}

}


