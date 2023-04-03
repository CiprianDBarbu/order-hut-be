package com.cbar.orderhutbe.controller;

import com.cbar.orderhutbe.model.Dish;
import com.cbar.orderhutbe.service.DishService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/dish")
@CrossOrigin(origins = "http://localhost:4200")
public class DishController {
    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Dish>> retrieveDishes() {
        return ResponseEntity.ok()
                .body(dishService.retrieveDishes());
    }

    @GetMapping("/{dishId}")
    public ResponseEntity<Dish> retrieveDishById(@PathVariable int dishId) {
        return ResponseEntity.ok()
                .body(dishService.retrieveDishById(dishId));
    }

    @PostMapping("/new")
    public ResponseEntity<Dish> saveNewDish(@RequestBody Dish dish) {
        return ResponseEntity.created(URI.create("/dish" + dish.getDishId()))
                .body(dishService.saveNewDish(dish));
    }

    @PutMapping("/{dishId}")
    public ResponseEntity<Dish> editDish(@PathVariable int dishId,
                                         @RequestBody Dish dish) {
        return ResponseEntity.created(URI.create("/dish" + dishId))
                .body(dishService.editDish(dishId, dish));
    }

    @DeleteMapping("/{dishId}")
    public ResponseEntity<String> deleteDishById(@PathVariable int dishId) {
        return ResponseEntity.ok()
                .body(dishService.deleteDishById(dishId));
    }
}
