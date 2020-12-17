package com.example.ahmed.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ahmed.model.Owner;


@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {
   
	Optional<Owner> findByownerId(long id);
	
}
