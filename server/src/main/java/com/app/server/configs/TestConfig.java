package com.app.server.configs;

import com.app.server.entities.*;
import com.app.server.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

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

    @Autowired
    private OpenHourRepository openHourRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "test@test.com", "Enzo Ferrari","pwd");
        User u2 = new User(null, "test2@test2.com", "Olavo Bilac", "pwdd");
        userRepository.saveAll(Arrays.asList(u1, u2));

        Organization o1 = new Organization(null, "joca@jocabarber.com", "pwd", "Joca's barber", "barber");
        organizationRepository.save(o1);

        OpenHour oh = new OpenHour(null, LocalTime.now(), LocalTime.now(), o1);
        openHourRepository.save(oh);

        Product p1 = new Product(null, o1, "Disfarce", "corte de cria", 25.0, 20);
        Product p2 = new Product(null, o1, "Barba", "corte de barba", 15.0, 20);
        productRepository.saveAll(Arrays.asList(p1, p2));

        Order or1 = new Order(null, u1);
        Order or2 = new Order(null, u2);
        //Order or3 = new Order(null, u2);
        orderRepository.saveAll(Arrays.asList(or1, or2));

        OrderItem oi1 = new OrderItem(p1, or1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(p1, or2, 1, p1.getPrice());
        OrderItem oi3 = new OrderItem(p2, or2, 1, p2.getPrice());
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));

        Appointment a1 = new Appointment(u1, o1, LocalDateTime.now(), or1);
        Appointment a2 = new Appointment(u2, o1, LocalDateTime.now().plusHours(1), or2);
        //Appointment a3 = new Appointment(u2, o1, Date.valueOf("2023-05-07"), or3);
        appointmentRepository.saveAll(Arrays.asList(a1, a2));
    }
}
