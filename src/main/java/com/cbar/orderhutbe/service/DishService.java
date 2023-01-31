package com.cbar.orderhutbe.service;

import com.cbar.orderhutbe.exceptions.NoElementFoundException;
import com.cbar.orderhutbe.model.Dish;
import com.cbar.orderhutbe.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Dish saveNewDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public List<Dish> retrieveDishes() {
        return dishRepository.findAll();
    }

    public Dish retrieveDishById(int dishId) {
        return dishRepository.findById(dishId)
                .orElseThrow(() -> new NoElementFoundException("Id not available!"));
    }

    public String deleteDishById(int dishId) {
        dishRepository.deleteById(dishId);
        return "OK";
    }

    public Dish editDish(int dishId, Dish dish) {
        Dish actualDish = dishRepository.findById(dishId)
                .orElseThrow(() -> new NoElementFoundException("Id not available!"));

        actualDish.setDishName(dish.getDishName());
        actualDish.setPrice(dish.getPrice());
        actualDish.setCategory(dish.getCategory());
        actualDish.setImageUrl(dish.getImageUrl());
        actualDish.setDishDescription(dish.getDishDescription());
        actualDish.setOrderList(dish.getOrderList());

        return dishRepository.save(actualDish);
    }
}
