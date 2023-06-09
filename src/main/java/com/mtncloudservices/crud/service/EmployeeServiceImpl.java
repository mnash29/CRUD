package com.mtncloudservices.crud.service;

import com.mtncloudservices.crud.dao.EmployeeRepository;
import com.mtncloudservices.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int employeeEntityId) {
        Optional<Employee> result = employeeRepository.findById((employeeEntityId));

        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        }

        return employee;
    }

    @Transactional
    @Override
    public Employee save(Employee employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Transactional
    @Override
    public void deleteById(int employeeEntityId) {
        employeeRepository.deleteById(employeeEntityId);
    }
}
