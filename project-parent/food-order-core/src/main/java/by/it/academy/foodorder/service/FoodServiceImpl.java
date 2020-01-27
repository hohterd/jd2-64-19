package by.it.academy.foodorder.service;

import by.it.academy.foodorder.dao.FoodDao;
import by.it.academy.foodorder.dao.impl.FoodDaoImpl;
import by.it.academy.foodorder.models.Food;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FoodServiceImpl implements FoodService {

    private static final Logger logger = LoggerFactory.getLogger(FoodServiceImpl.class);
    private static final FoodService INSTANCE = new FoodServiceImpl();

    private final FoodDao foodDao = FoodDaoImpl.getInstance();

    private FoodServiceImpl() {
    }

    public static FoodService getService() {
        return INSTANCE;
    }

    @Override
    public List<Food> getAllDishes() {
        logger.debug("Get all dishes");
        try {
            return foodDao.getAll();
        } catch (SQLException e) {
            logger.error("Error while getting all dishes", e);
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<Food> getById(Long id) {
        logger.debug("Get dish by id {}", id);
        try {
            Optional<Food> dish = foodDao.read(id);
            logger.debug("result {}", dish);
            return dish;
        } catch (SQLException e) {
            logger.error("Error while getting dishes by id " + id, e);
        }
        return Optional.empty();
    }

    @Override
    public Food addNewDishes(Food dish) {
        logger.debug("add new dish {}", dish);
        try {
            Long id = foodDao.create(dish);
            dish.setId(id);
            logger.debug("result {}", id);
        } catch (SQLException e) {
            logger.error("Error while creating dish " + dish, e);
        }
        return dish;
    }

    @Override
    public void removeDish(Long id) {
        logger.debug("deleting dish id = {}", id);
        try {
            int delete = foodDao.delete(id);
            logger.debug("result {}", delete);
        } catch (SQLException e) {
            logger.error("Error while deleting dish id=" + id, e);
        }
    }

    @Override
    public Food updateDish(Food dish) {
        logger.debug("updating dish {}", dish);
        try {
            int update = foodDao.update(dish);
            logger.debug("result {}", update);
        } catch (SQLException e) {
            logger.error("Error while updating dish " + dish, e);
        }
        return dish;
    }


}
