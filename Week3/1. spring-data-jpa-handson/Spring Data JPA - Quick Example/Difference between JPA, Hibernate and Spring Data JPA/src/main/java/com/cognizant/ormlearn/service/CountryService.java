package com.cognizant.ormlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
    
    @Autowired
    private CountryRepository countryRepository;
    
    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        LOGGER.info("Getting all countries from database");
        
        List<Country> countries = countryRepository.findAll();
        
        LOGGER.info("Found {} countries", countries.size());
        return countries;
    }
    
    @Transactional(readOnly = true)
    public Optional<Country> getCountryByCode(String code) {
        LOGGER.info("Fetching country with code: {}", code);
        return countryRepository.findById(code);
    }
    
    @Transactional
    public Country saveCountry(Country country) {
        LOGGER.info("Saving country: {}", country);
        
        Country savedCountry = countryRepository.save(country);
        
        LOGGER.info("Country saved successfully");
        return savedCountry;
    }
    
    @Transactional
    public void deleteCountry(String code) {
        LOGGER.info("Deleting country with code: {}", code);
        countryRepository.deleteById(code);
    }
}
