package com.example.invoice_project.repository;

import com.example.invoice_project.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
