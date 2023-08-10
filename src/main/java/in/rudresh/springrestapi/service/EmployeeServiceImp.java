package in.rudresh.springrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.rudresh.springrestapi.model.Employee;
import in.rudresh.springrestapi.repository.EmployeeRepository;


@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeRepository eRepository;
	
		
	@Override
	public List<Employee> getEmployee(int pageNumber,int pageSize) {
		Pageable pages = PageRequest.of(pageNumber, pageSize,Direction.DESC, "id");
		return eRepository.findAll(pages).getContent();
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


	@Override
	public List<Employee> getEmployeeByName(String name) {
		return eRepository.findByName(name);

	}


	@Override
	public List<Employee> getEmployeeByNameAndLocation(String name, String location) {
		return eRepository.findByNameAndLocation(name, location);
	}


	@Override
	public List<Employee> getEmployeesByNameContaining(String keyword) {
		Sort sort=Sort.by(Sort.Direction.DESC,"id");
		return eRepository.findByNameContaining(keyword,sort);
	}


	@Override
	public List<Employee> getEmployeesWithNameOrLocation(String name, String Location) {
		return eRepository.getEmployeesWithNameOrLocation(name, Location);
	}


}

















