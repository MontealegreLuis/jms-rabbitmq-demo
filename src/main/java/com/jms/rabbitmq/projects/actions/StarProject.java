package com.jms.rabbitmq.projects.actions;

import com.jms.rabbitmq.projects.Project;
import com.jms.rabbitmq.projects.Projects;
import com.jms.rabbitmq.projects.UnknownProject;
import com.jms.rabbitmq.security.SecurityService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StarProject {
    private Projects projects;
    private SecurityService security;

    public StarProject(Projects projects, SecurityService security) {
        this.projects = projects;
        this.security = security;
    }

    public void addStarToProjectWith(Long id) {
        Optional<Project> optionalProject = projects.findById(id);

        if (!optionalProject.isPresent()) throw UnknownProject.with(id);

        Project project = optionalProject.get();

        project.addStarBy(security.loggedInUser());
        projects.save(project);
    }
}
