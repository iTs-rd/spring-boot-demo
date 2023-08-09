package in.rudresh.springrestapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpMethod;

@Controller
public class EmployeeController {
	
	
	@RequestMapping(value="/employees",method=RequestMethod.GET)
	@ResponseBody
	public String getEmployees() {
		return "list of employee";
	}

}
