package in.rudresh.springrestapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rudresh.springrestapi.model.Employee;
import in.rudresh.springrestapi.repository.EmployeeRepository;


@Service
public class EmployeeServiceImp implements EmployeeService {

//	private static List<Employee> list=new ArrayList<>();
//	
//	static {
//		Employee e=new Employee();
//		e.setName("Ankit");
//		e.setAge((long) 15);
//		e.setDepartment("DevOps");
//		e.setEmail("ankit@kotak.com");
//		e.setLocation("mumbai");
//		list.add(e);
//		
//		e=new Employee();
//		e.setName("abhi");
//		e.setAge((long) 22);
//		e.setDepartment("software");
//		e.setEmail("abhi.com");
//		e.setLocation("gkp");
//		list.add(e);
//	}
	
	@Autowired
	private EmployeeRepository eRepository;
	
		
	@Override
	public List<Employee> getEmployee() {
		return eRepository.findAll();
	}

}
