package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="my_products")
public class Model1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String subcategory;
    private String productname;
    private double originalprice;
    private double discountprice;
    private int quantity;
    private String shipping;
    private double customdeliveryprice;
    private String imageUrl; // New property for image URL
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getSubcategory() {
        return subcategory;
    }
    
    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
    
    public String getProductname() {
        return productname;
    }
    
    public void setProductname(String productname) {
        this.productname = productname;
    }
    
    public double getOriginalprice() {
        return originalprice;
    }
    
    public void setOriginalprice(double originalprice) {
        this.originalprice = originalprice;
    }
    
    public double getDiscountprice() {
        return discountprice;
    }
    
    public void setDiscountprice(double discountprice) {
        this.discountprice = discountprice;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getShipping() {
        return shipping;
    }
    
    public void setShipping(String shipping) {
        this.shipping = shipping;
    }
    
    public double getCustomdeliveryprice() {
        return customdeliveryprice;
    }
    
    public void setCustomdeliveryprice(double customdeliveryprice) {
        this.customdeliveryprice = customdeliveryprice;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}