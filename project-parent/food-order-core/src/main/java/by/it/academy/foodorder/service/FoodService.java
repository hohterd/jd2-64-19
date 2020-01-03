package by.it.academy.foodorder.service;

import by.it.academy.foodorder.models.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    List<Food> getAllDishes();

    Optional<Food> getById(Long id);

    Food addNewDishes(Food food);

    void removeDish(Long id);

    Food updateDish(Food food);
}
