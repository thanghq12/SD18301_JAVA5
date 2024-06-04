/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sd18301.repository;

import com.example.sd18301.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hoangquangthang
 */
public interface CategoryReponsitory extends JpaRepository<Category, Long>{
    
}
