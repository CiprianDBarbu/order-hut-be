package com.cbar.orderhutbe.service;

import com.cbar.orderhutbe.model.Dish;
import com.cbar.orderhutbe.repository.DishRepository;
import org.springframework.stereotype.Service;

@Service
public class DishService {
    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

}
