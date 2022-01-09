package amith.hospital.management.service;

import amith.hospital.management.entity.Department;
import amith.hospital.management.entity.Doctor;
import amith.hospital.management.entity.Patient;
import amith.hospital.management.entity.PatientRoom;

public interface HospitalService 
{
	public Iterable<Patient> listAllPatients();
	public Iterable<Doctor> listAllDoctors();
	public Iterable<Department> listAllDepartments();
	public Iterable<PatientRoom> listAllRooms();
	
	public String admitPatient(Patient p);
	public String onboardDoctor(Doctor d);
	
	public Patient checkPatientById(long id);
	public Doctor checkDoctorById(long id);
	
	public String removePatientById(long id);
	public String removeDoctorById(long id);
	
	public Long checkRoomByPatientId(long id);  // Custom Query
	
	public String checkdeptNameByDocId(Long id); // Custom Query
}
