/** Assignment 2: Team Members
 * Misbah Fatma Begum : 418008089
 * Yara Alhammouri - 768008964
 * Ali jouni - 769009393
 */
package org.example.mind_ease.model;

import java.util.ArrayList;
import java.util.List;

public class Counsellor {
    private Long id;
    private String name;
    private String specialization;
    private String email;
    private String availability;
    private List<Booking> bookings = new ArrayList<>();

    public Counsellor() {}

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

    public List<Booking> getBookings() { return bookings; }
    public void setBookings(List<Booking> bookings) { this.bookings = bookings; }
}