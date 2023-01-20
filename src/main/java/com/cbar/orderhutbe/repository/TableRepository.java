package com.cbar.orderhutbe.repository;

import com.cbar.orderhutbe.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<RestaurantTable, Integer> {
}
