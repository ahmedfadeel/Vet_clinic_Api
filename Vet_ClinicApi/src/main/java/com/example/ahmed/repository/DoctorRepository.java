package com.example.ahmed.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ahmed.model.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
	Optional<Doctor> findBydoctorId(long id); 
}
