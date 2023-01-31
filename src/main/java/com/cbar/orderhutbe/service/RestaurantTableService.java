package com.cbar.orderhutbe.service;

import com.cbar.orderhutbe.exceptions.NoElementFoundException;
import com.cbar.orderhutbe.model.RestaurantTable;
import com.cbar.orderhutbe.repository.RestaurantTableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantTableService {
    private final RestaurantTableRepository restaurantTableRepository;

    public RestaurantTableService(RestaurantTableRepository restaurantTableRepository) {
        this.restaurantTableRepository = restaurantTableRepository;
    }

    public RestaurantTable saveNewTable(RestaurantTable table) {
        return  restaurantTableRepository.save(table);
    }

    public List<RestaurantTable> retrieveTables() {
        return restaurantTableRepository.findAll();
    }

    public RestaurantTable retrieveTableById(int tableId) {
        return restaurantTableRepository.findById(tableId)
                .orElseThrow(() -> new NoElementFoundException("Id not available!"));
    }

    public String deleteTableById(int tableId) {
        restaurantTableRepository.deleteById(tableId);
        return "OK";
    }

    public RestaurantTable editTable(int tableId, RestaurantTable table) {
        RestaurantTable actualTable = restaurantTableRepository.findById(tableId)
                .orElseThrow(() -> new NoElementFoundException("Id not available!"));

        actualTable.setNumberOfSeats(table.getNumberOfSeats());
        actualTable.setServingZone(table.getServingZone());

        return restaurantTableRepository.save(actualTable);
    }
}
