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
@Table(name="owners")
public class Owner implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ownerId;	

    @Column(unique = true )
    @NotNull
	private String name;
    
    
	@Email(message = "Email should be valid")
	private String Email ;
	
	@NotNull
	@Pattern(regexp="[0-9]{11}" ,message = "phone number must be eleven numbers  ") 
	private String phone ;
	
	@NotNull
	private String gender ;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "owner", orphanRemoval = true)
	  private Set<Pet> pets;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "owner", orphanRemoval = true)
	  private Set<Visit> visits;
	
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "addressId", nullable = true)
	  private Address ownerAddress;
	 
	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<Pet> getPets() {
		return pets;
	}
	
	public Address getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(Address address) {
		this.ownerAddress = address;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	
	
	public Set<Visit> getVisits() {
		return visits;
	}

	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	} 
	
}
