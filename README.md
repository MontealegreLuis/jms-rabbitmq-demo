# JMS + RabbitMQ + Spring Boot Demo

[![codebeat badge][codebeat-badge]][codebeat]

This application will send an email notification every time a user clicks on the `Star` button of a project.
It will publish a message to RabbitMQ and a consumer will send an email to the author of the project.

# Installation

You will need to install [RabbitMQ][rabbitmq]. 
The `example.properties` file already has the settings for [Mailtrap][mailtrap].

Create your application properties with the following command

```
$ cp src/main/resources/example.properties src/main/resources/application.properties
```   

You only need to add your Mailtrap username and password.

# Usage

Run the application with the command below

```
$ mvn spring-boot:run
```

[mailtrap]: https://mailtrap.io/
[rabbitmq]: https://www.rabbitmq.com/download.html
[codebeat-badge]: https://codebeat.co/badges/844f3556-140d-4ce8-844f-8bd34632ec26
[codebeat]: https://codebeat.co/projects/github-com-montealegreluis-jms-rabbitmq-demo-master
