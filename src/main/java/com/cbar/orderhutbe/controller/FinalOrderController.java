package com.cbar.orderhutbe.controller;

import com.cbar.orderhutbe.model.FinalOrder;
import com.cbar.orderhutbe.service.FinalOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/order")
public class FinalOrderController {
    private final FinalOrderService orderService;

    public FinalOrderController(FinalOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<FinalOrder>> retrieveOrders() {
        return ResponseEntity.ok()
                .body(orderService.retrieveOrders());
    }

    @PostMapping("/new")
    public ResponseEntity<FinalOrder> saveNewOrder(@RequestBody FinalOrder order) {
        return ResponseEntity.created(URI.create("/order" + order.getOrderId()))
                .body(orderService.saveNewOrder(order));
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<FinalOrder> editOrder(@PathVariable int orderId,
                                                @RequestBody FinalOrder order) {
        return ResponseEntity.created(URI.create("/order" + orderId))
                .body(orderService.editOrder(orderId, order));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrderById(@PathVariable int orderId) {
        return ResponseEntity.ok()
                .body(orderService.deleteOrderById(orderId));
    }
}
