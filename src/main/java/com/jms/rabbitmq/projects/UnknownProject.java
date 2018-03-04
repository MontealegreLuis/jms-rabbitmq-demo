package com.jms.rabbitmq.projects;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UnknownProject extends RuntimeException {
    private UnknownProject(String format) {
        super(format);
    }

    public static UnknownProject with(Long id) {
        return new UnknownProject(String.format("Cannot find project with ID %d", id));
    }
}
