package service;

import model.Employee;
import repository.EmployeeRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee getById(Long id) {
        return employeeRepository.getById(id);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.deleteEmployee(employee);
    }

    public void deleteEmployeeId(Long id) {
        employeeRepository.deleteEmployeeId(id);
    }

}
