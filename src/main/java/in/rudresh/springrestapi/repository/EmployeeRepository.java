package in.rudresh.springrestapi.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.rudresh.springrestapi.model.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	
	List<Employee> findByName(String name);
	
	List<Employee> findByNameAndLocation(String name,String location);
	
	List<Employee> findByNameContaining(String keyword,Sort sort);
	
//	List<Employee> findByNameLike(String "%"+ keyword +"%");
	
	@Query("FROM Employee Where name = :name OR location=:location")
	List<Employee> getEmployeesWithNameOrLocation(String name,String location);
	
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Employee WHERE name=:name")
	Integer deleteEmployeesByName(String name);
	
	
}
