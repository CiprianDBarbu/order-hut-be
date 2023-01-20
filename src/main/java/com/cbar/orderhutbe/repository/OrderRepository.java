package com.cbar.orderhutbe.repository;

import com.cbar.orderhutbe.model.FinalOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<FinalOrder, Integer> {
}
