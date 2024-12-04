package com.example.XiaomiShop.controller;

import com.example.XiaomiShop.entity.Product;
import com.example.XiaomiShop.entity.Review;
import com.example.XiaomiShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    /*
        + перелік усіх товарів
        + переглядати конкретний товар
        - додавати товар
        - видаляти товар
     */

    @Autowired
    private ProductService service;


    @GetMapping
    public String allProducts(Model model) {
        List<Product> productList = service.findAllProduct();
        model.addAttribute("products_list", productList);
        return "products";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable Long id, Model model) {
        Product product = service.findProductById(id);
        model.addAttribute("product",product);
        model.addAttribute("newReview", new Review());
        return "product-info";
    }

    @GetMapping("/add-product")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product-form";
    }

    @PostMapping("/add-product")
    public String addProductSubmit(@ModelAttribute Product product) {
        service.save(product);
        return "redirect:/products";
    }
    @GetMapping("/remove")
    public String removeProduct(@RequestParam(name = "id", required = false) Long id) {
        service.remove(id);
        return "redirect:/products";
    }
}
