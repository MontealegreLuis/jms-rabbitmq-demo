package com.jms.rabbitmq.controllers;

import com.jms.rabbitmq.projects.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class StarProjectController {

    private Projects projects;

    public StarProjectController(Projects projects) {
        this.projects = projects;
    }

    @PostMapping("/star/{id}")
    public String starProject(@PathVariable Long id) {
        Optional<Project> optionalProject = projects.findById(id);

        if (!optionalProject.isPresent()) throw UnknownProject.with(id);

        Project project = optionalProject.get();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        project.addStarBy(user);
        projects.save(project);

        return "redirect:/";
    }
}
