package com.cbar.orderhutbe.service;

import com.cbar.orderhutbe.model.Planification;
import com.cbar.orderhutbe.repository.PlanificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanificationService {
    private final PlanificationRepository planificationRepository;

    public PlanificationService(PlanificationRepository planificationRepository) {
        this.planificationRepository = planificationRepository;
    }

    public Planification saveNewPlanification(Planification planification) {
        return planificationRepository.save(planification);
    }

    public List<Planification> retrievePlanifications() {
        return planificationRepository.findAll();
    }

    public String deletePlanificationById(int planificationId) {
        planificationRepository.deleteById(planificationId);
        return "OK";
    }
}
