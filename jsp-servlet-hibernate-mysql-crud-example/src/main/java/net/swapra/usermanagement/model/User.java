package net.swapra.usermanagement.model;

import javax.persistence.*;

/**
 * Entity class representing a User in the system.
 * Maps to the "users" table in the database.
 */
@Entity // Marks this class as a JPA entity
@Table(name="users") // Specifies the table name in the database
public class User {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy=GenerationType.IDENTITY) // Auto-increment strategy for the primary key
    @Column(name="id") // Maps to the "id" column in the database
    protected int id;
    
    @Column(name="name") // Maps to the "name" column in the database
    protected String name;

    @Column(name="email") // Maps to the "email" column in the database
    protected String email;
    
    @Column(name="country") // Maps to the "country" column in the database
    protected String country;

    /**
     * Constructor for creating a new user without an ID.
     * Useful for creating new users before they're saved to the database.
     * 
     * @param name User's name
     * @param email User's email address
     * @param country User's country
     */
    public User(String name, String email, String country) {
        super();
        this.name = name;
        this.email = email;
        this.country = country;
    }

    /**
     * Constructor for creating a user with an existing ID.
     * Useful when reconstructing users from database queries.
     * 
     * @param id User's ID from database
     * @param name User's name
     * @param email User's email address
     * @param country User's country
     */
    public User(int id, String name, String email, String country) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
    }
    
    /**
     * Default no-arg constructor.
     * Required by JPA for entity classes.
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Gets the user's ID.
     * @return the user's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the user's ID.
     * @param id the ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the user's name.
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's name.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the user's email.
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email.
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's country.
     * @return the user's country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the user's country.
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
}