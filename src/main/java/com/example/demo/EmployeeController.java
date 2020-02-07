package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("employees/{id}")
    public Optional<Employee> getAllEmployeeById(@PathVariable(value="id") Integer id){
        return employeeRepository.findById(id);
    }

    @PostMapping("/employees")
    public @Valid Employee createEmployee(@Valid @RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @PutMapping("/employees/{id}")
    public @Valid Employee updateEmployee(@PathVariable(value = "id") Integer id, @Valid @RequestBody Employee employee)
    throws EmployeeNotFoundException{
        Employee emp = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        emp.setName(employee.getName());
        Employee updEmployee = employeeRepository.save(emp);
        return updEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id)
            throws EmployeeNotFoundException{
        Employee emp = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        employeeRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
