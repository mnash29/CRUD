package com.mtncloudservices.crud.dao;

import com.mtncloudservices.crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // Define field to entity manager
    private final EntityManager employeeEntityManager;

    // Set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        employeeEntityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // Create a query
        TypedQuery<Employee> query = employeeEntityManager.createQuery("from Employee", Employee.class);

        // Return list of employees
        return query.getResultList();
    }

    @Override
    public Employee findById(int employeeEntityId) {
        return employeeEntityManager.find(Employee.class, employeeEntityId);
    }

    @Override
    public Employee save(Employee employeeEntity) {
        return employeeEntityManager.merge(employeeEntity);
    }

    @Override
    public void deleteById(int employeeEntityId) {
        Employee employeeEntity = employeeEntityManager.find(Employee.class, employeeEntityId);

        employeeEntityManager.remove(employeeEntity);
    }
}
