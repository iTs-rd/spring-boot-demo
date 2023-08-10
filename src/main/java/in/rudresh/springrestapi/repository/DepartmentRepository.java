package in.rudresh.springrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.rudresh.springrestapi.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{

}
