package com.cbar.orderhutbe;

import com.cbar.orderhutbe.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderHutBeApplication {

    private final ClientRepository clientRepository;
    private final DishRepository dishRepository;
    private final FinalOrderRepository finalOrderRepository;
    private final PlanificationRepository planificationRepository;
    private final RestaurantTableRepository restaurantTableRepository;
    private final WaiterRepository waiterRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrderHutBeApplication.class, args);
    }

    public OrderHutBeApplication(ClientRepository clientRepository, DishRepository dishRepository, FinalOrderRepository finalOrderRepository, PlanificationRepository planificationRepository, RestaurantTableRepository restaurantTableRepository, WaiterRepository waiterRepository) {
        this.clientRepository = clientRepository;
        this.dishRepository = dishRepository;
        this.finalOrderRepository = finalOrderRepository;
        this.planificationRepository = planificationRepository;
        this.restaurantTableRepository = restaurantTableRepository;
        this.waiterRepository = waiterRepository;
    }
}
