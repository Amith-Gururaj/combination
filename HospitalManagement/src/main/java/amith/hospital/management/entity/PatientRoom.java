package amith.hospital.management.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Rooms")
public class PatientRoom 
{
	@Id
	private long roomid; // primary key
	private String roomtype;
	
	@OneToOne( mappedBy = "patientroom" ) // bidirectional mapping 
//	@JsonManagedReference
	@JsonIgnore
	private Patient patient;
	
	public PatientRoom() // no args constructor
	{
		super();
	}
	public PatientRoom(long roomid, String roomtype, Patient patient) // Constructor for creating a Room with patient
	{
		super();
		this.roomid = roomid;
		this.roomtype = roomtype;
		this.patient = patient;
	}
	public PatientRoom(long roomid, String roomtype) // Constructor for creating a Room without patient
	{
		super();
		this.roomid = roomid;
		this.roomtype = roomtype;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public long getRoomid() {
		return roomid;
	}
	public void setRoomid(long roomid) {
		this.roomid = roomid;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}	
}
