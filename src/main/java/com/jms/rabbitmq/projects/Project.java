package com.jms.rabbitmq.projects;

import com.jms.rabbitmq.events.Event;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
@Entity @Table(name = "projects")
public class Project {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private String url;

    @ManyToOne
    private User author;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name="projects_stars",
        joinColumns={@JoinColumn(name="project_id")},
        inverseJoinColumns={@JoinColumn(name="user_id")}
    )
    private List<User> stars;

    @Transient
    private List<Event> events = new ArrayList<>();

    public void addStarBy(User user) {
        stars.add(user);
        recordThat(new ProjectWasStarred(name, user.getUsername(), user.getEmail(), new Date()));
    }

    private void recordThat(Event projectWasStarred) {
        events.add(projectWasStarred);
    }

    private Iterable<Event> events() {
        return events;
    }
}
