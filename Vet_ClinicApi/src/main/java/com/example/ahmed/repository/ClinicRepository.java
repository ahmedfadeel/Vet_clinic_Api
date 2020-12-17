package com.example.ahmed.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ahmed.model.Clinic;
import com.example.ahmed.model.ClinicDTO;
import com.example.ahmed.model.Doctor;


@Repository
public interface ClinicRepository extends JpaRepository<Clinic,Long> {

	// find all clinics for that address 
	Optional<Clinic> findByclinicId(long id);
    Clinic findByphone  (String phone ) ;
	
    
	
  @Query("SELECT new com.example.ahmed.model.ClinicDTO (c.name, c.Email,c.phone,c.WorkingDaysAndHours) FROM Clinic  c WHERE c.name = :firstName")
   List<ClinicDTO> findByFirstName(String firstName);
  
  @Query("select c from Clinic  c left join fetch c.doctors ")
   Set<Clinic> getClinicDoctors();
  /*
   * for getting an entity with collections which is lazy fetched by default ;
   * @Query("select a from Author a left join fetch a.books")
       List<Author> getAuthorsAndBook();
        
        list of dtos as long as attributed name
      List<AuthorSummaryDTO> findByFirstName(String firstName);   
        
        
        Dynamic Projections
        @Repository
        public interface AuthorRepository extends CrudRepository<Author, Long> {
        <T> T findByLastName(String lastName, Class<T> type);
        
            // 
           public interface BookSummary {
 
    @Value("#{target.title + '-' + target.author.firstName}")
    String getBookNameAndAuthorName();
}


}
   * 
   * */
	}
	
	

