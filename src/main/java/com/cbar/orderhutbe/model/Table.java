package com.cbar.orderhutbe.model;

import jakarta.persistence.*;

@Entity
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tableId;

    private int servingZone;

    private int numberOfSeats;

    public Table() {
    }

    public Table(int tableId, int servingZone, int numberOfSeats) {
        this.tableId = tableId;
        this.servingZone = servingZone;
        this.numberOfSeats = numberOfSeats;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getServingZone() {
        return servingZone;
    }

    public void setServingZone(int servingZone) {
        this.servingZone = servingZone;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
