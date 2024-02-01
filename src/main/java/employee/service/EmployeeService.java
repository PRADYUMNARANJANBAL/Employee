package employee.service;

import employee.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();
}
