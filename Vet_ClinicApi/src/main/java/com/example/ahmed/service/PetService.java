package com.example.ahmed.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ahmed.model.Pet;
import com.example.ahmed.repository.PetRepository;

@Service
public class PetService {
 @Autowired
 PetRepository petRepository;
 
 public List<Pet> findAll(){
	 return petRepository.findAll();
 }
 // add 
 public  Pet addPet(Pet pet ) {
	 return  petRepository.save(pet);
	 
 }
 //delete 
 public  void deletePet(Pet pet ) {
	 petRepository.delete(pet);
	  
 }
// findByID	
 public Optional<Pet> findById(long id ) {
	 return  petRepository.findBypetId(id);
	 
 }
 
 
 
 @Transactional
 public void saveImageFile(Long petId, MultipartFile file) {

 try {
	 Pet pet = findById(petId ).get();

     Byte[] byteObjects = new Byte[file.getBytes().length];

     int i = 0;

     for (byte b : file.getBytes()){
         byteObjects[i++] = b;
     }

     pet.setImage(byteObjects);

     petRepository.save(pet);
 } catch (IOException e) {
     

     e.printStackTrace();
 }
 }

}
