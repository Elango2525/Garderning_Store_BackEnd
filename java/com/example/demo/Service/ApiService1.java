package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.AddtoCart;
import com.example.demo.Model.Model1;
import com.example.demo.Repository.CartRepo;
import com.example.demo.Repository.Repo1;

@Service
public class ApiService1 {
    @Autowired
    Repo1 Repo;
    @Autowired
    CartRepo Crepo;

    public List<Model1> getDetails() {
        return Repo.findAll();
    }

    public Model1 saveDetails(Model1 e) {
        return Repo.save(e);
    }

    public Model1 updateDetails(Long id, Model1 e1) {
        Model1 modelx = Repo.findById(id).orElse(null);
        if (modelx != null) {
            modelx.setCategory(e1.getCategory());
            modelx.setSubcategory(e1.getSubcategory());
            modelx.setProductname(e1.getProductname());
            modelx.setOriginalprice(e1.getOriginalprice());
            modelx.setDiscountprice(e1.getDiscountprice());
            modelx.setQuantity(e1.getQuantity());
            modelx.setShipping(e1.getShipping());
            modelx.setCustomdeliveryprice(e1.getCustomdeliveryprice());
            modelx.setImageUrl(e1.getImageUrl()); // Set the imageUrl property
            
            return Repo.saveAndFlush(modelx);
        } else {
            return null;
        }
    }

    public void deleteDetails(Long id) {
        Repo.deleteById(id);
    }
    
}