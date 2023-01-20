package com.cbar.orderhutbe.model;

import jakarta.persistence.*;

@Entity
public class Planification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planificationId;

    @ManyToOne
    @JoinColumn(name = "waiter_id", nullable = false)
    private Waiter waiter;

    @OneToOne
    @JoinColumn(name = "table_id")
    private RestaurantTable actualRestaurantTable;

    public Planification() {
    }

    public Planification(int planificationId, Waiter waiter, RestaurantTable actualRestaurantTable) {
        this.planificationId = planificationId;
        this.waiter = waiter;
        this.actualRestaurantTable = actualRestaurantTable;
    }

    public int getPlanificationId() {
        return planificationId;
    }

    public void setPlanificationId(int planificationId) {
        this.planificationId = planificationId;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public RestaurantTable getActualTable() {
        return actualRestaurantTable;
    }

    public void setActualTable(RestaurantTable actualRestaurantTable) {
        this.actualRestaurantTable = actualRestaurantTable;
    }
}
