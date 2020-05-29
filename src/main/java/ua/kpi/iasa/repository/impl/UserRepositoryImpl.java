package ua.kpi.iasa.repository.impl;

import ua.kpi.iasa.exception.UserAlreadyExists;
import ua.kpi.iasa.exception.UserNotFound;
import ua.kpi.iasa.model.entity.User;
import ua.kpi.iasa.repository.UserRepository;

import java.util.ArrayList;

public class UserRepositoryImpl implements UserRepository {

    private ArrayList<User> users;

    public UserRepositoryImpl() {
        users = new ArrayList<User>();
        users.add(new User(1, "vlad", "1234"));
        users.add(new User(2, "user", "pwd"));
        users.add(new User(3, "admin", "1111"));
    }

    public User getUserById(long id) throws UserNotFound {
        for(User user : users) {
            if(user.getId() == id) {
                return user;
            }
        }
        throw new UserNotFound();
    }

    public User updateUserById(long id, String username, String password) throws UserNotFound {
        for(User user : users) {
            if(user.getId() == id) {
                user.setId(id);
                user.setUsername(username);
                user.setPassword(password);
                return user;
            }
        }
        throw new UserNotFound();
    }

    public boolean deleteUserById(long id) throws UserNotFound {
        for(User user : users) {
            if(user.getId() == id) {
                users.remove(user);
                return true;
            }
        }
        throw new UserNotFound();
    }

    public User addUser(long id, String username, String password) throws UserAlreadyExists {
        for (User user : users){
            if (user.getId() == id) {
                throw new UserAlreadyExists();
            }
        }

        User user = new User(id, username, password);
        users.add(user);

        return user;
    }

    public int count() {
        return users.size();
    }
}
