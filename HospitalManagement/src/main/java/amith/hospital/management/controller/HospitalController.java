package amith.hospital.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import amith.hospital.management.entity.Department;
import amith.hospital.management.entity.Doctor;
import amith.hospital.management.entity.Patient;
import amith.hospital.management.entity.PatientRoom;
import amith.hospital.management.service.HospitalService;

@RestController
@RequestMapping(path="/hospital")
public class HospitalController 
{
	@Autowired
	private HospitalService hospitalservice;

	public HospitalController(HospitalService hospitalservice) {
		super();
		this.hospitalservice = hospitalservice;
	}
	
	@GetMapping(path="/getAllPatients")
	public @ResponseBody Iterable<Patient> getAllPatients()
	{
		return hospitalservice.listAllPatients();
	}
	
	@GetMapping(path="/getAllDoctors")
	public @ResponseBody Iterable<Doctor> getAllDoctors()
	{
		return hospitalservice.listAllDoctors();
	}
	
	@GetMapping(path="/getAllDepartments")
	public @ResponseBody Iterable<Department> getAllDepartments()
	{
		return hospitalservice.listAllDepartments();
	}
	
	@GetMapping(path="/getAllRooms")
	public @ResponseBody Iterable<PatientRoom> getAllRooms()
	{
		return hospitalservice.listAllRooms();
	}
	
	@PostMapping(path="/addPatient")
	public @ResponseBody String addPatient(@RequestBody Patient p)
	{
		return hospitalservice.admitPatient(p);
	}
	
	@PostMapping(path="/addDoctor")
	public @ResponseBody String addDoctor(@RequestBody Doctor d)
	{
		return hospitalservice.onboardDoctor(d);	
	}
	
	@GetMapping(path="/getPatientById")
	public @ResponseBody Patient getPatientById(@RequestParam long id)
	{
		return hospitalservice.checkPatientById(id);
	}
	
	@GetMapping(path="/getDoctorById")
	public @ResponseBody Doctor getDoctorById(@RequestParam long id)
	{
		return hospitalservice.checkDoctorById(id);
	}
	
	@DeleteMapping(path="/deletePatient")
	public @ResponseBody String deletePatientById(@RequestParam long id)
	{
		return hospitalservice.removePatientById(id);
	}
	
	@DeleteMapping(path="/deleteDoctor")
	public @ResponseBody String deleteDoctorById(@RequestParam long id)
	{
		return hospitalservice.removeDoctorById(id);
	}
	
	@GetMapping(path="/getRoomByPatId")
	public @ResponseBody Long getRoomByPatientId(@RequestParam Long id)
	{
		return hospitalservice.checkRoomByPatientId(id);
	}
	
	@GetMapping(path="/deptNameByDocId")
	public @ResponseBody String getdeptNameByDocId(@RequestParam Long id)
	{
		return hospitalservice.checkdeptNameByDocId(id);
	}
}
