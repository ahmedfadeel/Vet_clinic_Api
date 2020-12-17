package com.example.ahmed.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name="doctors")
public class Doctor  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long doctorId;	

    @Column(unique = true )
    @NotNull
	private String name;
	
	@NotNull
	@Pattern(regexp="[0-9]{11}" ,message = "phone number must be eleven numbers  ") 
	private String phone ;
	
	
	@Lob
	private Byte[] photo;

	private String bio ;

	
	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn( name = "clinicId" , columnDefinition="default is  NULL ", nullable = true)
	  private Clinic  clinic ;

	
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "doctor", orphanRemoval = true)
	  private Set<Visit> visits; 
	
	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(Byte[] photo) {
		this.photo = photo;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	
	
	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	@Transactional
	public Set<Visit> getVisits() {
		return visits;
	}

	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}
}
