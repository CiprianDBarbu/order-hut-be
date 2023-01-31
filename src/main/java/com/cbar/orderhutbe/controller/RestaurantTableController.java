package com.cbar.orderhutbe.controller;

import com.cbar.orderhutbe.model.RestaurantTable;
import com.cbar.orderhutbe.service.RestaurantTableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/table")
public class RestaurantTableController {
    private final RestaurantTableService tableService;

    public RestaurantTableController(RestaurantTableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<RestaurantTable>> retrieveTables() {
        return ResponseEntity.ok()
                .body(tableService.retrieveTables());
    }

    @GetMapping("/{tableId}")
    public ResponseEntity<RestaurantTable> retrieveTableById(@PathVariable int tableId) {
        return ResponseEntity.ok()
                .body(tableService.retrieveTableById(tableId));
    }

    @PostMapping("/new")
    public ResponseEntity<RestaurantTable> saveNewTable(@RequestBody RestaurantTable table) {
        return ResponseEntity.created(URI.create("/table" + table.getTableId()))
                .body(tableService.saveNewTable(table));
    }

    @PutMapping("/{tableId}")
    public ResponseEntity<RestaurantTable> editTable(@PathVariable int tableId,
                                                     @RequestBody RestaurantTable table) {
        return ResponseEntity.created(URI.create("/table" + tableId))
                .body(tableService.editTable(tableId, table));
    }

    @DeleteMapping("/{tableId}")
    public ResponseEntity<String> deleteTableById(@PathVariable int tableId) {
        return ResponseEntity.ok()
                .body(tableService.deleteTableById(tableId));
    }
}
