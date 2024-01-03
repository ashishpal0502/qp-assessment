package com.grocerybooking.grocerybooking.service;

import com.grocerybooking.grocerybooking.dto.GroceryDto;

import java.util.List;

public interface GroceryService {
    GroceryDto addGroceryItem(GroceryDto groceryDto);

    GroceryDto viewGroceryItem(Long id);

    List<GroceryDto> viewAllGroceryItems();

    void deleteGroceryItem(Long id);

    GroceryDto updateGroceryDetails(GroceryDto groceryDto, Long id);

    GroceryDto addInventory(Long id);

    GroceryDto reduceInventory(Long id);
}
