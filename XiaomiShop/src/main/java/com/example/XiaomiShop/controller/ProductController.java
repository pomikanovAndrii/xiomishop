package com.example.XiaomiShop.controller;

import com.example.XiaomiShop.Database;
import com.example.XiaomiShop.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    /*
        - перелік усіх товарів
        + переглядати конкретний товар
        - додавати товар
        - видаляти товар
     */



    @GetMapping
    public String allProducts(Model model) {
        List<Product> productList = Database.getProducts();
        model.addAttribute("products_list", productList);
        return "products";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable int id, Model model) {
        Product product = Database.getProductById(id);
        model.addAttribute("product",product);
        return "product-info";
    }


}
