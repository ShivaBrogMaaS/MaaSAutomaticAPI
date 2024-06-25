package com.test.corent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.test.corent.model.Client;
import com.test.corent.service.ClientService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("MaaSRestAPI/ClientServer/api")
public class ClientController 
{
	
@Autowired
private ClientService clientservice;

@GetMapping("/ClientList")
public List<Client> getClient() 
{
return clientservice.listAll();
}

@PostMapping("/addclient")
public Client addClient(@RequestBody Client c)
{
clientservice.save(c);
return c;
}

@GetMapping("/edit/{id}")
public Client showEditProductPage(@PathVariable(name = "id") int id)
{
Client client = clientservice.get(id);
return client;
}

@DeleteMapping("/delete/{id}")
public String deleteProduct(@PathVariable(name = "id") int id) 
{
clientservice.delete(id);
return "redirect:/ClientList";
}

}
