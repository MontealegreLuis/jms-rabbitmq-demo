package com.jms.rabbitmq.projects;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Projects extends CrudRepository<Project, Long> {
}
