package com.joaomarcos.commerce.config;

import com.joaomarcos.commerce.entities.Order;
import com.joaomarcos.commerce.repositories.OrderRepository;
import com.joaomarcos.commerce.repositories.UserRepository;
import com.joaomarcos.commerce.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User firstUser = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User secondUser = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order firstOrder = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), firstUser);
        Order secondOrder = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), secondUser);
        Order thirdOrder = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), firstUser);

        userRepository.saveAll(Arrays.asList(firstUser, secondUser));
        orderRepository.saveAll(Arrays.asList(firstOrder, secondOrder, thirdOrder));
    }
}
