package in.rudresh.springrestapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.http.HttpMethod;

//@Controller
@RestController //@Controller + @ResponseBody
public class EmployeeController {
	
	
//	@RequestMapping(value="/employees",method=RequestMethod.GET)
	@GetMapping("/employees")
	public String getEmployees() {
		return "list of all employee";
	}
	
	@GetMapping("/employees/{id}")
	public String getEmployee(@PathVariable Long id) {
		return "Fetching data of employee whose id is "+id;
	}
	
	@DeleteMapping("/employees")
	public String deleteEmployee(@RequestParam("id") Long pk) {
		return "Employee having id "+pk+" will deleted";
	}

}
