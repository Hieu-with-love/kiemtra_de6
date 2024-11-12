package devzeus.com.kiemtra_ltweb_de6.service;

import devzeus.com.kiemtra_ltweb_de6.model.User;

import java.util.List;

public interface UserService_22110139 {
    boolean login(String username, String password);
    boolean register(User user);
    boolean createUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(String username);
    User findUserByName(String username);
    User findUserById(String userId);
    List<User> findAllUsers();
}
