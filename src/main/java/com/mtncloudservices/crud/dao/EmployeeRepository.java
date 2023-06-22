package com.mtncloudservices.crud.dao;

import com.mtncloudservices.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="employees") // default adds an 's' to the entity
public interface EmployeeRepository extends JpaRepository<Employee, Integer> { }
