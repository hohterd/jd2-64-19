package by.it.academy.foodorder.service;

import by.it.academy.foodorder.food.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodServiceImpl implements FoodService {

    private static final FoodService INSTANCE = new FoodServiceImpl();

    private final List<Food> dishes;

    private FoodServiceImpl() {
        dishes = new ArrayList<>();
    }

    public static FoodService getService(){
        return INSTANCE;
    }

    @Override
    public List<Food> getAllDishes() {
        return dishes;
    }

    @Override
    public void addNewDishes(Food food) {
        food.setId((long) dishes.size() + 1);
        dishes.add(food);
    }

    @Override
    public void removeDish(long id) {
        for (Food dish : dishes) {
            if (dish.getId().equals(id)) {
                dishes.remove(dish);
            }
        }
    }

    @Override
    public void updateDish(Food food) {
        for (Food dish : dishes) {
            if (food.getId().equals(dish.getId())) {
                dishes.remove(dish);
                dishes.add(food);
            }
        }
    }


}
