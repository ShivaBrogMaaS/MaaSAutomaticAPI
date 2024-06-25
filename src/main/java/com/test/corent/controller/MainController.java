package com.test.corent.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.corent.dao.UserRepo;
import com.test.corent.model.User;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("MaaSRestAPI/Users/login")
public class MainController 
{

@Autowired
private UserRepo repo;


@GetMapping("/Validate/{name}/{password}")
public List<User> loginn(@PathVariable("name") String name, @PathVariable("password") String password)
throws Exception 
{
List<User> rs = new ArrayList<User>();
try 
{
User obj = null;
if (name != null || password != null) 
{
obj = repo.findByPassword(name, password);
}
if (obj == null)
{
throw new Exception("Bad Credentials");
}
rs.add(obj);
} 
catch (Exception exp) 
{
System.out.println(exp);
}
return rs;
}



@PostMapping("/newUser")
public User regUser(@RequestBody User u)
{
repo.save(u);
return u;

}

@GetMapping("/updatepassword/{oldpassword}/{newpassword}")
public void updatePassword(@PathVariable("oldpassword") String oldpassword,@PathVariable("newpassword") String newpassword) 
{
repo.findByChangePassword(newpassword, oldpassword);
}

}
