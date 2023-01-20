package com.cbar.orderhutbe.repository;

import com.cbar.orderhutbe.model.Planification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanificationRepository extends JpaRepository<Planification, Integer> {
}
