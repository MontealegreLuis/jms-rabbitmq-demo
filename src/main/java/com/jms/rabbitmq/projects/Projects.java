package com.jms.rabbitmq.projects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Projects extends JpaRepository<Project, Long> {
}
