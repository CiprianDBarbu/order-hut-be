package com.cbar.orderhutbe.model;

import com.cbar.orderhutbe.serializer.CustomDishSerializer;
import com.cbar.orderhutbe.serializer.CustomOrderSerializer;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "orderId")
public class FinalOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private float totalPrice;

    private Date orderTime;

    private OrderStatus orderStatus;

    private String comments;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client orderClient;

    @OneToOne
    @JoinColumn(name = "planification_id")
    private Planification planification;

    @ManyToMany
    @JoinTable(name = "dish_order", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "dish_id"))
    @JsonSerialize(using = CustomDishSerializer.class)
    private List<Dish> dishList = new ArrayList<>();

    public FinalOrder() {
    }

    public FinalOrder(int orderId, Date orderTime, OrderStatus orderStatus, String comments, Client orderClient, Planification planification, List<Dish> dishList) {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.comments = comments;
        this.orderClient = orderClient;
        this.planification = planification;
        this.dishList = dishList;
        this.totalPrice = 0;
        for (Dish dish : dishList) {
            this.totalPrice += dish.getPrice();
        }
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Client getOrderClient() {
        return orderClient;
    }

    public void setOrderClient(Client orderClient) {
        this.orderClient = orderClient;
    }

    public Planification getPlanification() {
        return planification;
    }

    public void setPlanification(Planification planification) {
        this.planification = planification;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }
}
