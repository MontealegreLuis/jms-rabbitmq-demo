package com.jms.rabbitmq.controllers;

import com.jms.rabbitmq.projects.actions.StarProject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StarProjectController {
    private StarProject action;

    public StarProjectController(StarProject action) {
        this.action = action;
    }

    @PostMapping("/star/{id}")
    public String starProject(@PathVariable Long id) {
        action.addStarToProjectWith(id);
        return "redirect:/";
    }
}
