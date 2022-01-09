package amith.hospital.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import amith.hospital.management.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long>
{
	@Query("select dt.deptname from Doctor d join d.department dt where d.docid=?1") // JPQL
	public String deptNameByDocId(Long id);
}
