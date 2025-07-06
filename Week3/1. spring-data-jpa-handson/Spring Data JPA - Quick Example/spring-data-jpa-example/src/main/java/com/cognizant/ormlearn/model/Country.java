package com.cognizant.ormlearn.model;

// These imports are for JPA annotations
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// @Entity tells Spring this class represents a database table
@Entity
// @Table tells Spring which table this class maps to
@Table(name = "country")
public class Country {
    
    // @Id tells Spring this field is the primary key
    @Id
    // @Column tells Spring which database column this field maps to
    @Column(name = "co_code")
    private String code;
    
    // This field maps to the co_name column
    @Column(name = "co_name")
    private String name;
    
    // Default constructor (required by JPA)
    public Country() {
        // Empty constructor
    }
    
    // Constructor to create a country with code and name
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }
    
    // Getter method for code
    public String getCode() {
        return code;
    }
    
    // Setter method for code
    public void setCode(String code) {
        this.code = code;
    }
    
    // Getter method for name
    public String getName() {
        return name;
    }
    
    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }
    
    // toString method to display country information nicely
    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
