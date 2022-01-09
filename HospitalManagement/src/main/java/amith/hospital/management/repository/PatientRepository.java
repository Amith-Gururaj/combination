package amith.hospital.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import amith.hospital.management.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>
{
	@Query("select r.roomid from Patient p join p.patientroom r where p.pid=?1") //JPQL
	public Long roomByPatientId(Long id);
}
