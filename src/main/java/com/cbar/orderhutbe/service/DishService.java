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

    public String deleteDishById(int dishId) {
        dishRepository.deleteById(dishId);
        return "OK";
    }

    public Dish editDish(int dishId, Dish dish) {
        Dish acutalDish = dishRepository.findById(dishId)
                .orElseThrow(() -> new NoElementFoundException("Id not available!"));

        acutalDish.setDishName(dish.getDishName());
        acutalDish.setPrice(dish.getPrice());
        acutalDish.setCategory(dish.getCategory());
        acutalDish.setImageUrl(dish.getImageUrl());
        acutalDish.setDishDescription(dish.getDishDescription());
        acutalDish.setOrderList(dish.getOrderList());

        return dishRepository.save(acutalDish);
    }
}
