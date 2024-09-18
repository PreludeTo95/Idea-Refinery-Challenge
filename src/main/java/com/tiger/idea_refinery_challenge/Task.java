package com.tiger.idea_refinery_challenge;

import java.time.LocalDateTime;

public class Task {

    public String id;
    public String title;
    public String description;
    public boolean isCompleted;
    public LocalDateTime createdDate;
    public LocalDateTime completedDate;

    public Task() {

    }

    public Task(String id, String title, String description, boolean isCompleted, LocalDateTime createdDate, LocalDateTime completedDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
        this.createdDate = createdDate;
        this.completedDate = completedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDateTime completedDate) {
        this.completedDate = completedDate;
    }

}
