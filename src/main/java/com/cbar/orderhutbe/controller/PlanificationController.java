package com.cbar.orderhutbe.controller;

import com.cbar.orderhutbe.model.Planification;
import com.cbar.orderhutbe.service.PlanificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/planification")
@CrossOrigin(origins = "http://localhost:4200")
public class PlanificationController {
    private final PlanificationService planificationService;

    public PlanificationController(PlanificationService planificationService) {
        this.planificationService = planificationService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Planification>> retrievePlanifications() {
        return ResponseEntity.ok()
                .body(planificationService.retrievePlanifications());
    }

    @GetMapping("/{planificationId}")
    public ResponseEntity<Planification> retrievePlanificationById(@PathVariable int planificationId) {
        return ResponseEntity.ok()
                .body(planificationService.retrievePlanificationById(planificationId));
    }

    @PostMapping("/new")
    public ResponseEntity<Planification> saveNewPlanification(@RequestBody Planification planification) {
        return ResponseEntity.created(URI.create("/planification" + planification.getPlanificationId()))
                .body(planificationService.saveNewPlanification(planification));
    }

    @PutMapping("/{planificationId}")
    public ResponseEntity<Planification> editPlanification(@PathVariable int planificationId,
                                                           @RequestBody Planification planification) {
        return ResponseEntity.created(URI.create("/planification" + planificationId))
                .body(planificationService.editPlanification(planificationId, planification));
    }

    @DeleteMapping("/{planificationId}")
    public ResponseEntity<String> deletePlanificationById(@PathVariable int planificationId) {
        return ResponseEntity.ok()
                .body(planificationService.deletePlanificationById(planificationId));
    }
}
