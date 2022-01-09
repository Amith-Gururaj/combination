package amith.hospital.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import amith.hospital.management.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> 
{

}
