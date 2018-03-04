package com.jms.rabbitmq.security;

import com.jms.rabbitmq.projects.User;
import com.jms.rabbitmq.projects.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private Users users;

    public UserDetailsLoader(Users users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException(String.format("Cannot find user %s", username));

        return new UserWithRoles(user);
    }
}
