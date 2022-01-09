package amith.hospital.management.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table( 
	uniqueConstraints = @UniqueConstraint(
			name = "mobile_number",
			columnNames = "mobile"
			)
	 )
public class Patient 
{
	@Id
//	@SequenceGenerator(
//			name = "patient_sequence",
//			sequenceName="patient_sequence",
//			allocationSize=1
//			)
//	@GeneratedValue(
//			strategy = GenerationType.SEQUENCE,
//			generator = "patient_sequence"
//			)
	private long pid; // primary key
	
	private String name;
	private String mobile;
	private int age;
	
	@Embedded
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL) // persist all the operations in the patientroom table also
	@JoinColumn( name = "room_id", referencedColumnName = "roomid") // foreign key in patient table referencing roomid of patientroom table
	private PatientRoom patientroom;
	
	@ManyToMany
	@JoinTable(
			name = "pat_doc",
			joinColumns = @JoinColumn(name="pid"),
			inverseJoinColumns = @JoinColumn(name="docid")
			)
	private Set<Doctor> doctor;

	public Patient() {
		super();
	}

	public Patient(long pid, String name, String mobile, int age, Address address, PatientRoom patientroom,
			Set<Doctor> doctor) {
		super();
		this.pid = pid;
		this.name = name;
		this.mobile = mobile;
		this.age = age;
		this.address = address;
		this.patientroom = patientroom;
		this.doctor = doctor;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public PatientRoom getPatientroom() {
		return patientroom;
	}

	public void setPatientroom(PatientRoom patientroom) {
		this.patientroom = patientroom;
	}

	public Set<Doctor> getDoctor() {
		return doctor;
	}

	public void setDoctor(Set<Doctor> doctor) {
		this.doctor = doctor;
	}
	
}
