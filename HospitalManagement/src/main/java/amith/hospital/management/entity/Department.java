package amith.hospital.management.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department 
{
	@Id
	private long deptid;
	private String deptname;
	
	@OneToMany( mappedBy = "department")
	@JsonIgnore
	private Set<Doctor> doctor;

	public Department() {
		super();
	} 
	
	public Department(long deptid, String deptname, Set<Doctor> doctor) 
	{
		super();
		this.deptid = deptid;
		this.deptname = deptname;
		this.doctor = doctor;
	}

	public long getDeptid() {
		return deptid;
	}

	public void setDeptid(long deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public Set<Doctor> getDoctor() {
		return doctor;
	}

	public void setDoctor(Set<Doctor> doctor) {
		this.doctor = doctor;
	}
}
