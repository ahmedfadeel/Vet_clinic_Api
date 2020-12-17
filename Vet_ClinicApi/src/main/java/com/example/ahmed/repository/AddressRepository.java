package com.example.ahmed.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ahmed.model.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
	Optional<Address> findByaddressId(long id); 
	
}
