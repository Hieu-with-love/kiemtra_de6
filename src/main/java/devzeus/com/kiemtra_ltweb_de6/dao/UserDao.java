package devzeus.com.kiemtra_ltweb_de6.dao;

import devzeus.com.kiemtra_ltweb_de6.model.User;

import java.util.*;

public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    void deleteUser(String username);
}
