/** Assignment 1: Team Members
 * Misbah Fatma Begum : 418008089
 * Yara Alhammouri - 768008964
 * Ali jouni - 769009393
 */
package org.example.mind_ease.model;

import org.springframework.stereotype.Component;

@Component
public class Counsellor {

    private Long id;
    private String name;
    private String specialization;
    private String email;
    private String availability; // e.g., "Mon-Fri 10am-4pm"

    // Default constructor
    public Counsellor() {}

    // Constructor with parameters (optional)
    public Counsellor(Long id, String name, String specialization, String email, String availability) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.email = email;
        this.availability = availability;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }
}

