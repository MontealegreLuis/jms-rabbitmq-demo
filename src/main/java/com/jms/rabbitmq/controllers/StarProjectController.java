package com.jms.rabbitmq.controllers;

import com.jms.rabbitmq.projects.Project;
import com.jms.rabbitmq.projects.Projects;
import com.jms.rabbitmq.projects.UnknownProject;
import com.jms.rabbitmq.security.SecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class StarProjectController {

    private Projects projects;
    private SecurityService security;

    public StarProjectController(Projects projects, SecurityService security) {
        this.projects = projects;
        this.security = security;
    }

    @PostMapping("/star/{id}")
    public String starProject(@PathVariable Long id) {
        Optional<Project> optionalProject = projects.findById(id);

        if (!optionalProject.isPresent()) throw UnknownProject.with(id);

        Project project = optionalProject.get();

        project.addStarBy(security.loggedInUser());
        projects.save(project);

        return "redirect:/";
    }
}
