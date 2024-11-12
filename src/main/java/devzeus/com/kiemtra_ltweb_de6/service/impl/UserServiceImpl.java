package devzeus.com.kiemtra_ltweb_de6.service.impl;

import devzeus.com.kiemtra_ltweb_de6.dao.UserDao;
import devzeus.com.kiemtra_ltweb_de6.dao.impl.UserDaoImpl;
import devzeus.com.kiemtra_ltweb_de6.model.User;
import devzeus.com.kiemtra_ltweb_de6.service.UserService;

import java.util.*;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean login(String username, String password) {
        try {
            User user = userDao.getUserByUsername(username);
            if (user != null && Objects.equals(user.getPassword(), password)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean register(User user) {
        try {
            // Check if the user already exists
            if (userDao.getUserByUsername(user.getUsername()) == null) {
                userDao.addUser(user);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean createUser(User user) {
        try {
            userDao.addUser(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        try {
            User existingUser = userDao.getUserByUsername(user.getUsername());
            if (existingUser != null) {
                userDao.updateUser(user);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(String username) {
        try {
            User existingUser = userDao.getUserByUsername(username);
            if (existingUser != null) {
                userDao.deleteUser(username);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findUserByName(String username) {
        try {
            return userDao.getUserByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findUserById(String userId) {
        try {
            return userDao.getUserByUsername(userId); // Assuming username is used as userId
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.getAllUsers();
    }
}
