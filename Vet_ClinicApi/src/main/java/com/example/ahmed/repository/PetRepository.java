package com.example.ahmed.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ahmed.model.Pet;


@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {

	Optional<Pet> findBypetId(long id);
}
