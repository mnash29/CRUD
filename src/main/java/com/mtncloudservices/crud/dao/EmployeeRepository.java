package com.mtncloudservices.crud.dao;

import com.mtncloudservices.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> { }
