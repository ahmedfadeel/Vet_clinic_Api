package com.example.ahmed.config;


import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.ahmed.service.*;
import com.example.ahmed.model.*;

@Component
@Order(1)
public class MycommandLineRunner implements CommandLineRunner {
	 Logger  logger=LoggerFactory.getLogger(MycommandLineRunner.class);
	
   //http://localhost:8082/apiv1
	 @Autowired
	 AddressService addressService;
	 @Autowired
	 ClinicService clinicService;
	 @Autowired
	 DoctorService doctorService;
	 @Autowired
	 OwnerService ownerService;
	 @Autowired
	 PetService petService;
	 @Autowired
	 VisitService visitService;
	 
	@Override
	public void run(String... args) throws Exception {
		saveVisit();
   
	}

   void saveVisit(){
	   
	   Set<Clinic>  clinics = clinicService.getClinicDoctors();
	      
	   for (Clinic cli :clinics) {
	    	 System.out.println(cli.getEmail());
	    	 System.out.println(cli.getDoctors().size());
	    	 
	     }
	   /* insert visit 
	    *   
	    *   
         LocalDate ldObj = LocalDate.now();
	    * 
	    * s
	    * */
	   /*
	   Clinic clicin =clinicService.findById(1).get();
	   
	   List<ClinicDTO> dtos= clinicService.findByFirstName("grgrgg");
	     for (ClinicDTO dto :dtos) {
	    	 System.out.println(dto.toString());
	     }
	     
	  // Doctor doctor=doctorService.findById(1).get();
	   /*
	   Owner owner=ownerService.findById(1).get();
	   Pet pet=petService.findById(1).get();
	   LocalDate date = LocalDate.now();
	   
	   Visit visit=new Visit();
	    visit.setClinic(clicin);
	    visit.setDoctor(doctor);
	    visit.setOwner(owner);
	    visit.setPet(pet);
	    visit.setDate(date);
	   // visitService.addVisit(visit); 
	    Set<Pet> pets=owner.getPets();
	   */ 
	     
	    	
	   
	    		
	    		
	    
	  
   }	  
   
}
