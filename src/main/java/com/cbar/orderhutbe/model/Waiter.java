package com.cbar.orderhutbe.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Waiter {
    @Id
    @Column(name = "waiterId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int waiterId;

    private String fullName;

    @OneToMany(mappedBy = "waiter")
    private List<Planification> planifications = new ArrayList<>();

    public Waiter() {
    }

    public Waiter(int waiterId, String fullName, List<Planification> planifications) {
        this.waiterId = waiterId;
        this.fullName = fullName;
        this.planifications = planifications;
    }

    public int getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(int waiterId) {
        this.waiterId = waiterId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Planification> getPlanifications() {
        return planifications;
    }

    public void setPlanifications(List<Planification> planifications) {
        this.planifications = planifications;
    }
}
