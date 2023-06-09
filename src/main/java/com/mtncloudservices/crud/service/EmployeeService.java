package com.mtncloudservices.crud.service;

import com.mtncloudservices.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int employeeEntityId);

    Employee save(Employee employeeEntity);

    void deleteById(int employeeEntityId);
}
