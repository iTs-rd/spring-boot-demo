package in.rudresh.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.rudresh.springrestapi.model.Employee;
import in.rudresh.springrestapi.service.EmployeeService;


@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService eService;
	
	
	@Value("${app.name: Employee Tracker}")
	private String appName;
	
	@Value("${app.version: 1}")
	private String appVersion;

	@GetMapping("/appdetails")
	public String getAppDetails() {
		return appName+" - v"+appVersion;
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return eService.getEmployee();
	}
	
	@GetMapping("/employees/{id}")
	public String getEmployee(@PathVariable Long id) {
		return "Fetching data of employee whose id is "+id;
	}
	
	@DeleteMapping("/employees")
	public String deleteEmployee(@RequestParam("id") Long pk) {
		return "Employee having id "+pk+" will deleted";
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@RequestBody Employee employee) {
		return 	"saving the employee in DB " + employee;
		
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		System.out.println("employee id "+id);
		return employee;
	}

}
