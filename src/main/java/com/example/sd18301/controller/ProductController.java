/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sd18301.controller;

import com.example.sd18301.model.Product;
import com.example.sd18301.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hoangquangthang
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productReponsitory;
    @GetMapping("/index")
    public String getProduct(Model model) {
        //tạo ra 1 list để hứng data Product từ trên CSDL về
        List<Product> products = productReponsitory.findAll();
        System.out.println("product" + products);
        model.addAttribute("products", products);
        return "product/index";
    }
}
