package com.cbar.orderhutbe.service;

import com.cbar.orderhutbe.exceptions.NoElementFoundException;
import com.cbar.orderhutbe.model.Waiter;
import com.cbar.orderhutbe.repository.WaiterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaiterService {
    private final WaiterRepository waiterRepository;

    public WaiterService(WaiterRepository waiterRepository) {
        this.waiterRepository = waiterRepository;
    }

    public Waiter saveNewWaiter(Waiter waiter) {
        return waiterRepository.save(waiter);
    }

    public List<Waiter> retrieveWaiters() {
        return waiterRepository.findAll();
    }

    public String deleteWaiterById(int waiterId) {
        waiterRepository.deleteById(waiterId);
        return "OK";
    }

    public Waiter editWaiter(int waiterId, Waiter waiter) {
        Waiter actualWaiter = waiterRepository.findById(waiterId)
                .orElseThrow(() -> new NoElementFoundException("Id not available!"));

        actualWaiter.setFullName(waiter.getFullName());
        actualWaiter.setPlanifications(waiter.getPlanifications());

        return  waiterRepository.save(actualWaiter);
    }
}
