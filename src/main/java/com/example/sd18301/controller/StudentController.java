/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sd18301.controller;

import com.example.sd18301.model.Student;
import com.example.sd18301.repository.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hoangquangthang
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {
    private StudentRepository stRepo = new StudentRepository();
    @GetMapping("/list")
    public String index(Model model) {
        //fake data sau này lấy từ CSDL 
//        List<Student> studentList = new ArrayList<>();
//        for(int i = 0;i<10;i++) {
//            studentList.add(new Student("name"+i,i+"@gmail.com","Hai phong"));
//        }
        List<Student> studentList = this.stRepo.fillAll();
        //chuyển data sang view 
        model.addAttribute("studentList", studentList);
        model.addAttribute("name","abc");
        return "student/index";
    }
    @GetMapping("/add")
    public String add() {
        return "student/add";
    }
    @PostMapping("/store") 
    public String store(Student sp) {
        this.stRepo.create(sp);
        return "redirect:/student/list"; // sau khi thêm xong nhảy về student list
    }
    @GetMapping("edit/{email}")
    public String edit(@PathVariable("email") String email, Model model) {
        Student st = this.stRepo.findByEmail(email);
        model.addAttribute("student", st);
        return "student/edit";
    }
    @PostMapping("update/{email}") 
    public String update(Student st) {
        this.stRepo.update(st);
        return "redirect:/student/list";
    }
    @GetMapping("delete/{email}") 
    public String delete(@PathVariable("email") String email) {
        this.stRepo.deleteByEmail(email);
        return "redirect:/student/list";
    }
}
