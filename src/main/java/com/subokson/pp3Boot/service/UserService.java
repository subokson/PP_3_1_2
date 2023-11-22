package com.subokson.pp3Boot.service;


import com.subokson.pp3Boot.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(Long id, User user);

    User getUserById(Long id);
}
