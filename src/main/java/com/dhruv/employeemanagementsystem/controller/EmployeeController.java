package com.dhruv.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dhruv.employeemanagementsystem.model.Employee;
import com.dhruv.employeemanagementsystem.service.EmployeeService;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

  private EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    super();
    this.employeeService = employeeService;
  }

  // build create employee REST API
  @PostMapping()
  public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
    return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
  }

  // build get all employees REST API
  @GetMapping()
  public ResponseEntity<List<Employee>> getAllEmployees() {
    return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
  }

  // build get employee by id REST API
  @GetMapping("{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
    return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
  }

  // build update employee
  @PutMapping("{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
    return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
  }

  // build delete employee
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
    employeeService.deleteEmployee(id);
    return new ResponseEntity<String>(String.format("Employee deleted successfully with id : %d", id), HttpStatus.OK);
  }
}
