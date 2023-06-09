package com.mtncloudservices.crud.dao;

import com.mtncloudservices.crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpalmpl implements EmployeeDAO {

    // Define field to entity manager
    private final EntityManager entityManager;

    // Set up constructor injection
    @Autowired
    public EmployeeDAOJpalmpl(EntityManager newEntityManager) {
        entityManager = newEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // Create a query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        // Return list of employees
        return query.getResultList();
    }
}
