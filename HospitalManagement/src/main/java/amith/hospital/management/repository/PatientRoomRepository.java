package amith.hospital.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import amith.hospital.management.entity.PatientRoom;

@Repository
public interface PatientRoomRepository extends JpaRepository<PatientRoom,Long>
{

}
