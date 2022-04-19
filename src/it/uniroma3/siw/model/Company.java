package it.uniroma3.siw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Company {
	 /*
	  * Le scelte che motivano la scelta delle politiche di FETCH e
	  * CASCADE si trovano nel main.
	  */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String denomination;
	private String address;
	private String phoneNumber;
	
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
