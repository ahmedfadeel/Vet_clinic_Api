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
import org.springframework.web.bind.annotation.RestController;

import com.example.ahmed.exception.ResourceNotFoundException;
import com.example.ahmed.model.Pet;
import com.example.ahmed.service.PetService;

@RestController
@RequestMapping("apiv1/pets")
public class PetController {
  
	 
	 @Autowired
	 PetService petService;
	 
	 Logger logger = LoggerFactory.getLogger(PetController.class);
	 
	 @PostMapping("/save")
	 public ResponseEntity<?> save (@Valid @RequestBody Pet pet) {
		 return ResponseEntity.ok(petService.addPet(pet));
	 }
	 
	 
	 
	 @GetMapping("")
	 public ResponseEntity<?>getAllPets() {
          
		  
		 List<Pet>  petList=petService.findAll();
		
		 if (petList.isEmpty() ) {
	      throw new  ResourceNotFoundException("no Pets found ");
		 }
		 return  ResponseEntity.ok(petList);
	 }
	 
	 
	 @GetMapping("/{id}")
	  public ResponseEntity<Pet> getPetById(@PathVariable long id ){
		 Pet pet=petService.findById(id)
				  .orElseThrow(()-> new ResourceNotFoundException("Pets not exists with id "+id ));
		  return ResponseEntity.ok(pet);
	  }
	 
	
	
	 
	 
}
