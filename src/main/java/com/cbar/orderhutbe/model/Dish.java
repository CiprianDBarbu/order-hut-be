package com.cbar.orderhutbe.model;

import com.cbar.orderhutbe.serializer.CustomDishSerializer;
import com.cbar.orderhutbe.serializer.CustomOrderSerializer;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "dishId")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dishId;

    private String dishName;

    private float price;

    private String category;

    private String imageUrl;

    private String dishDescription;

    @ManyToMany(mappedBy = "dishList")
    @JsonSerialize(using = CustomOrderSerializer.class)
    private List<FinalOrder> finalOrderList = new ArrayList<>();

    public Dish() {
    }

    public Dish(int dishId, String dishName, float price, String category, String imageUrl, String dishDescription, List<FinalOrder> finalOrderList) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.price = price;
        this.category = category;
        this.imageUrl = imageUrl;
        this.dishDescription = dishDescription;
        this.finalOrderList = finalOrderList;
    }

    public Dish(int dishId, String dishName, float price, String category, String imageUrl, String dishDescription) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.price = price;
        this.category = category;
        this.imageUrl = imageUrl;
        this.dishDescription = dishDescription;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public List<FinalOrder> getOrderList() {
        return finalOrderList;
    }

    public void setOrderList(List<FinalOrder> finalOrderList) {
        this.finalOrderList = finalOrderList;
    }
}
