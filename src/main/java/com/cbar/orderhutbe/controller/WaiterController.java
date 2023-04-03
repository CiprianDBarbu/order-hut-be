package com.cbar.orderhutbe.controller;

import com.cbar.orderhutbe.model.Waiter;
import com.cbar.orderhutbe.service.WaiterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/waiter")
@CrossOrigin(origins = "http://localhost:4200")
public class WaiterController {
    private final WaiterService waiterService;

    public WaiterController(WaiterService waiterService) {
        this.waiterService = waiterService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Waiter>> retrieveWaiters() {
        return ResponseEntity.ok()
                .body(waiterService.retrieveWaiters());
    }

    @GetMapping("/{waiterId}")
    public ResponseEntity<Waiter> retrieveWaiterById(@PathVariable int waiterId) {
        return ResponseEntity.ok()
                .body(waiterService.retrieveWaiterById(waiterId));
    }

    @PostMapping("/new")
    public ResponseEntity<Waiter> saveNewWaiter(@RequestBody Waiter waiter) {
        return ResponseEntity.created(URI.create("/waiter" + waiter.getWaiterId()))
                .body(waiterService.saveNewWaiter(waiter));
    }

    @PutMapping("/{waiterId}")
    public ResponseEntity<Waiter> editWaiter(@PathVariable int waiterId,
                                             @RequestBody Waiter waiter) {
        return ResponseEntity.created(URI.create("/waiter" + waiterId))
                .body(waiterService.editWaiter(waiterId, waiter));
    }

    @DeleteMapping("/{waiterId}")
    public ResponseEntity<String> deleteWaiterById(@PathVariable int waiterId) {
        return ResponseEntity.ok()
                .body(waiterService.deleteWaiterById(waiterId));
    }
}
