package com.mtncloudservices.crud.service;

import com.mtncloudservices.crud.dao.EmployeeDAO;
import com.mtncloudservices.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int employeeEntityId) {
        return employeeDAO.findById((employeeEntityId));
    }

    @Transactional
    @Override
    public Employee save(Employee employeeEntity) {
        return employeeDAO.save(employeeEntity);
    }

    @Transactional
    @Override
    public void deleteById(int employeeEntityId) {
        employeeDAO.deleteById(employeeEntityId);
    }
}
