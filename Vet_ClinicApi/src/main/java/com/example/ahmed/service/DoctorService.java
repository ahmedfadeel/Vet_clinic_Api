package com.example.ahmed.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ahmed.model.Clinic;
import com.example.ahmed.model.Doctor;
import com.example.ahmed.repository.DoctorRepository;

@Service
public class DoctorService {
 @Autowired
 DoctorRepository doctorRepository;
 
 public List<Doctor> findAll(){
	 return doctorRepository.findAll();
 }
 // add 
 public  Doctor addDoctor(Doctor doctor ) {
	 return  doctorRepository.save(doctor);
	 
 }
 //delete 
 public  void deleteDoctor(Doctor doctor ) {
	 doctorRepository.delete(doctor);
	  
 }
// findByID	
 public Optional<Doctor> findById(long id ) {
	 return  doctorRepository.findBydoctorId(id);
	 
 }
 
 
 
 @Transactional
 public void saveImageFile(Long doctorId, MultipartFile file) {

 try {
	 Doctor doctor = doctorRepository.findBydoctorId(doctorId).get();

     Byte[] byteObjects = new Byte[file.getBytes().length];

     int i = 0;

     for (byte b : file.getBytes()){
         byteObjects[i++] = b;
     }

     doctor.setPhoto(byteObjects);

     doctorRepository.save(doctor);
 } catch (IOException e) {
     

     e.printStackTrace();
 }
 }

 // assign doctor to clinic 
   // doctor.setClinic=clinic
 
 //  deasign  doctor to aclinic 
 
 public Doctor reasignDoctorToClinic(Doctor doctor,Clinic clinic ) {
	 
    doctor.setClinic(clinic); 
	 return doctor;
	 
 }
 
 


}
