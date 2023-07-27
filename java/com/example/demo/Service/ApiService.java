package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Model;
import com.example.demo.Repository.Repo;

@Service
public class ApiService {
	@Autowired
	Repo Repo;

	public List<Model> getDetails()
	{
		return Repo.findAll();
	}
	public 	Model SaveDetails(Model e)
	{
		return Repo.save(e);
	}
	public Model updateDetails(Long id, Model e1)
	{
		Model modelx = Repo.findById(id).orElse(null);
		if(modelx !=null) {
			modelx.setName(e1.getName());
			modelx.setEmail(e1.getEmail());
			
			return Repo.saveAndFlush(modelx);
		}
		else {
			return null;
		}
	}
    public void deleteDetails(Long id)
    {
    	Repo.deleteById(id);
    }
}