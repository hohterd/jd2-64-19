package by.it.academy.foodorder.service;


import by.it.academy.foodorder.models.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUser(String login, String password);

}
