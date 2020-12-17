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
import com.example.ahmed.model.Owner;
import com.example.ahmed.model.Pet;
import com.example.ahmed.service.ClinicService;
import com.example.ahmed.service.OwnerService;

@RestController
@RequestMapping("apiv1/owners")
public class OwnerController {
  
	 @Autowired
	 OwnerService ownerService;
	 @Autowired
	 ClinicService clinicService;
	 
	 Logger logger = LoggerFactory.getLogger(OwnerController.class);
	 
	 @PostMapping("/save")
	 public ResponseEntity<?> save (@Valid @RequestBody Owner owner) {
		 return ResponseEntity.ok(ownerService.addOwner(owner));
	 }
	 
	 
	 
	 @GetMapping("")
	 public ResponseEntity<?>getAllowners() {
          
		  
		 List<Owner>  ownerList=ownerService.findAll();
		
		 if (ownerList.isEmpty() ) {
	      throw new  ResourceNotFoundException("no Owners found ");
		 }
		 return  ResponseEntity.ok(ownerList);
	 }
	 
	 
	 @GetMapping("/{id}")
	  public ResponseEntity<Owner> getOwnerById(@PathVariable long id ){
		 Owner owner=ownerService.findById(id)
				  .orElseThrow(()-> new ResourceNotFoundException("Owner not exists with id "+id ));
		  return ResponseEntity.ok(owner);
	  }
	 
	 @GetMapping("/{id}/pets")
	  public ResponseEntity<Set<Pet>> getDoctorsByClinicId(@PathVariable long id ){
		 Owner owner=ownerService.findById(id)
				  .orElseThrow(()-> new ResourceNotFoundException("Pets not exists with id "+id ));
		  
		 Set<Pet> petList=owner.getPets();
		 
		 if (petList.isEmpty()) {
			 throw new  ResourceNotFoundException("no pets  found  for PetId  "+ id ); 
		 }
		 return ResponseEntity.ok(petList);
	  }
	 
	
	 
	 
}
