package com.softarex.app.logotype.security;

import com.softarex.app.logotype.entity.User;
import com.softarex.app.logotype.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

//@Service
public class DBInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DBInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        this.userRepository.deleteAll();

        User user1 = new User("John", "Doe", "john@doe.com",
                passwordEncoder.encode("qwerty"), "USER", "1234567890", true);
        User user2 = new User("Test", "Test", "test@test.com",
                passwordEncoder.encode("123456"), "ADMIN", "0987654321", true);

        List<User> users = Arrays.asList(user1, user2);

        this.userRepository.saveAll(users);
    }
}
