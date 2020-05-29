package ua.kpi.iasa.repository;

import ua.kpi.iasa.exception.UserAlreadyExists;
import ua.kpi.iasa.exception.UserNotFound;
import ua.kpi.iasa.model.entity.User;

public interface UserRepository {

    User getUserById(long id) throws UserNotFound;

    User updateUserById(long id, String name, String password) throws UserNotFound;

    boolean deleteUserById(long id) throws UserNotFound;

    User addUser(long id, String username, String password) throws UserAlreadyExists;

    int count();
}
