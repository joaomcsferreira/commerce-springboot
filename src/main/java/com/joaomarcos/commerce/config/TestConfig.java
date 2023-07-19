package com.joaomarcos.commerce.config;

import com.joaomarcos.commerce.entities.*;
import com.joaomarcos.commerce.entities.enums.OrderStatus;
import com.joaomarcos.commerce.repositories.*;
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
    private CategoryRespository categoryRespository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        Category firstCategory = new Category(null, "Electronics");
        Category secondCategory = new Category(null, "Books");
        Category thirdCategory = new Category(null, "Computers");

        Product firstProduct = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product secondProduct = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product thirdProduct = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product fourthProduct = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product fifthProduct = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRespository.saveAll(Arrays.asList(firstCategory, secondCategory, thirdCategory));
        productRepository.saveAll(Arrays.asList(firstProduct, secondProduct, thirdProduct, fourthProduct, fifthProduct));

        firstProduct.getCategories().add(firstCategory);
        secondProduct.getCategories().add(firstCategory);
        secondProduct.getCategories().add(thirdCategory);
        thirdProduct.getCategories().add(thirdCategory);
        fourthProduct.getCategories().add(thirdCategory);
        fifthProduct.getCategories().add(secondCategory);

        productRepository.saveAll(Arrays.asList(firstProduct, secondProduct, thirdProduct, fourthProduct, fifthProduct));

        User firstUser = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User secondUser = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order firstOrder = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,firstUser);
        Order secondOrder = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT,secondUser);
        Order thirdOrder = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,firstUser);

        userRepository.saveAll(Arrays.asList(firstUser, secondUser));
        orderRepository.saveAll(Arrays.asList(firstOrder, secondOrder, thirdOrder));

        OrderItem firstOrderItem = new OrderItem(firstOrder, firstProduct, 2, firstProduct.getPrice());
        OrderItem secondOrderItem = new OrderItem(firstOrder, thirdProduct, 1, thirdProduct.getPrice());
        OrderItem thirdOrderItem = new OrderItem(secondOrder, thirdProduct, 2, thirdProduct.getPrice());
        OrderItem fourthOrderItem = new OrderItem(thirdOrder, fifthProduct, 2, fifthProduct.getPrice());

        orderItemRepository.saveAll(Arrays.asList(firstOrderItem, secondOrderItem, thirdOrderItem, fourthOrderItem));
    }
}
