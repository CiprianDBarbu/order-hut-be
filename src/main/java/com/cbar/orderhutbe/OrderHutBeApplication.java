package com.cbar.orderhutbe;

import com.cbar.orderhutbe.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderHutBeApplication {

    private final ClientRepository clientRepository;
    private final DishRepository dishRepository;
    private final OrderRepository orderRepository;
    private final PlanificationRepository planificationRepository;
    private final TableRepository tableRepository;
    private final WaiterRepository waiterRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrderHutBeApplication.class, args);
    }

    public OrderHutBeApplication(ClientRepository clientRepository, DishRepository dishRepository, OrderRepository orderRepository, PlanificationRepository planificationRepository, TableRepository tableRepository, WaiterRepository waiterRepository) {
        this.clientRepository = clientRepository;
        this.dishRepository = dishRepository;
        this.orderRepository = orderRepository;
        this.planificationRepository = planificationRepository;
        this.tableRepository = tableRepository;
        this.waiterRepository = waiterRepository;
    }
}
