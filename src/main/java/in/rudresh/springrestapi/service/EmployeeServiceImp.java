package in.rudresh.springrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rudresh.springrestapi.model.Employee;
import in.rudresh.springrestapi.repository.EmployeeRepository;


@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeRepository eRepository;
	
		
	@Override
	public List<Employee> getEmployee() {
		return eRepository.findAll();
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return eRepository.save(employee);
	}

}
