package com.mtncloudservices.crud.rest;

import com.mtncloudservices.crud.entity.Employee;
import com.mtncloudservices.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    // Inject employee DAO
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // Expose "/employees" endpoint
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // Expose mapping for GET /employees/{employeeId
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException(String.format("Employee not found: ID #%d", employeeId));
        }

        return employee;
    }

    // Expose mapping for creating employees POST /employees
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee newEmployeeEntity) {

        // Force ID set to 0 to create new record
        newEmployeeEntity.setId(0);

        return employeeService.save(newEmployeeEntity);
    }

    // Expose endpoint PUT /employees/{employeeId} to update an employee
    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(
            @RequestBody Employee employeeEntity,
            @PathVariable int employeeId
    ) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException(String.format("Employee not found: ID #%d", employeeId));
        }

        employeeEntity.setId(employeeId);

        return employeeService.save(employeeEntity);
    }

    // Expose endpoint DELETE /employees
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException(String.format("Employee not found: ID #%d", employeeId));
        }

        employeeService.deleteById(employeeId);

        return String.format("Employee ID #%d deleted.", employeeId);
    }
}
