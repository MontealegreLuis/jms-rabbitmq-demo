package com.jms.rabbitmq.controllers;

import com.jms.rabbitmq.projects.User;
import com.jms.rabbitmq.projects.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
    private PasswordEncoder encoder;
    private Users users;

    public SignUpController(PasswordEncoder encoder, Users users) {
        this.encoder = encoder;
        this.users = users;
    }

    @GetMapping("/sign-up")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String singUpNewUser(@ModelAttribute User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        users.save(user);
        return "redirect:/";
    }
}
