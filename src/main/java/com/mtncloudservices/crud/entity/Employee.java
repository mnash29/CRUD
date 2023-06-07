package com.mtncloudservices.crud.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    // Define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="first_name")
    private String fname;
    @Column(name="last_name")
    private String lname;
    @Column(name="email")
    private String email;

    // Define constructors
    public Employee() {
    }

    public Employee(String fname, String lname, String email) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    // Define getters/setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Define toString
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' + '}';
    }
}
