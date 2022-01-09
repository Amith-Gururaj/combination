package amith.hospital.management.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amith.hospital.management.entity.Department;
import amith.hospital.management.entity.Doctor;
import amith.hospital.management.entity.Patient;
import amith.hospital.management.entity.PatientRoom;
import amith.hospital.management.repository.DepartmentRepository;
import amith.hospital.management.repository.DoctorRepository;
import amith.hospital.management.repository.PatientRepository;
import amith.hospital.management.repository.PatientRoomRepository;
import amith.hospital.management.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService
{
	@Autowired
	private PatientRepository patientrepo;
	
	@Autowired
	private DoctorRepository doctorrepo;
	
	@Autowired
	private DepartmentRepository departmentrepo;
	
	@Autowired
	private PatientRoomRepository patientroomrepo;

	public HospitalServiceImpl(PatientRepository patientrepo, DoctorRepository doctorrepo,
			DepartmentRepository departmentrepo, PatientRoomRepository patientroomrepo) {
		super();
		this.patientrepo = patientrepo;
		this.doctorrepo = doctorrepo;
		this.departmentrepo = departmentrepo;
		this.patientroomrepo = patientroomrepo;
	}

	@Override
	public Iterable<Patient> listAllPatients() {
		return patientrepo.findAll();
	}

	@Override
	public Iterable<Doctor> listAllDoctors() {
		return doctorrepo.findAll();
	}

	@Override
	public Iterable<Department> listAllDepartments() {
		return departmentrepo.findAll();
	}

	@Override
	public Iterable<PatientRoom> listAllRooms() {
		return patientroomrepo.findAll();
	}

	@Override
	public String admitPatient(Patient p) {
		patientrepo.save(p);
		return "Patient Admitted Successfully";
	}

	@Override
	public String onboardDoctor(Doctor d) {
		doctorrepo.save(d);
		return "Doctor Added Successfully";
	}

	@Override
	public Patient checkPatientById(long id) {
		return patientrepo.getById(id);
	}

	@Override
	public Doctor checkDoctorById(long id) {
		return doctorrepo.getById(id);
	}

	@Override
	public String removePatientById(long id) {
		patientrepo.deleteById(id);
		return "Patient Discharged Successfully";
	}

	@Override
	public String removeDoctorById(long id) {
		doctorrepo.deleteById(id);
		return "Doctor left the Hospital!";
	}

	@Override
	public Long checkRoomByPatientId(long id) 
	{
		return patientrepo.roomByPatientId(id);
	}

	@Override
	public String checkdeptNameByDocId(Long id) {
		return doctorrepo.deptNameByDocId(id);
	}
		
}
