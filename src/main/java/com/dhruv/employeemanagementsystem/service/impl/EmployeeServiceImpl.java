package com.dhruv.employeemanagementsystem.service.impl;

import java.util.List;
// import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dhruv.employeemanagementsystem.exception.ResourceNotFoundException;
import com.dhruv.employeemanagementsystem.model.Employee;
import com.dhruv.employeemanagementsystem.repository.EmployeeRepository;
import com.dhruv.employeemanagementsystem.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public Employee saveEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee getEmployeeById(long id) {
    // Optional<Employee> employee = employeeRepository.findById(id);

    // if (employee.isPresent()) {
    //   return employee.get();
    // }

    // throw new ResourceNotFoundException("Employee", "Id", id);

    // Equivalent to above code
    return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
  }

  @Override
  public Employee updateEmployee(Employee employee, long id) {
    // validate if employee with given id exists in database
    Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
      () -> new ResourceNotFoundException("Employee", "Id", id));

    existingEmployee.setFirstName(employee.getFirstName());
    existingEmployee.setLastName(employee.getLastName());
    existingEmployee.setEmail(employee.getEmail());

    // save existing employee to database
    employeeRepository.save(existingEmployee);

    return existingEmployee;
  }

  @Override
  public void deleteEmployee(long id) {
    // validate id employee exists in database
    employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

    employeeRepository.deleteById(id);
  }

}
