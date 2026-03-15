/** Assignment 2: Team Members
 * Misbah Fatma Begum : 418008089
 * Yara Alhammouri - 768008964
 * Ali jouni - 769009393
 */
package org.example.mind_ease.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private Long id;
    private String name;
    private String email;
    private List<StressSurvey> surveys = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public Student() {}

    public Student(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<StressSurvey> getSurveys() { return surveys; }
    public void setSurveys(List<StressSurvey> surveys) { this.surveys = surveys; }

    public List<Booking> getBookings() { return bookings; }
    public void setBookings(List<Booking> bookings) { this.bookings = bookings; }
}
