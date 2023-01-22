package com.cbar.orderhutbe.service;

import com.cbar.orderhutbe.exceptions.NoElementFoundException;
import com.cbar.orderhutbe.model.FinalOrder;
import com.cbar.orderhutbe.repository.FinalOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalOrderService {
    private final FinalOrderRepository finalOrderRepository;

    public FinalOrderService(FinalOrderRepository finalOrderRepository) {
        this.finalOrderRepository = finalOrderRepository;
    }

    public FinalOrder saveNewOrder(FinalOrder order) {
        return finalOrderRepository.save(order);
    }

    public List<FinalOrder> retrieveOrders() {
        return finalOrderRepository.findAll();
    }

    public String deleteOrderById(int orderId) {
        finalOrderRepository.deleteById(orderId);
        return "OK";
    }

    public FinalOrder editOrder(int orderId, FinalOrder order) {
        FinalOrder actualOrder = finalOrderRepository.findById(orderId)
                .orElseThrow(() -> new NoElementFoundException("Id not available!"));

        actualOrder.setTotalPrice(order.getTotalPrice());
        actualOrder.setOrderTime(order.getOrderTime());
        actualOrder.setOrderStatus(order.getOrderStatus());
        actualOrder.setComments(order.getComments());
        actualOrder.setOrderClient(order.getOrderClient());
        actualOrder.setPlanification(order.getPlanification());
        actualOrder.setDishList(order.getDishList());

        return finalOrderRepository.save(actualOrder);
    }
}
