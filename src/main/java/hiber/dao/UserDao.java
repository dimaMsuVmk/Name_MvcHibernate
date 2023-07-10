package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
//    void add(User user);

    List<User> getAllUsers();

    User getUserById(long id);
    void updateUser(User updateUser);

    void removeUserById(long id);
    void save(User user);
}