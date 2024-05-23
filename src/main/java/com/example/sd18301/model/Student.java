/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sd18301.model;

import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 *
 * @author hoangquangthang
 */
public class Student implements Serializable{
    @NotBlank(message="Khum được để trống")
    public String name;
    @NotBlank(message="Khum được để trống")
    public String email;
    @NotBlank(message="Khum được để trống")
    public String address;

    public Student() {
    }

    public Student(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
