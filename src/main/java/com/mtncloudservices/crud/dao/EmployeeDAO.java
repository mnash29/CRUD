package com.mtncloudservices.crud.dao;

import com.mtncloudservices.crud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int employeeEntityId);

    Employee save(Employee employeeEntity);

    void deleteById(int employeeEntityId);
}
