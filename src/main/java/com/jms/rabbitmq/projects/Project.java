package com.jms.rabbitmq.projects;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
}
