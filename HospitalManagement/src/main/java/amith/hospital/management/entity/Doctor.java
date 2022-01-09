package amith.hospital.management.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Doctor 
{
	@Id
	private long docid;
	
	private String name;
	private String mobile;
	private String specialization;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_id", referencedColumnName = "deptid")
	private Department department;
	
	@ManyToMany(mappedBy="doctor")
//	@JsonBackReference
	@JsonIgnore
	private Set<Patient> patient;
	
	public Doctor() {
		super();
	}

	public Doctor(long docid, String name, String mobile, String specialization, Department department,
			Set<Patient> patient) {
		super();
		this.docid = docid;
		this.name = name;
		this.mobile = mobile;
		this.specialization = specialization;
		this.department = department;
		this.patient = patient;
	}

	public long getDocid() {
		return docid;
	}

	public void setDocid(long docid) {
		this.docid = docid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Patient> getPatient() {
		return patient;
	}

	public void setPatient(Set<Patient> patient) {
		this.patient = patient;
	}
	
}
