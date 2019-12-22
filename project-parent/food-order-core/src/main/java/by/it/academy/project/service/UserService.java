package by.it.academy.project.service;


import by.it.academy.project.models.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUser(String login, String password);

}
