package com.grocerybooking.grocerybooking.controller;

import com.grocerybooking.grocerybooking.dto.GroceryDto;
import com.grocerybooking.grocerybooking.service.GroceryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/grocery")
@AllArgsConstructor
public class GroceryController {
    private GroceryService groceryService;

    //Build addTodo REST API
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<GroceryDto> addGroceryItem(@RequestBody GroceryDto groceryDto) {
        GroceryDto savedGrocery = groceryService.addGroceryItem(groceryDto);
        return new ResponseEntity<>(savedGrocery, HttpStatus.CREATED);
    }

    //build getTodo REST API
    @GetMapping("{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<GroceryDto> viewGroceryItem(@PathVariable("id") Long groceryId) {
        GroceryDto groceryDto = groceryService.viewGroceryItem(groceryId);
        return new ResponseEntity<>(groceryDto, HttpStatus.OK);
    }

    //build getAllTodos REST API
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<List<GroceryDto>> viewAllGroceryItem() {
        List<GroceryDto> groceryDtos = groceryService.viewAllGroceryItems();
//        return new ResponseEntity<>(todoDtos,HttpStatus.OK);
        return ResponseEntity.ok(groceryDtos);
    }

    //build updateTodo REST API

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<GroceryDto> updateGroceryDetails(@RequestBody GroceryDto groceryDto, @PathVariable("id") Long groceryId) {
        GroceryDto updatedGrocery = groceryService.updateGroceryDetails(groceryDto, groceryId);
        return ResponseEntity.ok(updatedGrocery);
    }


    //build deleteTodo REST API
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteGroceryItem(@PathVariable("id") Long groceryId) {
        groceryService.deleteGroceryItem(groceryId);
        return ResponseEntity.ok("Item deleted successfully!");
    }

    //build deleteTodo REST API
    @DeleteMapping("{id}/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addInventory(@PathVariable("id") Long groceryId) {
        groceryService.addInventory(groceryId);
        return ResponseEntity.ok("Inventory increased!");
    }

    //build deleteTodo REST API
    @DeleteMapping("{id}/reduce")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> reduceInventory(@PathVariable("id") Long groceryId) {
        groceryService.reduceInventory(groceryId);
        return ResponseEntity.ok("Inventory decreased!");
    }
}
