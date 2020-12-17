package com.example.ahmed.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ahmed.exception.ResourceNotFoundException;
import com.example.ahmed.model.Address;
import com.example.ahmed.service.AddressService;

@RestController
@RequestMapping("apiv1/addresses")
public class AddressController {
  
	 @Autowired
	 AddressService addressService;
	 
	 Logger logger = LoggerFactory.getLogger(AddressController.class);
	 
	 @PostMapping("/save")
	 public Address save (@Valid @RequestBody Address address) {
		 return addressService.addAddress(address);
	 }
	 
	 
	 
	 @GetMapping("")
	 public ResponseEntity<?>getAllAddresses() {
          
		  
		 List<Address>  addressList=addressService.findAll();
		
		 if (addressList.isEmpty() ) {
	      throw new  ResourceNotFoundException("no dtos found ");
		 }
		 return  ResponseEntity.ok(addressList);
	 }
	
}
