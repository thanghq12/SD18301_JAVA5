/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sd18301.controller;

import com.example.sd18301.model.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hoangquangthang
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @GetMapping("/list")
    public String index(Model model) {
        //fake data sau này lấy từ CSDL 
        List<Student> studentList = new ArrayList<>();
        for(int i = 0;i<10;i++) {
            studentList.add(new Student("name"+i,i+"@gmail.com","Hai phong"));
        }
        //chuyển data sang view 
        model.addAttribute("studentList", studentList);
        model.addAttribute("name","abc");
        return "student/index";
    }
    @GetMapping("/add")
    public String add() {
        return "student/add";
    }
    
}
