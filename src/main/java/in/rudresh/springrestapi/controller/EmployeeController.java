package in.rudresh.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.rudresh.springrestapi.model.Department;
import in.rudresh.springrestapi.model.Employee;
import in.rudresh.springrestapi.repository.DepartmentRepository;
import in.rudresh.springrestapi.repository.EmployeeRepository;
import in.rudresh.springrestapi.request.EmployeeRequest;
import in.rudresh.springrestapi.service.EmployeeService;
import jakarta.validation.Valid;


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
	
	@Autowired
	private DepartmentRepository dRepo;
	
	@Autowired
	private EmployeeRepository eRepo;
	
	
	
	
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber,@RequestParam Integer pageSize) {
		return new ResponseEntity<List<Employee>> (eService.getEmployee(pageNumber,pageSize),HttpStatus.OK);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		return new ResponseEntity<Employee>( eService.getSingleEmployee(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/employees")
	public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id") Long pk) {
		eService.deleteEmployee(pk);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeRequest eRequest) {

		Employee employee = new Employee(eRequest);
		employee=eRepo.save(employee);
		
		for (String s:eRequest.getDepartment()) {
			Department d=new Department();
			d.setName(s);
			d.setEmployee(employee);
			dRepo.save(d);
		}
		return new ResponseEntity<String>("Record saved",HttpStatus.OK);
		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		System.out.println("employee id "+id);
		employee.setId(id);
		return new ResponseEntity<Employee>(eService.updateEmployee(employee),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/employees/filterByName")
	public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam("name") String name) {
		return new ResponseEntity<List<Employee>>(eService.getEmployeeByName(name),HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/employees/filterByNameAndLocation")
	public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name,@RequestParam String location) {
		return new ResponseEntity<List<Employee>>(eService.getEmployeeByNameAndLocation(name, location),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/employees/filterByNameContaining")
	public ResponseEntity<List<Employee>> getEmployeesByNameContaining(@RequestParam String keyword) {
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByNameContaining(keyword),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/employees/filterByNameOrLocation")
	public ResponseEntity<List<Employee>> filterByNameOrLocation(@RequestParam String name,@RequestParam String location) {
		return new ResponseEntity<List<Employee>>(eService.getEmployeesWithNameOrLocation(name, location),HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/employee/delete/{name}")
	public ResponseEntity<Integer> deleteEmployeesByName(@PathVariable String name) {
		return new ResponseEntity<Integer>(eService.deleteEmployeesByName(name),HttpStatus.ACCEPTED);
	}
	
	
	
	
	@GetMapping("/employee2")
	public ResponseEntity<List<Employee>> getEmployeeByDepartment(@RequestParam String name){
//		return new ResponseEntity<List<Employee>>(eRepo.findByDepartmentName(name),HttpStatus.OK);
		return new ResponseEntity<List<Employee>>(eRepo.findByDeptName(name),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/emply")
	public List<Employee> getEmployee2(){
		return eRepo.getEmployee();
	}
}

























