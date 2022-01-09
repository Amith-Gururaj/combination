package amith.hospital.management.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address 
{
	@Column(name="Address",nullable=false)
	private String houseaddress;
	
	private String landmark;
	
	
	public Address() {
		super();
	}
	public Address(String houseaddress, String landmark) {
		super();
		this.houseaddress = houseaddress;
		this.landmark = landmark;
	}
	public String getHouseaddress() {
		return houseaddress;
	}
	public void setHouseaddress(String houseaddress) {
		this.houseaddress = houseaddress;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
}
