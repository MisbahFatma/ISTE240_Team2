/** Assignment 2: Team Members
 * Misbah Fatma Begum : 418008089
 * Yara Alhammouri - 768008964
 * Ali jouni - 769009393
 */
package org.example.mind_ease.model;

import java.time.LocalDateTime;

public class Booking {
    private Long id;
    private Student student;
    private Counsellor counsellor;
    private LocalDateTime dateTime;
    private String status; // Scheduled, Cancelled, Completed

    public Booking() {}

    // Full constructor
    public Booking(Long id, Student student, Counsellor counsellor, LocalDateTime dateTime, String status) {
        this.id = id;
        this.student = student;
        this.counsellor = counsellor;
        this.dateTime = dateTime;
        this.status = status;
    }

    // Convenience constructor for form submission
    public Booking(Student student, Counsellor counsellor, String dateTimeStr) {
        this.id = System.currentTimeMillis(); // simple unique ID
        this.student = student;
        this.counsellor = counsellor;
        this.dateTime = LocalDateTime.parse(dateTimeStr); // expects ISO-8601: "2026-03-15T14:30"
        this.status = "Scheduled";
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Counsellor getCounsellor() { return counsellor; }
    public void setCounsellor(Counsellor counsellor) { this.counsellor = counsellor; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}