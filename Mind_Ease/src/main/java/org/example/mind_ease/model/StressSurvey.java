/** Assignment 2: Team Members
 * Misbah Fatma Begum : 418008089
 * Ali jouni - 769009393
 */
package org.example.mind_ease.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "stress_surveys")
public class StressSurvey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stressLevel;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public StressSurvey() {}

    public StressSurvey(int stressLevel, LocalDate date, Student student) {
        this.stressLevel = stressLevel;
        this.date = date;
        this.student = student;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getStressLevel() { return stressLevel; }
    public void setStressLevel(int stressLevel) { this.stressLevel = stressLevel; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}