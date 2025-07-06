package com.cognizant.ormlearn.repository;

// Import Spring Data JPA classes
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Import our Country model
import com.cognizant.ormlearn.model.Country;

// @Repository tells Spring this is a repository class
@Repository
// JpaRepository<Country, String> means:
// - We work with Country entities
// - The primary key type is String
public interface CountryRepository extends JpaRepository<Country, String> {
    
    // We don't need to write any methods here!
    // JpaRepository gives us these methods automatically:
    // - findAll() - get all countries
    // - findById() - find country by code
    // - save() - save a country
    // - delete() - delete a country
    // - and many more!
}
