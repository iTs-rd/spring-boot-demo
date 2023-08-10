package in.rudresh.springrestapi.service;

import java.util.List;

import in.rudresh.springrestapi.model.Employee;

public interface EmployeeService {

	List<Employee> getEmployee();
	
	Employee saveEmployee(Employee employee);
}
