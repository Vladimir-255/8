package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getAllUsers();
    void deleteUser(Long id);
    User getByID(long id);
    void updateUser(User user, Long id);

    }

