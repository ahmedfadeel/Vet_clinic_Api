package com.example.ahmed.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="visits")
public class Visit  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long visitId;	

	
	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "doctorId", columnDefinition="default is  NULL ",  nullable = true)
	  private Doctor doctor=null;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "petId", columnDefinition="default is  NULL ",  nullable = true)
	  private Pet pet=null;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "clinicId", columnDefinition="default is  NULL ", nullable = true )
	  private Clinic clinic=null;

	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "ownerId", columnDefinition="default is NULL ", nullable = true)
	  private Owner owner=null;
	
	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	private LocalDate  date;
	
}
