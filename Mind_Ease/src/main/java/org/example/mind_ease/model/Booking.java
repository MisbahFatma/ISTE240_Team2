package org.example.mind_ease.model;

import java.time.LocalDateTime;

public class Booking {
    private Long id;
    private Student student;
    private Counsellor counsellor;
    private LocalDateTime dateTime;
    private String status; // Scheduled, Cancelled, Completed

    public Booking() {}

    public Booking(Long id, Student student, Counsellor counsellor, LocalDateTime dateTime, String status) {
        this.id = id;
        this.student = student;
        this.counsellor = counsellor;
        this.dateTime = dateTime;
        this.status = status;
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