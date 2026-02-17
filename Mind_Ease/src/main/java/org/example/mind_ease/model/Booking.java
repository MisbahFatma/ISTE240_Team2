package org.example.mind_ease.model;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class Booking {

    private Long id;
    private Long studentId;      // Which student booked
    private Long counsellorId;   // Which counsellor
    private LocalDateTime dateTime;  // Session date & time
    private String status;       // Scheduled, Cancelled, Completed

    // Default constructor
    public Booking() {}

    // Constructor with parameters (optional)
    public Booking(Long id, Long studentId, Long counsellorId, LocalDateTime dateTime, String status) {
        this.id = id;
        this.studentId = studentId;
        this.counsellorId = counsellorId;
        this.dateTime = dateTime;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public Long getCounsellorId() { return counsellorId; }
    public void setCounsellorId(Long counsellorId) { this.counsellorId = counsellorId; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
