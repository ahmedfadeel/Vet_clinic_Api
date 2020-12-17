package com.example.ahmed.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ahmed.model.Address;
import com.example.ahmed.model.Clinic;
import com.example.ahmed.model.Owner;
import com.example.ahmed.repository.AddressRepository;

@Service
public class AddressService {
 @Autowired
 AddressRepository addressRepository;
 
 public List<Address> findAll(){
	 return addressRepository.findAll();
 }
 // add 
 public  Address addAddress(Address address ) {
	 return  addressRepository.save(address);
	 
 }
 //delete 
 public  void deleteAddress(Address address ) {
	 addressRepository.delete(address);
	  
 }
// findByID	
 public Optional<Address> findById(long id ) {
	 return  addressRepository.findByaddressId(id);
	 
 }
 
 Set<Owner> getAddressOwners(Address address){
	 return  address.getOwners();
 }
 
 Set<Clinic> getAddressClinics(Address address){
	 return  address.getClinics();
 }
 
 
}
