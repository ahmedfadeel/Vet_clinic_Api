package com.example.ahmed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ahmed.model.Visit;
import com.example.ahmed.repository.VisitRepository;

@Service
public class VisitService {
 @Autowired
 VisitRepository visitRepository;
 
 public List<Visit> findAll(){
	 return visitRepository.findAll();
 }
 // add 
 public  Visit addVisit(Visit visit ) {
	 return  visitRepository.save(visit);
	 
 }
 //delete 
 public  void deleteVisit(Visit visit ) {
	 visitRepository.delete(visit);
	  
 }
// findByID	
 public Optional<Visit> findById(long id ) {
	 return  visitRepository.findByvisitId(id);
	 
 }
 
 
 
}
