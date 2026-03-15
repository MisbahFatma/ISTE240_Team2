/** Assignment 2: Team Members
 * Misbah Fatma Begum : 418008089
 * Yara Alhammouri - 768008964
 * Ali jouni - 769009393
 */
package org.example.mind_ease.model;

public class StressSurvey {
    private Long id;
    private Student student; // Link to student
    private int stressLevel; // 1-5 emoji scale
    private String date;

    public StressSurvey() {}

    public StressSurvey(Long id, Student student, int stressLevel, String date) {
        this.id = id;
        this.student = student;
        this.stressLevel = stressLevel;
        this.date = date;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public int getStressLevel() { return stressLevel; }
    public void setStressLevel(int stressLevel) { this.stressLevel = stressLevel; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}