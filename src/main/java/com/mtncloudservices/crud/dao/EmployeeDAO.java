package com.mtncloudservices.crud.dao;

import com.mtncloudservices.crud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
