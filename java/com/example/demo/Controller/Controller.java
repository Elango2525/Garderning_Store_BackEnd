package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Model;
import com.example.demo.Service.ApiService;

@RestController
public class Controller {
	@Autowired
	ApiService Service;
	@PostMapping("/addDetails")
	public Model addInfo(@RequestBody Model st)
	{
		return Service.SaveDetails(st);
	}
	
@GetMapping("showDetails")
	public List<Model> fetchDetails()
	{
		return Service.getDetails();
	}
@PutMapping("/updateDetails/{id}")
public Model updateInfo(@RequestBody Model st1, @PathVariable Long id )
{
	return Service.updateDetails(id, st1);
}

@DeleteMapping("/deleteDetails/{id}")
public String deleteInfo(@PathVariable Long id)
{
	Service.deleteDetails(id);
	return "Deleted details";
}
	
}