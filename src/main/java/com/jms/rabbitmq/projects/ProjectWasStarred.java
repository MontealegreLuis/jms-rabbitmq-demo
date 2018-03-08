package com.jms.rabbitmq.projects;

import com.jms.rabbitmq.events.Event;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter @NoArgsConstructor
public class ProjectWasStarred implements Event {
    private String project;
    private String stargazer;
    private String authorEmail;
    private Date occurredOn;

    public ProjectWasStarred(String project, String stargazer, String authorEmail, Date occurredOn) {
        this.project = project;
        this.stargazer = stargazer;
        this.authorEmail = authorEmail;
        this.occurredOn = occurredOn;
    }

    @Override
    public Date occurredOn() {
        return occurredOn;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public String getProject() {
        return project;
    }

    public String getStargazer() {
        return stargazer;
    }
}
