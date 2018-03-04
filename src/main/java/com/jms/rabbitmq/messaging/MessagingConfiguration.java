package com.jms.rabbitmq.messaging;

import com.rabbitmq.jms.admin.RMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.ConnectionFactory;

@Configuration
public class MessagingConfiguration {
    @Value("${projects.messaging.topic}")
    private String topic;

    @Bean
    public ConnectionFactory connectionFactory() {
        return new RMQConnectionFactory();
    }

    @Bean
    public DefaultMessageListenerContainer jmsListener(ConnectionFactory connectionFactory) {

        DefaultMessageListenerContainer jmsListener = new DefaultMessageListenerContainer();
        jmsListener.setConnectionFactory(connectionFactory);
        jmsListener.setDestinationName(topic);
        jmsListener.setPubSubDomain(false);

        MessageListenerAdapter adapter = new MessageListenerAdapter(new Consumer());
        adapter.setDefaultListenerMethod("receive");

        jmsListener.setMessageListener(adapter);
        return jmsListener;
    }
}
