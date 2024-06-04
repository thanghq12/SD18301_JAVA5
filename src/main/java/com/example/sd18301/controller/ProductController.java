/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sd18301.controller;

import com.example.sd18301.model.Category;
import com.example.sd18301.model.Product;
import com.example.sd18301.repository.CategoryReponsitory;
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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hoangquangthang
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productReponsitory;
    @Autowired
    private CategoryReponsitory categoryReponsitory;
    @GetMapping("/index")
    public String getProduct(Model model) {
        //tạo ra 1 list để hứng data Product từ trên CSDL về
//        List<Product> products = productReponsitory.findAll();
        List<Product> products = productReponsitory.findAllProductsWithCategory();
        System.out.println("product" + products);
        model.addAttribute("products", products);
        return "product/index";
    }
    // route trỏ đến view add
    @GetMapping("/add")
    public String addProduct(Model model) {
        // return ra view add
        List<Category> category = categoryReponsitory.findAll();
        model.addAttribute("categories", category);
        return "product/add";
    }
    // route store thêm 
    @PostMapping("/store") 
    public String store(Product pr,@RequestParam Long category_id) {
        Category category = categoryReponsitory.findById(category_id).orElseThrow();
        Product product = new Product();
        product.setName(pr.name);
        product.setPrice(pr.price);
        product.setCategory(category);
        productReponsitory.save(product);
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
