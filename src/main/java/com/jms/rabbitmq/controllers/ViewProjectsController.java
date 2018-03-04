package com.jms.rabbitmq.controllers;

import com.jms.rabbitmq.projects.Projects;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewProjectsController {

    private Projects projects;

    public ViewProjectsController(Projects projects) {
        this.projects = projects;
    }

    @GetMapping("/")
    public String viewProjects(Model model) {
        model.addAttribute("projects", projects.findAll());
        return "projects/all";
    }
}
