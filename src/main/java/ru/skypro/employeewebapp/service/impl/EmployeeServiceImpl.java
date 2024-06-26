package ru.skypro.employeewebapp.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.employeewebapp.exception.EmployeeAlreadyAddedException;
import ru.skypro.employeewebapp.exception.EmployeeNotFoundException;
import ru.skypro.employeewebapp.exception.EmployeeStoragelsFullException;
import ru.skypro.employeewebapp.model.Employee;
import ru.skypro.employeewebapp.service.EmoloyeeValidationService;
import ru.skypro.employeewebapp.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int EMPLOYEE_STORAGE_SIZE = 5;
    private final Map<String, Employee> employees = new HashMap<>();
    private final EmoloyeeValidationService emoloyeeValidationService;

    public EmployeeServiceImpl(EmoloyeeValidationService emoloyeeValidationService) {
        this.emoloyeeValidationService = emoloyeeValidationService;
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        return add(employee);
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return add(employee);
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }

    private Employee add(Employee employee) {
        if (employees.size() == EMPLOYEE_STORAGE_SIZE) {
            throw new EmployeeStoragelsFullException();
        }

        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        emoloyeeValidationService.validate(employee.getFirstName(), employee.getLastName());

        employees.put(employee.getFullName(), employee);
        return employee;
    }


}
