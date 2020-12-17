package com.example.ahmed.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ahmed.exception.ResourceNotFoundException;
import com.example.ahmed.model.Clinic;
import com.example.ahmed.model.Doctor;
import com.example.ahmed.service.ClinicService;
import com.example.ahmed.service.DoctorService;

@RestController
@RequestMapping("apiv1/doctors")
public class DoctorController {
  
	 @Autowired
	 DoctorService doctorService;
	 @Autowired
	 ClinicService clinicService;
	 
	 Logger logger = LoggerFactory.getLogger(DoctorController.class);
	 
	 @PostMapping("/save")
	 public ResponseEntity<?> save (@Valid @RequestBody Doctor doctor) {
		 return ResponseEntity.ok(doctorService.addDoctor(doctor));
	 }
	 
	 @PostMapping("/{id}/image")
     public ResponseEntity<?> handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file){ 
		 doctorService.saveImageFile(Long.valueOf(id), file);

       return  ResponseEntity.ok("image saved successfully");

	 }
	 
	 @GetMapping("")
	 public ResponseEntity<?>getAllDoctors() {
          
		  
		 List<Doctor>  doctorList=doctorService.findAll();
		
		 if (doctorList.isEmpty() ) {
	      throw new  ResourceNotFoundException("no doctors found ");
		 }
		 return  ResponseEntity.ok(doctorList);
	 }
	 
	 
	 @GetMapping("/{id}")
	  public ResponseEntity<Doctor> getDoctorById(@PathVariable long id ){
		 Doctor doctor=doctorService.findById(id)
				  .orElseThrow(()-> new ResourceNotFoundException("doctor not exists with id "+id ));
		  return ResponseEntity.ok(doctor);
	  }
	 
	 @GetMapping("/{doctorId}/clinicId")
	 public ResponseEntity<Doctor> getDoctorById(@PathVariable long doctorId ,@PathVariable long clinicId ){
		 Doctor doctor=doctorService.findById(doctorId)
				 .orElseThrow(()-> new ResourceNotFoundException("doctor not exists with id "+doctorId ));
		 Clinic clinic=clinicService.findById(clinicId)
				 .orElseThrow(()-> new ResourceNotFoundException("clinic not exists with id "+clinicId ));
		 doctorService.reasignDoctorToClinic(doctor, clinic);
		
		 return ResponseEntity.ok(doctor);
	 }
	
	 
	 
}
