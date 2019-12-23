package by.it.academy.foodorder.service;

import by.it.academy.foodorder.models.User;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class UserServiceImpl implements UserService {


    private static final UserService INSTANCE = new UserServiceImpl();
    private final Map<String, User> users = new ConcurrentHashMap<>();

    private UserServiceImpl() {
        users.put("admin", new User("admin", "qwerty", "admin"));
        users.put("user", new User("user", "12345", "user"));
    }

    public static UserService getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<User> findUser(String login, String password) {
        User user = users.get(login);
        if (user != null && password.equals(user.getPassword())) {
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }
}
