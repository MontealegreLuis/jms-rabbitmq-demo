package com.jms.rabbitmq.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jms.rabbitmq.projects.ProjectWasStarred;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class NewStarEmailNotification {
    private static final Log log = LogFactory.getLog(NewStarEmailNotification.class);

    private JavaMailSender sender;

    public NewStarEmailNotification(JavaMailSender sender) {
        this.sender = sender;
    }

    public void receive(String event) throws IOException {
        sendEmail(parse(event));

        log.info("Received the following message " + event);
    }

    private ProjectWasStarred parse(String event) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(event, ProjectWasStarred.class);
    }

    private void sendEmail(ProjectWasStarred event) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(event.getAuthorEmail());
        message.setSubject(String.format("Your project %s has a new star", event.getProject()));
        message.setText(event.getStargazer() + " added a new star to your project " + event.getProject());
        sender.send(message);
    }
}
