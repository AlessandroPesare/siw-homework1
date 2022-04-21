package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Teacher {
	public Teacher() {
		this.courses = new ArrayList<>();
	}
	 public Teacher(Long id, String firstName, String lastName, LocalDate dateOfBirth, String placeOfBirth,
			int vatNumber, List<Course> courses) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.vatNumber = vatNumber;
		this.courses = courses;
	}
	/*
	  * Le scelte che motivano la scelta delle politiche di FETCH e
	  * CASCADE si trovano nel main.
	  */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String placeOfBirth;
	private int vatNumber;
	@OneToMany(mappedBy = "teacher")
	private List<Course> courses;

	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	public int getVatNumber() {
		return vatNumber;
	}
	public void setVatNumber(int vatNumber) {
		this.vatNumber = vatNumber;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
