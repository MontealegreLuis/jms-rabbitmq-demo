package com.jms.rabbitmq.projects;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@Entity @Table(name = "users")
public class User {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "user")
    List<Project> projects;

    @ManyToMany(mappedBy = "stars")
    List<Project> starred;

    public User(User user) {
        id = user.id;
        username = user.username;
        password = user.password;
        email = user.email;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
