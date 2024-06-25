package com.test.corent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.corent.model.Task;
import com.test.corent.service.TaskService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/MaaSRestAPI/TaskServer/api")
public class TaskController
{

@Autowired
private TaskService taskservice;


@PostMapping("/addTask")
public Task addTask(@RequestBody Task t)
{
taskservice.save(t);
return t;

}

@GetMapping("/TaskList")
public List<Task> viewHomePage()
{
return taskservice.listAll();
}

@PutMapping("/edittask/{id}")
public Task showEditProductPage(@PathVariable(name = "id") int id) {
Task task = taskservice.get(id);
return task;
}

@DeleteMapping("/deletetask/{id}")
public String deleteProduct(@PathVariable(name = "id") int id) {
taskservice.delete(id);
return "redirect:/TaskList";
}





}
