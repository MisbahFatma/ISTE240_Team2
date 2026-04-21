/** Assignment 2: Team Members
 * Misbah Fatma Begum : 418008089
 * Yara Alhammouri - 768008964
 * Ali jouni - 769009393
 */
package org.example.mind_ease.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stress_surveys")
public class StressSurvey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stressLevel;

    private String date;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Default constructor (required by JPA)
    public StressSurvey() {}

    // Constructor for creating new surveys
    public StressSurvey(int stressLevel, String date, Student student) {
        this.stressLevel = stressLevel;
        this.date = date;
        this.student = student;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStressLevel() {
        return stressLevel;
    }

    public void setStressLevel(int stressLevel) {
        this.stressLevel = stressLevel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}