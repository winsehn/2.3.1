package web.repository;

import web.model.User;

import java.util.List;

public interface UsersRepository {
    void addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    List<User> getAllUsers();
}
