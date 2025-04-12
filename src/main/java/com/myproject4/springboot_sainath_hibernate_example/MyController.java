package com.myproject4.springboot_sainath_hibernate_example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@Autowired
	EmployeeRepository erepo;
	@RequestMapping("/test")
	public String test()
	{
		return "this is test only";
		
	}
	@PostMapping("/save")
	public Employee save(@RequestBody Employee employee)
	{
		return erepo.save(employee);
	}
	@GetMapping("/all")
	public List<Employee> all()
	{
		return erepo.findAll();
	}
	@GetMapping("/by/{id}")
	public Optional<Employee> byid(@PathVariable int id)
	{
		return erepo.findById(id);
	}
	@DeleteMapping("/del/{id}")
	public String del(@PathVariable int id )
	{
		erepo.deleteById(id);
		return "data delete for" +id;
	}
	@PutMapping("/update/{id}")
	public Employee upd(@PathVariable int id,@RequestBody  Employee employee)
	{
		Employee emp=erepo.findById(id).get();
		emp.setAge(employee.getAge());
		emp.setCity(employee.getCity());
		emp.setCountry(employee.getCountry());
		emp.setName(employee.getName());
		erepo.save(emp);
		return emp;
	}
	@PatchMapping("/path/{id}")
	public Employee path(@PathVariable int id,@RequestBody  Employee employee)
	{
		Employee emp=erepo.findById(id).get();
		emp.setAge(employee.getAge());
		emp.setCity(employee.getCity());
		emp.setCountry(employee.getCountry());
		emp.setName(employee.getName());
		erepo.save(emp);
		return emp;
	}

}
