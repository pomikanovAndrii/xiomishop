package com.example.XiaomiShop.controller;

import com.example.XiaomiShop.Database;
import com.example.XiaomiShop.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String showProducts() {
        Database.getProducts();

        return "products";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable int id, Model model) {
        Product product = Database.getProductById(id);
        model.addAttribute("product",product);
        return "product-info";
    }


}
