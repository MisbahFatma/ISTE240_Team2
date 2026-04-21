/** Assignment 2: Team Members
 * Misbah Fatma Begum : 418008089
 * Yara Alhammouri - 768008964
 * Ali jouni - 769009393
 */
package org.example.mind_ease.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // One student → many stress surveys
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StressSurvey> surveys = new ArrayList<>();

    // Default constructor (required by JPA)
    public Student() {}

    // Constructor without id (for creating new students)
    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Optional constructor (rarely needed)
    public Student(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<StressSurvey> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<StressSurvey> surveys) {
        this.surveys = surveys;
    }
}