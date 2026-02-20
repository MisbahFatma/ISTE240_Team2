package org.example.mind_ease.model;

import org.springframework.stereotype.Component;

@Component
public class Resource {

    private int id;
    private String title;
    private String type;
    private String description;
    private String link;
    private String stressLevel;


    public Resource() {
    }

    public Resource(int id, String title, String type, String description, String link, String stressLevel) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.description = description;
        this.link = link;
        this.stressLevel = stressLevel;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStressLevel() {
        return stressLevel;
    }

    public void setStressLevel(String stressLevel) {
        this.stressLevel = stressLevel;
    }
}