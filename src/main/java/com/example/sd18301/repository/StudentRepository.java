/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sd18301.repository;

import com.example.sd18301.model.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangquangthang
 */
public class StudentRepository {
    // khởi tạo ra 1 list 
    private List<Student> ds;
    // 
    public StudentRepository() {
        this.ds = new ArrayList<>();
        this.ds.add(new Student("thang","thanghq12@gmail.com","le thanh tong"));
        this.ds.add(new Student("manh","manh@gmail.com","do son"));
    }
    
    //load list danh sách
    public List<Student> fillAll() {
        return this.ds;
    }
    // thêm 
    public void create(Student st) {
        this.ds.add(st);
    }
    // update 
    public void update(Student st) {
        for(int i = 0;i < this.ds.size(); i ++) {
            Student st1 = this.ds.get(i);
            if(st1.getEmail().equals(st.getEmail())) {
                this.ds.set(i, st);
            }
            
        }
    } 
    //delete 
    public void deleteByEmail(String email) {
        for(int i = 0;i < this.ds.size(); i ++) {
            Student st1 = this.ds.get(i);
            if(st1.getEmail().equals(email)) {
                this.ds.remove(i);
            }
            
        }
    }
    //findByEmail
    public Student findByEmail(String email) {
         for(int i = 0;i < this.ds.size(); i ++) {
            Student st1 = this.ds.get(i);
            if(st1.getEmail().equals(email)) {
               return st1;
            }
        }
        return null;
    }
}
