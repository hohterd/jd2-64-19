package by.it.academy.foodorder.service;

import by.it.academy.foodorder.food.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class FoodServiceImpl implements FoodService {

    private static final FoodService INSTANCE = new FoodServiceImpl();

    private final List<Food> dishes;

    private AtomicLong id = new AtomicLong();

    private FoodServiceImpl() {
        dishes = new ArrayList<>();
    }

    public static FoodService getService(){
        return INSTANCE;
    }

    @Override
    public List<Food> getAllDishes() {
        return new ArrayList<>(dishes);
    }

    @Override
    public void addNewDishes(Food food) {
        food.setId(id.incrementAndGet());
        dishes.add(food);
    }

    @Override
    public void removeDish(long id) {
        for (Food dish : dishes) {
            if (dish.getId().equals(id)) {
                dishes.remove(dish);
                break;
            }
        }
    }

    @Override
    public void updateDish(Food food) {
        for (Food dish : dishes) {
            if (food.getId().equals(dish.getId())) {
                dishes.remove(dish);
                dishes.add(food);
                break;
            }
        }
    }


}
