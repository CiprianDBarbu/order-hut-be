package com.cbar.orderhutbe.repository;

import com.cbar.orderhutbe.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Integer> {
}
