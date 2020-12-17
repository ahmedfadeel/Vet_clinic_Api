package com.example.ahmed.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ahmed.model.Owner;
import com.example.ahmed.model.Pet;
import com.example.ahmed.repository.OwnerRepository;

@Service
public class OwnerService {
 @Autowired
 OwnerRepository ownerRepository;
 
 public List<Owner> findAll(){
	 return ownerRepository.findAll();
 }
 
 // add 
 public  Owner addOwner(Owner owner ) {
	 return  ownerRepository.save(owner);
	 
 }
 //delete 
 public  void deleteOwner(Owner owner ) {
	 ownerRepository.delete(owner);
	  
 }
// findByID	
 public Optional<Owner> findById(long id ) {
	 return  ownerRepository.findByownerId(id);
	 
 }
 
 Set<Pet> getOwnerPets(Owner owner){
	 return  owner.getPets();
 }
 
 
}
