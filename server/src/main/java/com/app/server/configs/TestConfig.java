package com.app.server.configs;

import com.app.server.entities.*;
import com.app.server.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.Date;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "test", "test@test.com", "pwd");
        userRepository.save(u1);

        Organization o1 = new Organization(null, "Joca's barber", "barber");
        organizationRepository.save(o1);

        Product p1 = new Product(null, o1, "Disfarce", "corte de cria", 25.0);
        productRepository.save(p1);

        Order or1 = new Order(null, u1);
        orderRepository.save(or1);

        OrderItem oi1 = new OrderItem(p1, or1, 2, p1.getPrice());
        orderItemRepository.save(oi1);

        Appointment a1 = new Appointment(u1, o1, Date.valueOf("2023-05-07"), or1);
        appointmentRepository.save(a1);
    }
}
