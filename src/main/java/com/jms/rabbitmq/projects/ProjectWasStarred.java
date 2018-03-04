package com.jms.rabbitmq.projects;

import com.jms.rabbitmq.events.Event;
import lombok.Getter;

import java.util.Date;

@Getter
public class ProjectWasStarred implements Event {
    private String project;
    private String starredByUsername;
    private String authorEmail;
    private Date occurredOn;

    public ProjectWasStarred(String project, String starredByUsername, String authorEmail, Date occurredOn) {
        this.project = project;
        this.starredByUsername = starredByUsername;
        this.authorEmail = authorEmail;
        this.occurredOn = occurredOn;
    }

    @Override
    public Date occurredOn() {
        return occurredOn;
    }
}
