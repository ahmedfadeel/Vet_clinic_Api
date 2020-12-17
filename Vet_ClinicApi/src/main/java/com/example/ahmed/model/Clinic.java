package com.example.ahmed.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;


 /*i have film object 
  * then i can get all its categories as a list of objects 
  * 
  * 
  * */
@Entity
@Table(name="clinics")

public class Clinic  implements Serializable{
	/*  Clinic  
	 * 
	 * 
	 * 
	 * */
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long clinicId;	
 
    @Column(unique = true )
    @NotNull
	private String name;
   

	@Email(message = "Email should be valid")
	private String Email ;
	
	
	@NotNull
	@Pattern(regexp="[0-9]{11}" ,message = "phone number must be eleven numbers  ") 
	private String phone ;
	
	
	private String WorkingDaysAndHours ;
	
	 @ManyToOne( fetch = FetchType.LAZY)
	  @JoinColumn(name = "addressId")
	  private Address clinicAddress;
	
	
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinic", orphanRemoval = true)
	 private Set<Doctor> doctors = new HashSet<>();
    
	
	 
	
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinic", orphanRemoval = true)
	  private Set<Visit> visits;
	
	

	public long getClinicId() {
		return clinicId;
	}

	public void setClinicId(long clinicId) {
		this.clinicId = clinicId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWorkingDaysAndHours() {
		return WorkingDaysAndHours;
	}

	public void setWorkingDaysAndHours(String workingDaysAndHours) {
		WorkingDaysAndHours = workingDaysAndHours;
	}

	
	// no reference to doctor in clinic 
	
	
	
	 
	
	public Address getClinicAddress() {
		return clinicAddress;
	}

	public void setClinicAddress(Address address) {
		this.clinicAddress = address;
	}
	
	 public Set<Visit> getVisits() {
		return visits;
	}

	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}

	@Transactional
	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	} 
		

	
}
