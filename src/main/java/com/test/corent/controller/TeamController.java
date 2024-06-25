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

import com.test.corent.model.Team;
import com.test.corent.service.TeamService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/MaaSRestAPI/TeamServer/api")
public class TeamController 
{
@Autowired
private TeamService teamservice;

@PostMapping("/addTeam")
public Team addNewTeam(@RequestBody Team t)
{
teamservice.save(t);
return t;
}

@GetMapping("/TeamList")
public List<Team> viewHomePage() {
return teamservice.listAll();
}



@DeleteMapping("/deleteteam/{id}")
public String deleteProduct(@PathVariable(name = "id") int id) {
teamservice.delete(id);
return "Done ";
}

}


