package com.example.ahmed.model;

import java.io.Serializable;



public class ClinicDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String Email ;
	private String phone ;
	private String WorkingDaysAndHours ;
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "ClinicDTO [name=" + name + ", Email=" + Email + ", phone=" + phone + ", WorkingDaysAndHours="
				+ WorkingDaysAndHours + "]";
	}

	public ClinicDTO(String name, String email, String phone, String workingDaysAndHours) {
		super();
		this.name = name;
		Email = email;
		this.phone = phone;
		WorkingDaysAndHours = workingDaysAndHours;
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
	
	
}
