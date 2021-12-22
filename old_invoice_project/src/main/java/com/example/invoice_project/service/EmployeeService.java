package com.example.invoice_project.service;

import com.example.invoice_project.entity.Employee;
import com.example.invoice_project.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

@Autowired
    EmployeeRepo employeeRepo;
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }
    public void saveEmployee(Employee employee) {
        this.employeeRepo.save(employee);
    }

    public Employee getEmployeeById(int id) {
        Optional< Employee > optional = employeeRepo.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }
    public void deleteEmployeeById(int id) {
        this.employeeRepo.deleteById(id);
    }

    public Page<Employee> findPaginated(int pageNo, int pageSize   ) {

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize );
        return this.employeeRepo.findAll(pageable);

    }
}
