package com.example.ahmed.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ahmed.model.Clinic;
import com.example.ahmed.model.ClinicDTO;
import com.example.ahmed.model.Doctor;
import com.example.ahmed.repository.ClinicRepository;

@Service
public class ClinicService {
 @Autowired
 ClinicRepository clinicRepository;
 
 public List<Clinic> findAll(){
	 return clinicRepository.findAll();
 }
 // add 
 public  Clinic addClinic(Clinic clinic ) {
	 return  clinicRepository.save(clinic);
	 
 }
 //delete 
 public  void deleteClinic(Clinic clinic ) {
	 clinicRepository.delete(clinic);
	  
 }
// findByID	
 public Optional<Clinic> findById(long id ) {
	 return  clinicRepository.findByclinicId(id);
	 
 }
 
 
 public Set<Clinic> getClinicDoctors(){
	 return  clinicRepository.getClinicDoctors();
 }
 
 
 public List<ClinicDTO> findByFirstName(String name){
	  return clinicRepository.findByFirstName(name);
 }
 
}
