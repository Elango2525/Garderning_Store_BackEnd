package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Product;
import com.example.demo.Service.CartItemService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/cart")
public class CartController {
    private final CartItemService cartItemService;

    @Autowired
    public CartController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping
    public List<Product> getCartItems() {
        return cartItemService.getAllCartItems();
    }

    @PostMapping
    public void addToCart(@RequestBody Product product) {
        cartItemService.addToCart(product);
    }
}
