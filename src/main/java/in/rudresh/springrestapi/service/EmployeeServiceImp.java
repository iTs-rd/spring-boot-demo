package in.rudresh.springrestapi.service;

import java.util.List;
import java.util.Optional;

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


	@Override
	public Employee getSingleEmployee(Long id) {
		Optional<Employee> employee= eRepository.findById(id);
		if(employee.isPresent())
			return employee.get();
		else
			throw new RuntimeException("employee not found for the id "+id);
	}


	@Override
	public String deleteEmployee(Long id) {
		eRepository.deleteById(id);
		return "Employee with employee id "+id+" has been deleted";
	}


	@Override
	public Employee updateEmployee(Employee employee) {
		return eRepository.save(employee);
	}


}
