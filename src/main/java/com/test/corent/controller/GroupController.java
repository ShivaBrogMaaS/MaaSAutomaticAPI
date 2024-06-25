package com.test.corent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.test.corent.model.Group;
import com.test.corent.model.Team;
import com.test.corent.service.GroupService;
import com.test.corent.service.TeamService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("MaaSAPI/GroupServer/api")
public class GroupController 
{
@Autowired
private TeamService teamservice;
@Autowired
private GroupService serv1;

@GetMapping("/newMemb")
public String home(Model mv) 
{
List<Team> t = teamservice.listAll();
mv.addAttribute("team", t);
Group g = new Group();
mv.addAttribute("Group", g);
return "group";
}

@PostMapping("/addGroup")
public Group addGroup(@ModelAttribute("Group") Group g) 
{
serv1.save(g);
return g;

}

@GetMapping("/GroupList")
public String viewHomePage(Model model)
{
List<Group> c = serv1.listAll();
model.addAttribute("Group", c);
return "grouplist";
}

@GetMapping("/editgro/{id}")
public ModelAndView showEditProductPage(@PathVariable(name = "id") int id, Model mv)
{
ModelAndView mav = new ModelAndView("groupupdate");
List<Team> t = teamservice.listAll();
mv.addAttribute("team", t);
Group group = serv1.get(id);
mav.addObject("group", group);
return mav;
}

@GetMapping("/deletegro/{id}")
public String deleteProduct(@PathVariable(name = "id") int id)
{
serv1.delete(id);
return "redirect:/GroupList";
}

}
