package com.jms.rabbitmq.messaging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Consumer {
    private static final Log log = LogFactory.getLog(Consumer.class);

    public void receive(String message) {
        log.info("Received the following message " + message);
    }
}
