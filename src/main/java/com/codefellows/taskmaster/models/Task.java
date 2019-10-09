package com.codefellows.taskmaster.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String title;
    String body;
    String assignedUser;
    String state;

    public Task (){}
    public Task(String title, String body, String assignedUser, String state) {
        this.title = title;
        this.body = body;
        this.assignedUser = assignedUser;
        this.state = state;
    }

    public void updateWithTask(Task otherTask) {
        if(otherTask.assignedUser != null) {
            this.assignedUser = otherTask.assignedUser;
        }
        if(otherTask.title != null) {
            this.title = otherTask.title;
        }
        if(otherTask.body != null) {
            this.body = otherTask.body;
        }
        if(otherTask.state != null) {
            this.state = otherTask.state;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getId() {
        return this.id;
    }
}
