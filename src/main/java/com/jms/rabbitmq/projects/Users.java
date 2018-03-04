package com.jms.rabbitmq.projects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
