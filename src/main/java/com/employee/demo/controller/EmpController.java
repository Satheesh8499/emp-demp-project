package com.employee.demo.controller;

import com.employee.demo.enitity.Employee;
import com.employee.demo.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmpController {
    @Autowired
    private EmpRepo employeeRepo;
    @PostMapping ("/create")
    public Employee createEmployee(@RequestBody Employee emp){
         Employee e=employeeRepo.save(emp);
         return e;
    }
    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        Optional<Employee> e= employeeRepo.findById(id);

        return  e.get();
    }
    @GetMapping("/all")
    public List<Employee> getAllEmpl(){
          return  employeeRepo.findAll();
    }
 }
