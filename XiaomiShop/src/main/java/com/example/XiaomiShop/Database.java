package com.example.XiaomiShop;

import com.example.XiaomiShop.entity.Product;

import java.util.ArrayList;
import java.util.List;


public class Database {
    public static List<Product> products = new ArrayList<>();

    static {
        Product product1 = new Product();
        product1.setId(0);
        product1.setTitle("Xiaomi Redmi 9");
        product1.setDescription("Непоганий бюджетний смартфон");
        product1.setCost(4200);

        Product product2 = new Product();
        product2.setId(1);
        product2.setTitle("Xiaomi POCO M5");
        product2.setDescription("Непоганий смартфон");
        product2.setCost(8300);


        products.add(product1);
        products.add(product2);
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static Product getProductById(int id) {
        for(Product product : products)
            if(product.getId() == id)
                return products.get(id);
        return null;
    }

    public static void saveProduct(Product product) {
        products.add(product);
    }

    public static boolean removeProduct(int id) {
        for(int i = 0; i < products.size(); i++) {
            if(products.get(i).getId() == id) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }
}
