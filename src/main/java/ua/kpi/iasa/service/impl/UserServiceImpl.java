package ua.kpi.iasa.service.impl;

import ua.kpi.iasa.exception.UserAlreadyExists;
import ua.kpi.iasa.exception.UserNotFound;
import ua.kpi.iasa.model.entity.User;
import ua.kpi.iasa.repository.UserRepository;
import ua.kpi.iasa.repository.impl.UserRepositoryImpl;
import ua.kpi.iasa.service.UserService;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "ua.kpi.iasa.service.UserService")
public class UserServiceImpl implements UserService {

    @Inject
    private final UserRepository userRepository;

    public UserServiceImpl() {
        userRepository = new UserRepositoryImpl();
    }

    @WebMethod
    public User getUserById(long id) throws UserNotFound {
        return userRepository.getUserById(id);
    }

    @WebMethod
    public User updateUserById(long id, String username, String password) throws UserNotFound {
        return userRepository.updateUserById(id, username, password);
    }

    @WebMethod
    public boolean deleteUserById(long id) throws UserNotFound {
        return userRepository.deleteUserById(id);
    }

    @WebMethod
    public User addUser(long id, String username, String password) throws UserAlreadyExists {
        return userRepository.addUser(id, username, password);
    }

    @WebMethod
    public int countUsers() {
        return userRepository.count();
    }
}
