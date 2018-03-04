package com.jms.rabbitmq.projects;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name="projects_stars",
        joinColumns={@JoinColumn(name="project_id")},
        inverseJoinColumns={@JoinColumn(name="user_id")}
    )
    private List<User> stars;

    public void addStarBy(User user) {
        stars.add(user);
    }
}
