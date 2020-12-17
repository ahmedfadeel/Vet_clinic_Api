package com.example.ahmed.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ahmed.exception.ResourceNotFoundException;
import com.example.ahmed.model.Clinic;
import com.example.ahmed.model.Doctor;
import com.example.ahmed.service.ClinicService;

@RestController
@RequestMapping("apiv1/clinics")
public class ClinicController {
  
	 
	 @Autowired
	 ClinicService clinicService;
	 
	 Logger logger = LoggerFactory.getLogger(ClinicController.class);
	 
	 @PostMapping("/save")
	 public ResponseEntity<?> save (@Valid @RequestBody Clinic clinic) {
		 return ResponseEntity.ok(clinicService.addClinic(clinic));
	 }
	 
	 
	 
	 @GetMapping("")
	 public ResponseEntity<?>getAllClinics() {
          
		  
		 List<Clinic>  clinicList=clinicService.findAll();
		
		 if (clinicList.isEmpty() ) {
	      throw new  ResourceNotFoundException("no Clinics found ");
		 }
		 return  ResponseEntity.ok(clinicList);
	 }
	 
	 
	 @GetMapping("/{id}")
	  public ResponseEntity<Clinic> getClinicById(@PathVariable long id ){
		 Clinic clinic=clinicService.findById(id)
				  .orElseThrow(()-> new ResourceNotFoundException("Clinic not exists with id "+id ));
		  return ResponseEntity.ok(clinic);
	  }
	 @GetMapping("/{id}/doctors")
	  public ResponseEntity<Set<Doctor>> getDoctorsByClinicId(@PathVariable long id ){
		 Clinic clinic=clinicService.findById(id)
				  .orElseThrow(()-> new ResourceNotFoundException("Clinic not exists with id "+id ));
		  
		 Set<Doctor> doctorList=clinic.getDoctors();
		 
		 if (doctorList.isEmpty()) {
			 throw new  ResourceNotFoundException("no Doctors  found  for ClinicId  "+ id ); 
		 }
		 return ResponseEntity.ok(doctorList);
	  }
	 
	
	
	 
	 
}
