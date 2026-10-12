package com.jaswant.fms.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "freshers")
public class Fresher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeId;

    private String name;

    private String email;

    private String phone;

    private String technology;

    private LocalDate joiningDate;

    private String status;

    public Fresher() {
    }

    public Fresher(Long id,
            String employeeId,
            String name,
            String email,
            String phone,
            String technology,
            LocalDate joiningDate,
            String status) {

        this.id = id;
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.technology = technology;
        this.joiningDate = joiningDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(
            String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(
            String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(
            String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(
            String phone) {
        this.phone = phone;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(
            String technology) {
        this.technology = technology;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(
            LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status) {
        this.status = status;
    }
}