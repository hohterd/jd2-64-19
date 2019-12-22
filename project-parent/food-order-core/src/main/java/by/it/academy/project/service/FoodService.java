package by.it.academy.project.service;

import by.it.academy.project.models.Food;

import java.util.List;

public interface FoodService {
    List<Food> getAllDishes();

    void addNewDishes(Food food);

    void removeDish(long id);

    void updateDish(Food food);
}
