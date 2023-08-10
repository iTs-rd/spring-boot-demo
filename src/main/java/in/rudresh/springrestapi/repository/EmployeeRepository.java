package in.rudresh.springrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.rudresh.springrestapi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
