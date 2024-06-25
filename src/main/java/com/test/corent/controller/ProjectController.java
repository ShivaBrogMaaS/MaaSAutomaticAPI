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

import com.test.corent.model.Project;
import com.test.corent.service.ProjectService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("MaaSRestAPI/ProjectServer/api")
public class ProjectController
{
@Autowired
private ProjectService service;

@PostMapping("/addproject")
public Project saveProduct(@RequestBody Project p) 
{
service.save(p);
return p;
}

@GetMapping("/ProjectList")
public List<Project> viewHomePage() 
{
return service.listAll();
}

@DeleteMapping("/deletepro/{id}")
public String deleteProduct(@PathVariable(name = "id") int id)
{
service.delete(id);
return "redirect:/ProjectList";
}

}
