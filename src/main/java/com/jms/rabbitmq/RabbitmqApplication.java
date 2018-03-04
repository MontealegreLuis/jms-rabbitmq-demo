package com.jms.rabbitmq;

import com.jms.rabbitmq.messaging.Consumer;
import com.rabbitmq.jms.admin.RMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.ConnectionFactory;

@SpringBootApplication
public class RabbitmqApplication {
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);
	}

	@Bean
	ConnectionFactory connectionFactory() {
		return new RMQConnectionFactory();
	}

	@Bean
	public DefaultMessageListenerContainer jmsListener(ConnectionFactory connectionFactory) {

		DefaultMessageListenerContainer jmsListener = new DefaultMessageListenerContainer();
		jmsListener.setConnectionFactory(connectionFactory);
		jmsListener.setDestinationName("project-stars-channel");
		jmsListener.setPubSubDomain(false);

		MessageListenerAdapter adapter = new MessageListenerAdapter(new Consumer());
		adapter.setDefaultListenerMethod("receive");

		jmsListener.setMessageListener(adapter);
		return jmsListener;
	}
}
