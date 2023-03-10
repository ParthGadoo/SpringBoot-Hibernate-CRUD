package com.parth.springboot.crud.dao;

import com.parth.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
    public Employee findById(int theId);
    public void save(Employee theEmployee);

    public void deleteId(int theId);
}
