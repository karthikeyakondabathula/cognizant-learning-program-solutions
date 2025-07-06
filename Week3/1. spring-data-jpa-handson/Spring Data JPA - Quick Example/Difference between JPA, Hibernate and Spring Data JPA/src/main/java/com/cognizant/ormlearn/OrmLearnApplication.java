package com.cognizant.ormlearn;

// Import Spring Boot classes
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// Import for logging
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Import our classes
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

// Import Java collections
import java.util.List;

// @SpringBootApplication tells Spring this is the main application class
@SpringBootApplication
public class OrmLearnApplication {
    
    // Create a logger to print messages
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    
    // Variable to hold our country service
    private static CountryService countryService;
    
    // Main method - this is where our application starts
    public static void main(String[] args) {
        LOGGER.info("Starting our Spring Boot application...");
        
        // Start the Spring Boot application and get the context
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        
        // Get the CountryService from Spring context
        countryService = context.getBean(CountryService.class);
        
        LOGGER.info("Application started successfully!");
        LOGGER.info("Inside main method");
        
        // Test our application
        testGetAllCountries();
        testSaveNewCountry();
    }
    
    // Method to test getting all countries
    private static void testGetAllCountries() {
        LOGGER.info("=== Testing Get All Countries ===");
        
        try {
            // Get all countries from service
            List<Country> countries = countryService.getAllCountries();
            
            LOGGER.info("Countries found: {}", countries);
            
            // Print each country
            for (Country country : countries) {
                LOGGER.info("Country Code: {}, Country Name: {}", 
                           country.getCode(), country.getName());
            }
            
        } catch (Exception e) {
            LOGGER.error("Error getting countries: {}", e.getMessage());
        }
        
        LOGGER.info("=== End Test Get All Countries ===");
    }
    
    // Method to test saving a new country
    private static void testSaveNewCountry() {
        LOGGER.info("=== Testing Save New Country ===");
        
        try {
            // Create a new country
            Country newCountry = new Country("CA", "Canada");
            
            // Save it using our service
            Country savedCountry = countryService.saveCountry(newCountry);
            
            LOGGER.info("New country saved: {}", savedCountry);
            
            // Get all countries again to see the new one
            List<Country> allCountries = countryService.getAllCountries();
            LOGGER.info("Total countries now: {}", allCountries.size());
            
        } catch (Exception e) {
            LOGGER.error("Error saving country: {}", e.getMessage());
        }
        
        LOGGER.info("=== End Test Save New Country ===");
    }
}
