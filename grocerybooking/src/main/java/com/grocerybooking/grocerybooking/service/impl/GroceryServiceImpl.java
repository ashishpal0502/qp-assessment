package com.grocerybooking.grocerybooking.service.impl;

import com.grocerybooking.grocerybooking.dto.GroceryDto;
import com.grocerybooking.grocerybooking.entity.Grocery;
import com.grocerybooking.grocerybooking.exception.GroceryItemNotFoundException;
import com.grocerybooking.grocerybooking.repository.GroceryRepository;
import com.grocerybooking.grocerybooking.service.GroceryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class GroceryServiceImpl implements GroceryService {
    private GroceryRepository groceryRepository;
    private ModelMapper modelMapper;

    @Override
    public GroceryDto addGroceryItem(GroceryDto groceryDto) {
        Grocery grocery = modelMapper.map(groceryDto, Grocery.class);
        Grocery savedGrocery = groceryRepository.save(grocery);
        GroceryDto savedGroceryDto = modelMapper.map(savedGrocery, GroceryDto.class);
        return savedGroceryDto;
    }

    @Override
    public GroceryDto viewGroceryItem(Long id) {
        Grocery grocery = groceryRepository.findById(id).orElseThrow(() -> new GroceryItemNotFoundException("Item not found with id:" + id));
        GroceryDto groceryDto = modelMapper.map(grocery, GroceryDto.class);
        return groceryDto;
    }

    @Override
    public List<GroceryDto> viewAllGroceryItems() {
        List<Grocery> groceries = groceryRepository.findAll();
        return groceries.stream().map((todo) -> modelMapper.map(todo, GroceryDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteGroceryItem(Long id) {
        Grocery grocery = groceryRepository.findById(id).orElseThrow(() -> new GroceryItemNotFoundException("Item not found with id:" + id));
        groceryRepository.deleteById(id);
    }

    @Override
    public GroceryDto updateGroceryDetails(GroceryDto groceryDto, Long id) {
        Grocery grocery = groceryRepository.findById(id).orElseThrow(() -> new GroceryItemNotFoundException("Grocery Not found with id:" + id));
        grocery.setId(id);
        grocery.setName(groceryDto.getName());
        grocery.setPrice(groceryDto.getPrice());
        grocery.setInventory(groceryDto.getInventory());
        Grocery savedGrocery = groceryRepository.save(grocery);
        GroceryDto savedGroceryDto = modelMapper.map(savedGrocery, GroceryDto.class);
        return savedGroceryDto;
    }

    @Override
    public GroceryDto addInventory(Long id) {
        Grocery grocery = groceryRepository.findById(id).orElseThrow(() -> new GroceryItemNotFoundException("Item not found with id:" + id));
        grocery.setInventory(grocery.getInventory() + 1);
        Grocery savedGrocery = groceryRepository.save(grocery);
        return modelMapper.map(savedGrocery, GroceryDto.class);
    }

    @Override
    public GroceryDto reduceInventory(Long id) {
        Grocery grocery = groceryRepository.findById(id).orElseThrow(() -> new GroceryItemNotFoundException("Item not found with id:" + id));
        grocery.setInventory(grocery.getInventory() - 1);
        Grocery savedGrocery = groceryRepository.save(grocery);
        return modelMapper.map(savedGrocery, GroceryDto.class);
    }
}
