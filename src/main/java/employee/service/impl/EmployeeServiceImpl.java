package employee.service.impl;


import employee.entities.Employee;
import employee.repositories.EmployeeRepository;
import employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

    @Service
    @Transactional
    public class EmployeeServiceImpl implements EmployeeService {
        @Autowired
        private EmployeeRepository employeeRepository;

        @Override
        public Employee saveEmployee(Employee employee) {

            validateEmployee(employee);


            return employeeRepository.save(employee);
        }

        @Override
        public List<Employee> getAllEmployees() {
            return employeeRepository.findAll();
        }

        private void validateEmployee(Employee employee) {

            if (employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()) {
                throw new IllegalArgumentException("Employee ID cannot be empty");
            }

        }
    }


