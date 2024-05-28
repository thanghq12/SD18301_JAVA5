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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    // route trỏ đến view add
    @GetMapping("/add")
    public String addProduct() {
        // return ra view add
        return "";
    }
    // route store thêm 
    @PostMapping("/store") 
    public String store(Product pr) {
        productReponsitory.save(pr);
        return "redirect:/product/index"; // return lại về trang chủ 
    }
    //tạo trang chi tiết sản phẩm để sửa
    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long id,Model model) {
        Product product = productReponsitory.findById(id).orElseThrow(); 
        model.addAttribute("product", product);
        return ""; // return ra view edit
    }
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Long id,@ModelAttribute Product pr) {
        Product existProduct = productReponsitory.findById(id).orElseThrow();
        existProduct.setName(pr.getName());
        existProduct.setPrice(pr.getPrice());
        productReponsitory.save(existProduct); // cập nhập lại 
        return "redirect:/product/index"; // return lại về trang chủ 
    }
    // xóa sản phẩm
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
         Product existProduct = productReponsitory.findById(id).orElseThrow();
         productReponsitory.delete(existProduct);
         return "redirect:/product/index"; 
    }
    
}
