package com.example.ahmed.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ahmed.model.Visit;


@Repository
public interface VisitRepository extends JpaRepository<Visit,Long> {

	Optional<Visit> findByvisitId(long id);
	
}
