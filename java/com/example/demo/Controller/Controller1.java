package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.AddtoCart;
import com.example.demo.Model.Model1;
import com.example.demo.Repository.CartRepo;
import com.example.demo.Service.ApiService1;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller1 {
	@Autowired
	ApiService1 Service;
	@Autowired
	CartRepo Crepo;
	@PostMapping("/addProduct")
	public Model1 addInfo(@RequestBody Model1 st)
	{
		return Service.saveDetails(st);
	}
	
@GetMapping("/showProduct")
	public List<Model1> fetchDetails()
	{
		return Service.getDetails();
	}
@PutMapping("/updateProduct/{id}")
public Model1 updateInfo(@RequestBody Model1 st1, @PathVariable Long id )
{
	return Service.updateDetails(id, st1);
}

@DeleteMapping("/deleteProduct/{id}")
public String deleteInfo(@PathVariable Long id)
{
	Service.deleteDetails(id);
	return "Deleted details";
}
@GetMapping("/view/wishlist")
public List<AddtoCart> getAllWishlist() {
    return Crepo.findAll();
}

@DeleteMapping("/wishdelete/{id}")
public String deleteWishbook(@PathVariable Long id)
{
	Crepo.deleteById(id);
	return "Removed";
}
@PostMapping("/addtoWishlist")
public String addtoWishlist(@RequestBody AddtoCart book) {
	Crepo.save(book);
	return "Added to wishlist"; 
}
	
}