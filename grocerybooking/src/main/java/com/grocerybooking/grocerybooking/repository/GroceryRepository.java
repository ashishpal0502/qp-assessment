package com.grocerybooking.grocerybooking.repository;


import com.grocerybooking.grocerybooking.entity.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryRepository extends JpaRepository<Grocery,Long> {
}
