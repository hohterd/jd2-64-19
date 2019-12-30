package by.it.academy.foodorder.dao.impl;

import by.it.academy.foodorder.dao.FoodDao;
import by.it.academy.foodorder.models.Food;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FoodDaoImpl extends AbstractDao implements FoodDao {

    private static final FoodDaoImpl INSTANCE = new FoodDaoImpl();

    public static final String INSERT_DISH = "INSERT INTO dish (dish_name, ingredients, weight, cooking_time, price) VALUE (?,?,?,?,?)";
    public static final String SELECT_DISH_BY_ID = "SELECT * FROM dish WHERE id = ?";
    public static final String SELECT_ALL_DISH = "SELECT * FROM dish";
    public static final String UPDATE_DISH = "UPDATE dish SET dish_name = ? , ingredients = ?, weight = ?, cooking_time = ?, price = ? WHERE id = ?";
    public static final String DELETE_DISH_BY_ID = "DELETE FROM dish WHERE id = ?";

    private FoodDaoImpl() {
        super(LoggerFactory.getLogger(FoodDaoImpl.class));
    }

    public static FoodDao getInstance() {
        return INSTANCE;
    }

    @Override
    public Long create(Food food) throws SQLException {
        ResultSet resultSet = null;
        Long result = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_DISH, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, food.getName());
            statement.setString(2, food.getIngredients());
            statement.setLong(3, food.getWeight());
            statement.setLong(4, food.getCookingTime());
            statement.setLong(5, food.getPrice());

            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();

            while (resultSet.next()) {
                result = resultSet.getLong(1);
            }
        } finally {
            closeQuietly(resultSet);
        }
        return result;
    }

    @Override
    public Optional<Food> read(Long id) throws SQLException {
        ResultSet resultSet = null;
        Optional<Food> result = Optional.empty();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_DISH_BY_ID)) {

            statement.setLong(1, id);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                result = Optional.of(mapFood(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return result;
    }

    @Override
    public int update(Food food) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_DISH)) {

            statement.setString(1, food.getName());
            statement.setString(2, food.getIngredients());
            statement.setLong(3, food.getWeight());
            statement.setLong(4, food.getCookingTime());
            statement.setLong(5, food.getPrice());
            statement.setLong(6,food.getId());

            return statement.executeUpdate();
        }
    }

    @Override
    public int delete(Long id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_DISH_BY_ID)) {
            statement.setLong(1, id);
            return statement.executeUpdate();
        }
    }

    @Override
    public List<Food> getAll() throws SQLException {
        ResultSet resultSet = null;
        List<Food> result = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_DISH)) {

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(mapFood(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return result;
    }

    private Food mapFood(ResultSet resultSet) throws SQLException {
        Long foodId = resultSet.getLong("dish_id");
        String name = resultSet.getString("dish_name");
        String ingredients = resultSet.getString("ingredients");
        Long weight = resultSet.getLong("weight");
        Long cookingTime = resultSet.getLong("cooking_time");
        Long price = resultSet.getLong("price");
        return new Food(foodId, name, ingredients, weight, cookingTime, price);
    }

}
