/** Assignment 1: Team Members
 * Misbah Fatma Begum : 418008089
 * Yara Alhammouri - 768008964
 * Ali jouni - 769009393
 */
package org.example.mind_ease.model;

import org.springframework.stereotype.Component;

@Component
public class StressSurvey {
    private Long id;
    private Long studentId;
    private int stressLevel;   // 1-10 scale
    private String date;

    public StressSurvey() {
    }

    public StressSurvey(Long id, Long studentId, int stressLevel, String date) {
        this.id = id;
        this.studentId = studentId;
        this.stressLevel = stressLevel;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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
}
